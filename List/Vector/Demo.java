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









//Key Features
  //-Dynamic Array
  //-Synchronized
  //-Legacy Class
  //-Resizing Mechanism
  //-Random Access
