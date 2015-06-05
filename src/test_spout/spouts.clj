(ns test-spout.spouts
  "Spouts.

More info on the Clojure DSL here:

https://github.com/nathanmarz/storm/wiki/Clojure-DSL"
  (:require [backtype.storm [clojure :refer [defspout spout emit-spout!]]])
  (:use [backtype.storm clojure config log])
)

(def id-count (atom 0)) ;; tuple counter for debugging -- something to make ids out of

(defspout type-spout ["type"]
  [conf context collector]
  (let [stormys [:regular :bizarro]]
    (spout
     (nextTuple []
       (Thread/sleep 100)
       (let [id (swap! id-count inc)]
        (emit-spout! collector [(rand-nth stormys)] :id id))) 
      (ack [id]
        (log-message "Acking " id))
     (fail [id]
        (log-message "Failing " id)))))
