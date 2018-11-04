;;25.03.18
;;4clojure
;;(#(str "Hello, " %) "Dave")

;;(= (#(str "Hello, " %) "Dave") "Hello, Dave!")
(comment 
  (def x '(a b c))
  (if (empty? (rest x))
         (print x)
         (rest x))
  
  ((fn [x] 
    (if (empty? (rest x))
    	(first x)
      (recur (rest x))))'(a b c))
  
  (defn last [x] 
    (if (empty? (rest x))
    	(first x)
      (recur (rest x))))
  (last '(a b c))
  (last ["b" "c" "d"])
  (= (last ["b" "c" "d"]) "d")
  
  ((fn [x]
      (let [index (dec (dec (count x)))] (nth x index))) [1 2 3])
    
  (#(let [index (dec (dec (count %)))] (nth % index)) [1 2 3])

((fn [x y]
  (loop [i 0]
    (if (= i y)
      (first x)
      (do
       (print x)
       (def x (rest x))
       (recur (inc i))))))'(1 2 3) 2)
)


((fn [x y]
  (if (= 0 y)
    (first x)
    (do
     (print x)
     (recur (rest x) (dec y)))))'(1 2 3) 1)
   
(re-seq #"[A-Z]+" "bA1B3Ce ")