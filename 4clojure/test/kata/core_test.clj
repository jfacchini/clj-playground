(ns kata.core-test
  (:require [clojure.test :refer :all]
            [kata.core :refer :all]))

(deftest flatten-test
  (testing "It flatten ((1 2) 3 [4 [5 6]]) to (1 2 3 4 5 6)"
    (is (= (flatten-seq '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6)))))

(deftest it-finds-a-palindrome
  (testing "raccar is palindrome"
    (is (true? (palindrome? "raccar")))))

(deftest it-finds-a-new-palindrome
  (testing "racecar is palindrome"
    (is (true? (palindrome? "racecar")))))

(deftest fibonacci-3
  (testing "It caclculates fibonacci of 3"
    (is (= (fibo 3) '(1 1 2)))))

(deftest it-extracts-suites
  (testing "Extract all different suites from a sequence of numbers"
    (is (= (extract-suites [1 0 1 2 3 0 4 5]) [[1] [0 1 2 3] [0 4 5]]))))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= (longest-seq [1 0 1 2 3 0 4 5]) [0 1 2 3]))))

(deftest b-test
  (testing "FIXME, I fail."
    (is (= (longest-seq [5 6 1 3 2 7]) [5 6]))))

(deftest c-test
  (testing "FIXME, I fail."
    (is (= (longest-seq [2 3 3 4 5]) [3 4 5]))))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= (longest-seq [7 6 5 4]) []))))
