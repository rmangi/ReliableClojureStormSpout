(ns test-spout.TopologySubmitter
  (:require [test-spout.topology :refer [stormy-topology]]
            [backtype.storm [config :refer :all]])
  (:import [backtype.storm StormSubmitter])
  (:gen-class))

(defn -main [& {debug "debug" workers "workers" :or {debug "false" workers "4"}}]
  (StormSubmitter/submitTopology
   "test_spout topology"
   {TOPOLOGY-DEBUG (Boolean/parseBoolean debug)
    TOPOLOGY-WORKERS (Integer/parseInt workers)}
   (stormy-topology)))
