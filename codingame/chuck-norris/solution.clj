(ns Solution
  (:gen-class))

(defn left-pad [s pad-char length]
  (loop [i (count s)
         pad-str s]
    (if (>= i length)
        pad-str
        (recur (inc i) (str pad-char pad-str)))))

(defn char-to-binary-str [c]
  (left-pad (Integer/toString (int c) 2)
            \0
            7))

(defn string-to-binary-seq [s]
  (->> s
    (seq)
    (map char-to-binary-str)
    (map seq)
    (flatten)))

(defn binary->chuck [binary-char, prev]
  (str (if (not= binary-char prev)
           (str (if (= prev nil)
                    ""
                    " ")
                (if (= binary-char \1)
                    "0 "
                    "00 "))
        "0")))

(defn -main [& args]
  (let [MESSAGE (read-line)
        msg-seq (string-to-binary-seq MESSAGE)]
    (loop [s ""
           i msg-seq
           prev nil]
      (if (empty? i)
          (println s)
          (recur (str s (binary->chuck (first i) prev))
                 (rest i)
                 (first i))))))
