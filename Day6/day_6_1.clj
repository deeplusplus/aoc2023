(def first_race { "time" 38947970, "distance" 241154910741091 })
(def races [first_race])

(defn get_range_of_remaining_times [race_time]
  (reverse (range (inc (get race_time "time")))))

(defn get_range_of_holds [race_time]
  (range (inc (get race_time "time"))))

(defn get_tuples_of_hold_to_remaining_time [hold_time, remaining_time]
  (map vector hold_time remaining_time))

(def ranges_of_holds (map get_range_of_holds races))
(def ranges_of_remaining (map get_range_of_remaining_times races))

(def list_of_hold_to_remaining_tuples (map get_tuples_of_hold_to_remaining_time ranges_of_holds ranges_of_remaining))

(defn get_distance_traveled [hold_to_remain_pair]
  (* (first hold_to_remain_pair) (last hold_to_remain_pair)))

(def race_1_possible_distances (map get_distance_traveled (first list_of_hold_to_remaining_tuples)))

(defn get_win_conditions[possible_distances, record_distance]
  (count (filter (fn[possible_distance] (> possible_distance record_distance)) possible_distances)))

(def win_count_1 (get_win_conditions race_1_possible_distances (get first_race "distance")))

(println win_count_1)
