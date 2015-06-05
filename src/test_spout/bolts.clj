(ns test-spout.bolts
  "Bolts.

More info on the Clojure DSL here:

https://github.com/nathanmarz/storm/wiki/Clojure-DSL"
  (:require [backtype.storm [clojure :refer [emit-bolt! defbolt ack! bolt]]])
  (:use [backtype.storm clojure config log])
)

(defbolt stormy-bolt ["stormy"] [{type :type :as tuple} collector]
  (emit-bolt! collector [(case type
                           :regular "I'm regular Stormy!"
                           :bizarro "I'm bizarro Stormy!"
                           "I have no idea what I'm doing.")]
              :anchor tuple)
  (ack! collector tuple))

(defbolt test_spout-bolt ["message"] [{stormy :stormy :as tuple} collector]
  ;(emit-bolt! collector [(str "test_spout produced: "stormy)] :anchor tuple)
  (log-message "test_spout produced: " stormy)
  (ack! collector tuple))
