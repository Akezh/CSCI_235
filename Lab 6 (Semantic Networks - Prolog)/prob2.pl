% 1st arg - nickname of animal, 2nd arg - type
is_a(kermit, hylidae).
is_a(rembo, hylidae).
is_a(karl, rhacophoridae).
is_a(boris, rhacophoridae).
is_a(nick, centrolenidae).
is_a(rex, centrolenidae).
is_a(monro, hyperoliidae).
is_a(jenkins, boophis).
is_a(bob, boophis).
is_a(tina, pedostibes).

% 1st arg - type, 2nd arg - species family
is_a(hylidae, tree_frog).
is_a(rhacophoridae, tree_frog).
is_a(centrolenidae, tree_frog).
is_a(hyperoliidae, tree_frog).
is_a(boophis, tree_frog).
is_a(pedostibes, tree_frog).

% 1st arg - type, 2nd arg - property(Prop), 3rd arg - actual property(Actual_prop)
has_prop(hylidae, color, green).
has_prop(rhacophoridae, max_size, large).
has_prop(centrolenidae, skin, transparent).
has_prop(hyperoliidae, max_size, medium).
has_prop(boophis, skin, skeleton).
has_prop(pedostibes, color, brown).

has_prop(hylidae, lives_in, usa).
has_prop(rhacophoridae, lives_in, south_india).
has_prop(centrolenidae, lives_in, ecuador).
has_prop(hyperoliidae, lives_in, madagascar).
has_prop(boophis, lives_in, comoros).
has_prop(pedostibes, lives_in, western_india).


% 1st arg - smaller region, 2nd arg - broader region
part_of(usa, north_america).
part_of(south_india, asia).
part_of(ecuador, south_america).  
part_of(madagascar, africa).
part_of(comoros, africa).
part_of(western_india, asia).


has_property(X, Prop, Val) :- has_prop(X, Prop, Val).

found_in(X, Loc) :- has_prop(X, lives_in, Val), part_of(Val, Loc).

% If both species live in the same world regions (asia, africa) then they are neighbors
is_species_neighbors(X, Y) :- has_prop(X, lives_in, First), has_prop(Y, lives_in, Second), part_of(First, Country), part_of(Second, Country), X \= Y.

% Get the nicknames of frogs according to their properties
find_nicknames_by_properties(Actual_prop, Frog_name) :- has_prop(Frog_type, Prop, Actual_prop), is_a(Frog_name, X), X == Frog_type, Prop \= lives_in.

% Are the actual pets (nicknames) are neighbors? Live in the same broader Region (Asia, Africa, ...)
is_frog_a_neighbor(Name1, Name2) :- is_a(Name1, Type1), is_a(Name2, Type2), has_prop(Type1, lives_in, Country1), has_prop(Type2, lives_in, Country2), part_of(Country1, Region), part_of(Country2, Region), Name1 \= Name2.