package List.LinkedList;

import java.util.LinkedList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

       LinkedList<Integer> linkedList = new LinkedList<>();

       // ADD METHOD 
       linkedList.add(1);   // LinkedList is a linear DS where each element is a separate object called a node.
       linkedList.add(2);   // Node consists of DATA & POINTER
       linkedList.add(3);
       
       // GET METHOD
       System.out.println(linkedList.get(2)); // O(n)
       linkedList.addLast(4); // O(1)
       linkedList.addFirst(0); // O(1)
       System.out.println(linkedList.getLast());
       System.out.println(linkedList.getFirst());

       // REMOVE METHOD
       linkedList.removeIf(x -> x % 2 == 0); // Remove elements satisfying the condition in the bracket
       linkedList.clear(); // Removes all elements from the list

       LinkedList<String> animals = new LinkedList<>(Arrays.asList("Cat", "Dog", "Elephant"));
       LinkedList<String> animalsToRemove = new LinkedList<>(Arrays.asList("Dog", "Elephant"));
       animals.removeAll(animalsToRemove);
       
       System.out.println(animals); // Output: [Cat]
    }
}

// LINKEDLIST
/*
   Better Performance Characteristics Compared to ArrayList:

     - Insertions and Deletions: Do not require shifting elements.
     - Random Access: Slower random access.
     - Memory Overhead: Higher memory usage due to storing extra pointers.
*/
