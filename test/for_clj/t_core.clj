(ns for-clj.t-core
  (:use midje.sweet
        for-clj.core))

(facts "about partitioning a sequence"
  (my-partition 3 (range 3)) => '((0 1 2))
  (my-partition 3 (range 4)) => '((0 1 2))
  (my-partition 3 (range 6)) => '((0 1 2) (3 4 5))
  (my-partition 3 (range 9)) => '((0 1 2) (3 4 5) (6 7 8)))
