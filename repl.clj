;;26.05.2018
(defn rev [v]
  reduce #(conj %1 %2) [] v)

(rev [1 2 3 4 5])


(defn pal [s]
  (and
    (=
      (first s)
      (last s))
  (cond
    (= 1 (count s)) true
    (= 0 (count s)) true
    :else (recur (drop-last (rest s))))))

(pal '(1 3 3 1))


(def initial [{:name :Category :value "pens"}
              {:name :Brand :value "Bic"}
              {:name :Category :value "markers"}])

(def desired-result {:Category ["pens" "markers"]
                     :Brand ["Bic"]})

(map seq initial)

;;;(defn grouper
;;  [groups val]
;;  (let [group-name (:name val)]
;;       (update groups group-name #(into [] (concat % [(:value val)])))))

(defn grouper
  [groups val]
      (update groups (:name val) #(into [] (concat % [(:value val)]))))

(reduce (fn
          [groups val]
            (update groups (:name val) #(concat % [(:value val)])))
  {} initial)

(concatv [] [1 2 3]

(defn fib
  [n]
  (take n
        (map first (iterate (fn [[a b]] [b (+ a b)]) [1 1]))))
(defn fib
  [n]
  (take n ((fn rfib [a b] (cons a (lazy-seq (rfib b (+ a b))))) 1 1)))

(fib 3)
