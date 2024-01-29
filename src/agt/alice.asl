
distance(X,Y,Z) :- .substring(NS1,X,4) & .term2string(N1,NS1) & .substring(NS2,Y,4) & .term2string(N2,NS2) & Z=N2-N1.

+location(waste,X) : location(robot,X) & location(bin,Y) & distance(X,Y,Z) & .print("Distance from ",X," to ",Y," is ",Z)
<-
    
    pick(waste);
    move(robot,Y);
    drop(waste).


