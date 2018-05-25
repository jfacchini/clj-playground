(ns Solution
  (:gen-class))

(defn list-input []
  (loop [i 8
         linput []]
    (if (<= i 0)
      linput
      (recur (dec i) (conj linput (read))))))

(defn -main [& args]
  (while true
    ; For each turn we get a list of mountains heights
    (let [mountains-heights (list-input)]
      (println
       (.indexOf mountains-heights
                 ; We get the max value from the list
                 (apply max-key identity mountains-heights))))))
