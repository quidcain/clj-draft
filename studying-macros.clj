;;18.06.18
(defmacro my-macro [forms]
  forms)

(macroexpand '(my-macro (+ 1 2)))

(my-macro (+ 1 2))

(def input {:a 1 :b 2})

(defmacro let-map
  [a-map & forms]
  (let [args (map-reducer a-map)]
  `((let mapcat ~args
     ~@forms))))

(let-map input (+ a b))

input

(defn- map-reducer
  [input]
  (reduce
   (fn
     [acc [key value]]
     (vec (conj acc (symbol (name key)) value)))
   []
   (seq input)))

(map-reducer input)

(symbol (name :a))

(let-map )




(defmacro let-map [vars & forms]
  `(eval (list 'let (->> ~vars keys
                         (map (fn [sym#] [(-> sym# name symbol) (~vars sym#)]))
                         (apply concat) vec)
               '~(conj forms 'do))))
