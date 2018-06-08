(ns pub.core-test
  (:require [clojure.test :refer :all]
            [pub.core :refer :all]))

(deftest serves-a-beer
  (testing "A fresh pint is 20oz"
    (is (= (fill-up pint) {:quantity pint})))
  (testing "A fresh half-pint is 10oz"
    (is (= (fill-up half-pint) {:quantity half-pint})))
  (testing "A fresh jug is 60oz"
    (is (= (fill-up jug) {:quantity jug})))
  (testing "When the class is empty, customer cannot drink"
    (is (= (consume {:quantity empty-glass} drink) {:quantity empty-glass})))
  (testing "When the customer drinks it comsumes 1oz"
    (is (= (consume (fill-up pint) drink) {:quantity 19})))
  (testing "When the customer quaffs it consumes 4oz"
    (is (= (consume (fill-up pint) quaff) {:quantity 16})))
  (testing "When the glass has 4oz or less the glass will be emptied"
    (is (= (consume {:quantity 3} quaff) {:quantity empty-glass})))
  (testing "When the customer downs the drink it is emptied"
    (is (= (down (fill-up pint)) {:quantity empty-glass}))))
