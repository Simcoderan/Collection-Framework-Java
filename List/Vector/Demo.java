package List.Vector;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Vector;

public class Demo {
    public static void main(String[] args) {
        Vector<Integer> vector =new Vector<>(2,3); //capacityincrement if you want specific number of increment and not double.
        vector.add(1);
        vector.add(1);
        System.out.println(vector.capacity());
        vector.add(1); //if more than initialcapacity then capacity gets doubled
        System.out.println(vector.capacity()); // can check capacity unlike arraylist
        


        //Vector(Collection<?extends E> c):Created a vector containing the elements of the specified collection.
        
        LinkedList<Integer> linkedList=new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2); 
        linkedList.add(3);

        Vector<Integer> vector1=new Vector<>(linkedList);
        System.out.println(vector1);

    }
    
}



//Methods in Vector
 /*
 add(E e) – Adds an element at the end of the vector.

add(int index, E element) – Inserts an element at the specified index.

get(int index) – Retrieves the element at the specified index.

set(int index, E element) – Replaces the element at the specified index.

remove(Object o) – Removes the first occurrence of the specified element.

remove(int index) – Removes the element at the specified index.

size() – Returns the number of elements in the vector.

isEmpty() – Checks if the vector is empty.

contains(Object o) – Checks if the vector contains the specified element.

clear() – Removes all elements from the vector. */




/* 🚀Understanding Vector in Java🚀

✔ Legacy Class:
Vector is an older collection class that implements the List interface.
It was introduced in Java 1.0, before the ArrayList.


✔ Dynamic Array:
Similar to ArrayList, Vector grows dynamically when elements are added.
Unlike arrays, which have a fixed size, Vector can expand as needed.


✔ Thread Safety:
Vector is synchronized, meaning it is thread-safe.
However, this synchronization comes with a performance cost in single-threaded environments.

✔ Performance Consideration:
In modern applications, ArrayList is preferred because it is faster than Vector in non-threaded environments.
If thread safety is required, CopyOnWriteArrayList (from java.util.concurrent) is a better alternative.

When to Use Vector?
✔ If thread safety is a primary concern.
✔ If working on legacy codebases where Vector is already in use.
✔ When using synchronized collections in a multi-threaded environment */









//Key Features
  //-Dynamic Array
  //-Synchronized
  //-Legacy Class
  //-Resizing Mechanism
  //-Random Access
