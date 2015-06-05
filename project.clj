(defproject test-spout "0.1.0-SNAPSHOT"
  :dev-dependencies [[org.apache.storm/storm-core "0.9.5"] [org.clojure/clojure "1.6.0"] ]

  :aot [test-spout.TopologySubmitter]
  ;; include storm dependency only in dev because production storm cluster provides it
  :profiles { 
             :provided {:dependencies [[org.apache.storm/storm-core "0.9.5"]]}
})
