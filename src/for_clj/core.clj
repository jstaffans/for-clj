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

