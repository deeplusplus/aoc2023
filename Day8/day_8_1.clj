(require ['clojure.string :as 'str])

(def raw_line_list (str/split-lines (slurp "input.txt")))

(def instructions (seq (str/join "" (first raw_line_list))))

(defn get_current_instruction[iteration]
  (nth instructions (mod iteration 281)))

(def raw_nodes_list (nthrest raw_line_list 2))

(defstruct node :value :L :R)

(defn make_node[line]
  (struct node (subs line 0 3) (subs line 7 10) (subs line 12 15)))

(def node_sequence (map make_node raw_nodes_list))

(defn find_node [target_node]
  (first (filter (fn[node] (= target_node (:value node))) node_sequence)))

(defn find_next_node [c_node n_d iter]
  (loop [current_node c_node next_direction n_d iteration iter]
  (comment (println "AT NODE" (apply str [(:value current_node) ", L: " (:L current_node) ", R: " (:R current_node)])))
  (comment (println "GOING TO " next_direction))
  (comment (println iteration))
  (comment (println (get_current_instruction iteration)))
  (if (= (:value current_node) "ZZZ") 
    (comp (println "FOUND ZZZ at iteration: " (str (dec iteration))) (throw (Exception. "STOP")))
  )
  (if (= next_direction \L)
    (recur (find_node (:L current_node)) (get_current_instruction iteration) (inc iteration)) 
    (recur (find_node (:R current_node)) (get_current_instruction iteration) (inc iteration))
  )
))

(def starting_node (find_node "AAA"))

(println (find_next_node starting_node (first instructions) 1))
