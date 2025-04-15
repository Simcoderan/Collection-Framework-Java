package Iterator;


import java.util.*;  // Importing Collection and Iterator classes

public class IteratorExample {

    public static void main(String[] args) {

        // ✅ Creating a sample list
        List<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("Python");
        languages.add("C++");
        languages.add("Go");

        // ✅ Getting an iterator for the list
        Iterator<String> iterator = languages.iterator();

        System.out.println("Traversing list using Iterator:");

        // ✅ Traversing the list using hasNext() and next()
        while (iterator.hasNext()) {
            String lang = iterator.next(); // Returns the next element
            System.out.println(lang);

            // ✅ Removing an element conditionally using iterator.remove()
            if (lang.equals("Python")) {
                iterator.remove(); // Removes the current element safely
            }
        }

        System.out.println("List after removal: " + languages);
    }
}


/* 
==========================================================
🧠 CONCEPTUAL NOTES: Iterator in Java
==========================================================

👉 What is an Iterator?
   - An Iterator is an object that allows you to traverse a Collection (like List, Set).
   - It provides a standard way to loop through elements without exposing the collection's internal structure.
   -Iterator is a standalone interface.
   -It does not implement or extend any other interface.
   -Concrete classes like ArrayList$Itr, HashSet$Itr, etc., implement Iterator internally.



📦 Belongs to: java.util package

✅ Commonly used methods:
   1. boolean hasNext()      → Checks if the next element exists.
   2. E next()               → Returns the next element.
   3. void remove()          → Removes the last element returned by next(). (Optional)

⚠️ Rules & Caveats:
   - You **must not modify** the collection directly while iterating using for-each or normal loop.
   - Use `iterator.remove()` if you want to safely remove an item during iteration.
   - Iterator is **unidirectional** — can move only forward.

🔥 Use Case:
   - Safe removal of elements during traversal.
   - Applicable to any Collection (List, Set).

👨‍💻 Interface:
   - `Iterator<E>` is a generic interface.
   - Obtained by calling `.iterator()` on any Collection.

Example:
   Iterator<String> it = list.iterator();
   while(it.hasNext()) {
       String val = it.next();
       if(val.equals("someValue")) it.remove();
   }

==========================================================


🔁 Visual Diagram:

Iterator<E>            Iterable<E>              Collection<E>
    ↑                       ↑                        ↑
 Returned by           Implemented by         Extended by List, Set, etc.
 .iterator()            Collection            (ArrayList, HashSet, etc.)


 💬 Purpose:

 -Used to iterate over a collection     -Provides iterator() method    -Base for all collection types


 👑 Actual Hierarchy :

 java.lang.Object
   └── Iterable<T>         ← (top interface for iteration)
          |
          └── Collection<E>  ← List, Set, Queue extend this
                  |
                  └── List<E>, Set<E>, Queue<E>, etc.


*/

