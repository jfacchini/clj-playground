(ns pub.core
  (:gen-class))

(def jug 60)
(def pint 20)
(def half-pint 10)
(def empty-glass 0)
(def drink 1)
(def quaff 4)

(defn fill-up [quantity] {:quantity quantity})

(defn dec-by [quantity]
  #(if (< % quantity)
     empty-glass
     (- % quantity)))

(defn consume [glass drink-qty]
  (update glass :quantity (dec-by drink-qty)))

(defn down [glass]
  {:quantity empty-glass})
