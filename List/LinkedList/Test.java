package List.LinkedList;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {

       LinkedList<Integer> linkedList = new LinkedList<>();

       // ADD METHOD 
       linkedList.add(1);   //linkedlist is a linear ds where each element is seperate obj called node.
       linkedList.add(2);   //node--- DATA & POINTER
       linkedList.add(3);
       //GET METHOD
       linkedList.get(2); //O(n)
       linkedList.addLast(4); //O(1)
       linkedList.addFirst(0); //O(1)
       linkedList.getLast();
       linkedList.getFirst();
       //REMOVE METHOD
       linkedList.removeIf(x -> x % 2 == 0); //remove the element if it is  satisfying the condition  in the bracket
       linkedList.removeAll(linkedList)


       LinkedList<String> animals = new LinkedList<>(Arrays.asList("Cat","Dog","Elephant"));
       LinkedList<String> animalsToRemove = new LinkedList<>(Arrays.asList("Dog","Elephant"));
       animals.removeAll(animalsToRemove);
       System.out.println(animals);


        
    }

   
    
}


//LINKEDLIST
/*
   Better Performance Characteristics compare to ArrayList

     -Insertions and Deletion: doesnt require to shift elemtns
     -Random Access: slower random access
     -Memory Overhead : memory more

 */


 