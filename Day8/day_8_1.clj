(require ['clojure.string :as 'str])

(def raw_line_list (str/split-lines (slurp "small_input1.txt")))

(def instructions (seq (str/join "" (repeat 5 (first raw_line_list)))))

(def raw_nodes_list (nthrest raw_line_list 2))

(defstruct node :value :L :R)

(defn make_node[line]
  (struct node (subs line 0 3) (subs line 7 10) (subs line 12 15)))

(def node_sequence (map make_node raw_nodes_list))

(defn find_node [target_node all_nodes]
  (first (filter (fn[node] (= target_node (:value node))) all_nodes)))

(defn find_next_node [current_node next_direction all_nodes all_directions]
  (println "AT NODE" (apply str [(:value current_node) ", L: " (:L current_node) ", R: " (:R current_node)]))
  (println "GOING TO " next_direction)
  (print (read-line))
  (if (= (:value current_node) "ZZZ") 
    (println "FOUND ZZZ!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
    (println "DID NOT FIND ZZZ")
  )
  (if (= next_direction \L)
    (find_next_node (find_node (:L current_node) all_nodes) (first all_directions) all_nodes (nthrest all_directions 1)) 
    (find_next_node (find_node (:R current_node) all_nodes) (first all_directions) all_nodes (nthrest all_directions 1))
  )
)

(def starting_node (find_node "AAA" node_sequence))

(println starting_node)
(println (type (first instructions)))
(println (find_next_node starting_node (first instructions) node_sequence (nthrest instructions 1)))
