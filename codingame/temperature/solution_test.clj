(ns Solution-test
  (:require [clojure.test :refer :all]
            [testing.core :refer :all]))

(deftest find-the-closest
  (testing "It finds the closest to zero."
    (are [x y] (= x y)
         1 (closest-to-zero [1 -2 -8 4 5])
         -5 (closest-to-zero [-12 -5 -137])
         5 (closest-to-zero [42 -5 12 21 5 24])
         0 (closest-to-zero []))))

(deftest find-the-closest-v2
  (testing "It finds the closest to zero."
    (are [x y] (= x y)
         1 (closest-v2 [1 -2 -8 4 5])
         -5 (closest-v2 [-12 -5 -137])
         5 (closest-v2 [42 -5 12 21 5 24])
         0 (closest-v2 []))))
