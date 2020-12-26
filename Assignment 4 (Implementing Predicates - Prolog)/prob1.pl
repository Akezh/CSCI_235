% 1. Removal
removal([], _, []).
removal([Head | Tail], Remove_value, [Head | Tail2]) :- removal(Tail, Remove_value, Tail2), Head =\= Remove_value.
removal([Remove_value | Tail], Remove_value, Result) :- removal(Tail, Remove_value, Result).

% 2. Rotation
rotation([],[]).
rotation([H | T], Result) :- add(T, [H], Result).

% Helper function used for rotation and flattening
add([], List, List).
add([H | T], Val, [H | T2]) :- add(T, Val, T2).

% 3. Insertion 
insertion(List, 0, Val, [Val | List]).
insertion([H | Tail], Pos, Val, [H | Tail2]) :- DecrPos is Pos - 1, insertion(Tail, DecrPos, Val, Tail2).

% 4. Nth Prime
is_prime(1) :- false.
is_prime(2) :- true.
is_prime(Num) :- Num < 2, false.
is_prime(Num) :- Num-1 > 0, not(check_divisibility(Num, Num-1)).

check_divisibility(Num, ToDivide) :- 0 is mod(Num, ToDivide).
check_divisibility(Num, ToDivide) :- ToDivide > 2, check_divisibility(Num, ToDivide-1).

nth_prime(1, 2).
nth_prime(2, 3).
nth_prime(1, Ans) :- write(Ans).
nth_prime(Num, _) :- prime_helper(Num, 2).

prime_helper(1, X) :- M is X+1, is_prime(M), nth_prime(1, M). 
prime_helper(Num, 2) :- PrevNum is Num-1, prime_helper(PrevNum, 3).
prime_helper(Num, Cur) :- Num > 1, is_prime(Cur), PrevNum is Num-1, prime_helper(PrevNum, Cur+1).
prime_helper(Num, Cur) :- Num > 1, not(is_prime(Cur)), Next is Cur+1, prime_helper(Num, Next).
prime_helper(Num, Cur) :- Num =:= 1, not(is_prime(Cur)), Next is Cur+1, prime_helper(Num, Next).

% 5. flattening
flattening([], []).
flattening([HeadList | TailList], Result) :- flattening(HeadList, HeadResultList), flattening(TailList, TailResultList), add(HeadResultList, TailResultList, Result).
flattening(List, [List]).