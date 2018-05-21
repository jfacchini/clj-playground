(ns Solution
  (:gen-class))

(defn get-ascii-code [c]
  (let [ascii-c (int c)
        ascii-a (int \A)
        ascii-z (int \Z)]
    (if (or (< ascii-c ascii-a) (> ascii-c ascii-z))
      (+ ascii-z 1)
      ascii-c)))

(defn -main [& args]
  (let [L (read) H (read) _ (read-line) T (read-line)]
    (loop [i H]
      (when (> i 0)
        (let [ROW (read-line)]
          (loop [j (seq (clojure.string/upper-case T))]
            (when (not (empty? j))
              (let [begin (* (- (get-ascii-code (first j)) (int \A)) L)
                    end (+ begin L)]
                (print (subs ROW begin end))
                (if (empty? (rest j))
                    (println "")))
              (recur (rest j))))
         (recur (dec i)))))))
