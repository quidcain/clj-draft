(def my-list '(1 2 3))

;;(let [f-odd (filter odd?)]
;;    (f-odd my-list))

(def f-odd (partial filter odd?))

(f-odd my-list)




(def xf (comp (filter odd?) (map inc)))
(transduce xf + (range 5))

(reduce + (->>
           (range 5)
           (filter odd?)
           (map inc)))

(defn smth [coll]
  (let [f-odd (partial filter odd?)
       minc (partial map inc)]
       (->>
        coll
        f-odd
        minc)))

(smth (range 5))

(defn my-trans
  [& funcs]
  (fn [coll]
      (loop [curr (first funcs)
            _rest (rest funcs)]
            (if curr
                (do ()
                    (recur
                     (first _rest)
                     (rest _rest)))))))

(def x-form (my-trans (partial filter odd?) (partial map inc)))
(x-form (range 5))
