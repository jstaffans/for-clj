(ns for-clj.core)


; 58
(defn my-comp [& fs]
  (let [[f & r] (reverse fs)]
    (fn [& args]
      (reduce (fn [acc f] (f acc)) (apply f args) r))))


; 59
(defn my-juxt [& fs]
  (fn [& args]
    (reduce (fn [acc f] (conj acc (apply f args))) [] fs)))


; 60
(defn my-reductions
  ([f coll] (my-reductions f (first coll) (rest coll)))
  ([f init coll]
   (cons init
         (when-let [s (seq coll)]
           (lazy-seq (my-reductions f (f init (first s)) (rest s)))))))

; 54
(defn my-partition
  [n coll]
  (when (seq coll)
    (let [[p rest] (filter #(<= n (count %)) (split-at n coll))]
      (cons p (my-partition n rest)))))

; 70
(defn word-sort
  [s]
  (->> (re-seq #"\w+" s)
       (sort-by clojure.string/lower-case)))

; 77

(defn permutations
  ([word]
   (permutations "" word))
  ([prefix word]
   (if (= 1 (count word))
     [(str prefix word)]
     (flatten
       (for [i (range (count word))]
         (let [cur (.charAt word i)
               before (subs word 0 i)
               after (subs word (inc i))]
           (permutations (str prefix cur) (str before after))))))))

; But actually we don't need permutations to find anagrams!

(defn to-anagram-sets
  [coll]
  (->> (group-by #(sort %) coll)
       (filter #(> (count (second %)) 1))
       vals (map set) set))


