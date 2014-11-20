(ns for-clj.t-core
  (:use midje.sweet
        for-clj.core))

(facts "about partitioning a sequence"
       (my-partition 1) => 1)