;;21.05.18
;;brave clojure
(def vals '())
(+ (first vals) 0)


(defn my-fun
  [a & rest]
  (last rest))

(my-fun 1 3)

  ([f]
   (fn [& args]
     (apply f args)))

(defn my-comp
  [& funcs]
  (let [first-f (last funcs)
        rest-funcs (rest funcs)]
    (fn [f & args]
      (for [func rest-funcs]
        (func)))))

((my-comp inc inc) 2)
