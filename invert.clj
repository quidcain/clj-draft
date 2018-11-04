;;15.06.18
(def initial [{:name :Category :value "pens"} 
              {:name :Brand :value "Bic"}
              {:name :Category :value "markers"}])

(def desired-result 
  {:Category ["pens" "markers"] 
   :Brand ["Bic"]})


;;(defn grouper
;;  [groups val] 
;;  (let [group-name (:name val)
;;  	  group-value (:value val)]
;;     (update groups group-name #(into [] (concat % [group-value])))))

;;(defn grouper
;;  [groups val] 
;;  (update groups (:name val) #(vec (concat % [(:value val)]))))

(defn grouper
  [groups val] 
  (update groups (:name val) (fnil conj []) (:value val)))

(reduce grouper {} initial)

;;(reduce 
;; (fn 
;;  [groups val] 
;;  	(update groups (:name val) (fnil conj []) (:value val)))
;; {} initial)