(require ['clojure.string :as 'str])
(require ['clojure.set :as 'set])

(defn remove_card [line]
  (str/replace line #"Card \d+:" ""))

(defn split_on_bar [line]
  (str/split line #"\|"))

(defn split_on_space [line]
  (str/split line #" "))

(def raw_line_list (str/split-lines (slurp "small_input.txt")))

(def no_card_line_list (map remove_card raw_line_list))

(defn get_intersection [line]
  (set/intersection (set (split_on_space (first (split_on_bar line)))) (set (split_on_space (last (split_on_bar line))))))

(println (map get_intersection no_card_line_list))
