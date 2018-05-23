(ns kata.core
  (:gen-class))

(defn extract-suites [s]
  (loop [[x & xs :as remaining] s
         suite []
         all-suites []]
    (if (empty? remaining)
        (conj all-suites suite)
        (if (< (or (last suite) -1) x)
            (recur xs (conj suite x) all-suites)
            (recur xs [x] (conj all-suites suite))))))

(defn longest-seq [s]
  "53. Find the longest increasing Sub-Seq."
  (let [suites (extract-suites s)]
   (reduce (fn [acc seq]
             (if (and (> (count seq) (count acc))
                      (> (count seq) 1))
                 seq
                 acc))
           [] suites)))

(defn calc-factorial [n]
  "42. Calculates factorials. Only until 20!"
  (apply * (rest (range (inc n)))))

(defn drop-nth-items [xs n]
  "41. Drops every Nth item from a sequence."
  (loop [v xs
         res []]
    (if (< (count v) n)
        (flatten (conj res v))
        (recur (vec (nthnext v n)) (conj res (subvec v 0 (dec n)))))))

(defn interpose-seq [elt s]
  "40. Separates the items of a sequence by an arbitrary value."
  (loop [seq s
         res []]
    (if (empty? (rest seq))
        (conj res (first seq))
        (recur (rest seq) (-> res
                            (conj (first seq))
                            (conj elt))))))

(defn interleave-seq [s1 s2]
  "39. takes two sequences and returns the first item from each,
   then the second item from each, then the third, etc."
  (loop [is1 s1
         is2 s2
         res []]
    (if (or (empty? is1)
            (empty? is2))
        res
        (recur (rest is1) (rest is2) (-> res
                                         (conj (first is1))
                                         (conj (first is2)))))))

(defn max-value [& args]
  "38. Takes a variable number of parameters and returns the maximum value."
  (reduce (fn [acc elt]
            (if (> elt acc)
              elt
              acc))
          (first args)
          args))

(defn range-seq [x n]
  "34. Creates a list of all integers in a given range."
  (loop [i x
         res []]
    (if (= i n)
        res
        (recur (inc i) (conj res i)))))

(defn replic [s, n]
  "33. Replicates each element of a sequence a variable number of times."
  (reduce (fn [acc item]
            (loop [i n
                   repeat []]
              (if (<= i 0)
                (concat acc repeat)
                (recur (dec i) (conj repeat item)))))
          [] s))

(defn duplic [s]
  "32. Duplicates each element of a sequence."
  (reduce (fn [acc item] (conj acc item item)) [] s))

(defn pack-seq [s]
  "31. Packs consecutive duplicates into sub-lists."
  (partition-by identity s))

(defn compress [s]
  "30. Compresse a sequence, exemple '(1 1 2 2 3) becomes '(1 2 3)"
  (->> s
       (seq)
       (partition-by identity)
       (map #(first (set %)))))

(defn allcaps [s]
  "29. Returns only the capital letters from a string."
  (let [inta (int \A)
        intz (int \Z)]
    (loop [[x & xs :as remainder] (seq s)
           caps []]
      (if (nil? x)
        (clojure.string/join "" caps)
        (if (and (>= (int x) inta) (<= (int x) intz))
          (recur xs (conj caps x))
          (recur xs caps))))))

(defn flatten-seq [s]
  "28. Flatten a sequence without using flatten.
  This solution is actually Clojure implementation."
  (filter (complement sequential?)
          (rest (tree-seq sequential? seq s))))

(defn palindrome? [value]
  "27. Palindrome detector."
  (loop [v (vec value)]
    (if (empty? v)
      true
      (if (= (first v) (last v))
        (recur (rest (drop-last v)))
        false))))

(defn fibo [x]
  "26. Calculates the x first fibonacci numbers."
  (loop [i x
         res []
         prec nil
         prec-2 nil]
    (if (<= i 0)
      (seq res)
      (if (nil? prec)
        (recur (dec i) (conj res 1) 1 prec-2)
        (if (nil? prec-2)
          (recur (dec i) (conj res 1) 1 1)
          (recur (dec i) (conj res (+ prec-2 prec)) (+ prec-2 prec) prec))))))

(defn reverse-seq [coll]
  "23. Reverse a sequence without using reverse or rseq functions."
  (loop [s (seq coll)
         res '()]
    (if (empty? s)
      res
      (recur (rest s) (conj res (first s))))))

(defn count-seq [value]
  "22. Count a sequence without using count function.
  I think I also can use the function reduce to do it."
  (loop [l (seq value)
         cpt 0]
    (if (empty? l)
      cpt
      (recur (rest l) (inc cpt)))))
