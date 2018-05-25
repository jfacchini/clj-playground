(ns Solution
  (:gen-class))

(defn next-dir-pos-x [from-x to-x]
  (if (= from-x to-x)
    {:dir "" :pos from-x}
    (if (< from-x to-x)
      {:dir "E" :pos (inc from-x)}
      {:dir "W" :pos (dec from-x)})))

(defn next-dir-pos-y [from-y to-y]
  (if (= from-y to-y)
    {:dir "" :pos from-y}
    (if (< from-y to-y)
      {:dir "S" :pos (inc from-y)}
      {:dir "N" :pos (dec from-y)})))

; Other solutions are using compare function
; that returns -1 (<) 0 (=) 1 (>)

(defn -main [& args]
  (let [light-x (read) light-y (read) initial-thor-x (read) initial-thor-y (read)]
    (loop [thor-x initial-thor-x
           thor-y initial-thor-y]
      (let [remainingTurns (read)
            next-x (next-dir-pos-x thor-x light-x)]
        (println (str (:dir next-y) (:dir next-x)))
        (recur (:pos next-x) (:pos next-y))))))
