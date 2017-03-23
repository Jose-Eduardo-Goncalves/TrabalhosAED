specification List[Element]
  sorts
    List[Element]

  constructors
    make:        --> List[Element];
    addLast:    List[Element] Element --> List[Element];

  observers
    size:        List[Element] --> int;
    get:         List[Element] int -->? Element;
    set:         List[Element] int Element -->? List[Element];
    add:         List[Element] int Element -->? List[Element];
  others
    isEmpty:     List[Element];
   
  domains
    L: List[Element]; E:Element; I: int;  
    get(L,I)          if 0 <= I and I < size (L);
    set(L,I,E)        if 0 <= I and I < size (L);
    add(L,I,E)        if 0 <= I and I < size (L);
 
  axioms
    L: List[Element];    E, F: Element; I: int;

    isEmpty (L) iff size (L) = 0;

    size (make ()) = 0;
	size (addLast (L, E)) = 1 + size (L);
      
    get (addLast (L, E),I) =
      E when I = size (L)
      else get (L, I);
      
    set (addLast (L, E), I, F) =
      addLast (L, F) when I = size (L)
      else addLast (set (L, I, F), E);
     
     add (addLast (L, E), I, F) =
      addLast (addLast (L, F), E) when I = size (L)
      else addLast (add (L, I, F), E);
    
end specification

