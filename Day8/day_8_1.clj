(require ['clojure.string :as 'str])

(def raw_line_list (str/split-lines (slurp "small_input1.txt")))

(def instructions (first raw_line_list))

(def raw_nodes_list (nthrest raw_line_list 2))

(defstruct node :value :L :R)

(defn make_node[line]
  (struct node (subs line 0 3) (subs line 7 10) (subs line 12 15)))

(def node_sequence (map make_node raw_nodes_list))

(defn find_node [target_node all_nodes]
  (first (filter (fn[node] (= target_node (:value node))) all_nodes)))

(defn find_next_node [current_node direction all_nodes]
  (if (= direction "L") (find_node (:L current_node) all_nodes) (find_node (:R current_node) all_nodes)))

(def starting_node (find_node "AAA" node_sequence))

(defn start_recursion[direction]
  (find_next_node starting_node direction node_sequence))

(println (find_next_node starting_node "R" node_sequence))
(println (start_recursion "R"))
