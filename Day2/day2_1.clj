(require ['clojure.string :as 'str])

(def line_list (str/split-lines (slurp "small_input.txt")))

(def line1 "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green")

(defn get-game [line]
  (subs line 0 (str/index-of line ":")))

(defn get-sessions [line]
  (str/split (subs line (+ 1 (str/index-of line ":"))) #";"))

(map println (get-sessions line1))
(println (get-sessions line1))
