(require ['clojure.string :as 'str])
(require ['clojure.edn :as 'edn])

(def line_list (str/split-lines (slurp "input.txt")))
(defn sum [number1 number2]
  (+ number1 number2))
(defn convertToInt [character]
  (- (int character) 48))

(defn print-first-and-last-digits [lines]
    (doseq [line lines]
          (let [digits (filter #(Character/isDigit %) line)]
                  (when (seq digits)
                           (+ (convertToInt (first digits)) (convertToInt (last digits)))
                              ))))

(println (print-first-and-last-digits line_list))
