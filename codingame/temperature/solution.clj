(ns Solution
  (:gen-class))

(defn n-read->vec [n]
  (loop [i n
         res []]
    (if (<= i 0)
        res
        (let [t (read)]
          (recur (dec i) (conj res t))))))

(defn abs [x]
  (if (< x 0)
    (* x -1)
    x))

(defn abs-min [x y]
  (let [abs-x (abs x)
        abs-y (abs y)]
    (if (= abs-x abs-y)
      (max x y)
      (if (< abs-x abs-y)
        x
        y))))

(defn closest-to-zero [v]
  (loop [[p & ps] (rest v)
         min (first v)]
    (if (nil? p)
      (if (nil? min)
        0
        min)
      (recur ps (abs-min p min)))))

(defn closest-v2 [v]
  (let [[x & xs] v]
    (if (nil? x)
      0
      (reduce abs-min x xs))))

(defn -main [& args]
  (let [n (read)]
    (->> n
        (n-read->vec)
        (closest-to-zero)
        (println))))
