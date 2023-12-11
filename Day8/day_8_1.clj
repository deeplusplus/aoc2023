(require ['clojure.string :as 'str])

(def raw_line_list (str/split-lines (slurp "input.txt")))

(def instructions (seq (str/join "" (take 2000 (cycle (first raw_line_list))))))

(def raw_nodes_list (nthrest raw_line_list 2))

(defstruct node :value :L :R)

(defn make_node[line]
  (struct node (subs line 0 3) (subs line 7 10) (subs line 12 15)))

(def node_sequence (map make_node raw_nodes_list))

(defn find_node [target_node all_nodes]
  (first (filter (fn[node] (= target_node (:value node))) all_nodes)))

(defn find_next_node [current_node next_direction all_nodes all_directions iteration]
  (comment (println "AT NODE" (apply str [(:value current_node) ", L: " (:L current_node) ", R: " (:R current_node)])))
  (comment (println "GOING TO " next_direction))
  (comment (println iteration))
  (if (= (:value current_node) "ZZZ") 
    (comp (println "FOUND ZZZ at iteration: " (str iteration)) (throw (Exception. "STOP")))
  )
  (if (= next_direction \L)
    (find_next_node (find_node (:L current_node) all_nodes) (first all_directions) all_nodes (nthrest all_directions 1) (inc iteration)) 
    (find_next_node (find_node (:R current_node) all_nodes) (first all_directions) all_nodes (nthrest all_directions 1) (inc iteration))
  )
)

(def starting_node (find_node "AAA" node_sequence))

(println (find_next_node starting_node (first instructions) node_sequence (nthrest instructions 1) 0))
