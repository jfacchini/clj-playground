(ns Solution
  (:gen-class)
  (:require [clojure.string :refer [lower-case]]))

(defn inputs->map [N]
  (loop [i N
         res {}]
    (if (> i 0)
      (let [EXT (read) MT (read) _ (read-line)]
        (recur (dec i) (assoc res (keyword (lower-case EXT)) MT)))
      res)))

(defn inputs->seq [Q]
  (loop [i Q
         res []]
    (if (> i 0)
      (recur (dec i) (conj res (read-line)))
      res)))

(defn extract-extension [filename]
  (let [ext (vec (re-find #".*\.(.*)$" filename))]
    (if (> (count ext) 0)
      (lower-case (ext 1))
      "")))

(defn -main [& args]
  (let [N (read)
        Q (read)
        _ (read-line)
        mime-types (inputs->map N)
        extensions (keys mime-types)
        files (inputs->seq Q)
        files-ext (map extract-extension files)]

    (loop [fs files-ext]
      (if (not (empty? fs))
        (let [mt ((keyword (first fs)) mime-types)]
          (if (nil? mt)
            (println "UNKNOWN")
            (println mt))
          (recur (rest fs)))))))
