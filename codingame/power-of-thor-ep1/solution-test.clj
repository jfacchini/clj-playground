(ns Solution-test
  (:require [clojure.test :refer :all]
            [testing.core :refer :all]))

(deftest test-next-dir-pos-x
  (testing "From 0 to 5, :dir is E and :pos is 1"
    (is (= (next-dir-pos-x 0 5) {:dir "E", :pos 1})))
  (testing "From 5 to 0, :dir is W and :pos is 4"
    (is (= (next-dir-pos-x 5 0) {:dir "W", :pos 4})))
  (testing "From 5 to 5, :dir is empty string and :pos is 5"
    (is (= (next-dir-pos-x 5 5) {:dir "", :pos 5}))))

(deftest test-next-dir-pos-y
  (testing "From 0 to 5, :dir is E and :pos is 1"
    (is (= (next-dir-pos-y 0 5) {:dir "S", :pos 1})))
  (testing "From 5 to 0, :dir is N and :pos is 4"
    (is (= (next-dir-pos-y 5 0) {:dir "N", :pos 4})))
  (testing "From 5 to 5, :dir is empty string and :pos is 5"
    (is (= (next-dir-pos-y 5 5) {:dir "", :pos 5}))))
