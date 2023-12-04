(require ['clojure.string :as 'str])

(def line_list (str/split-lines (slurp "input.txt")))

(defn line_to_first_digit [line]
  (first (re-find #"[0-9]+" line)))

(defn line_to_last_digit [line]
  (last (re-find #"[0-9]+" (str (reverse line)))))

(defn number_from_line [line]
  (Integer/parseInt (str (line_to_first_digit line) (line_to_last_digit line))))



(println (reduce + (map number_from_line line_list)))
