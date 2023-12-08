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
  (disj (set/intersection (set (split_on_space (first (split_on_bar line)))) (set (split_on_space (last (split_on_bar line))))) ""))

(def seq_of_intersections (map get_intersection no_card_line_list))

(def seq_of_counts (map count seq_of_intersections))

(def one_point_count (count (filter (fn [set_count] (= 1 set_count)) seq_of_counts)))

(def greater_than_two_counts (count (filter (fn [set_count] (> 1 set_count)) seq_of_counts)))

(println seq_of_intersections)
(println seq_of_counts)
(println one_point_count)
(println greater_than_two_counts)
