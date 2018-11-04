;;18.03.18
;;4clojure
;Write a function which, given a key and map, returns true iff the map contains an entry with that key and its value is nil.
#(and
	(.contains (keys %2) %1)
	(nil? (%1 %2)))