# A Reliable Spout in Clojure

An example of how to do write reliable spouts in storm with clojure.
This takes the default scaffolding provided by https://github.com/travis/lein-storm-project-template and 
uses it to make a fully reliable (acks come back to the spout) topology.


Having just started playing with both clojure and storm I thought this might be useful for some. It's also an example of a fully functionaly storm topology that you can play with. I was having issues getting my more complex topology to ack and decided to try from a simple example. 

## Usage

To run on a local cluster:

```bash
lein run -m test-spout.topology/run!
# OR
lein run -m test-spout.topology/run! debug false workers 10
```

To run on a distributed cluster:

```bash
lein uberjar
# copy jar to nimbus, and then on nimbus:
bin/storm jar path/to/uberjar.jar test-spout.TopologySubmitter workers 30 debug false
```

or use `[storm-deploy](https://github.com/nathanmarz/storm-deploy/wiki)`

## License

Copyright © 2015 Rick Mangi

Distributed under the Eclipse Public License, the same as Clojure.
