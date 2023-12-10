(require ['clojure.string :as 'str])

(def raw_line_list (str/split-lines (slurp "small_input1.txt")))

(def instructions (seq (str/join "" (repeat 50 (first raw_line_list)))))

(def raw_nodes_list (nthrest raw_line_list 2))

(defstruct node :value :L :R)

(defn make_node[line]
  (struct node (subs line 0 3) (subs line 7 10) (subs line 12 15)))

(def node_sequence (map make_node raw_nodes_list))

(defn find_node [target_node all_nodes]
  (first (filter (fn[node] (= target_node (:value node))) all_nodes)))

(defn find_next_node [current_node next_direction all_nodes all_directions]
  (println "AT NODE" (str (:value current_node)))
  (if (= (:value current_node) "ZZZ") (println "FOUND ZZZ")
  (if (= next_direction "L")
    (find_next_node (find_node (:L current_node) all_nodes) (first all_directions) all_nodes (drop 1 all_directions)) 
    (find_next_node (find_node (:R current_node) all_nodes) (first all_directions) all_nodes (drop 1 all_directions))
  )))

(def starting_node (find_node "AAA" node_sequence))

(println (drop 1 instructions))
(println (find_next_node starting_node (first instructions) node_sequence (drop 1 instructions)))
