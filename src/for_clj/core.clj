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
  [x]
  x)