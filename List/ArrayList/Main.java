//List  parent interface ,arraylist implements it
//arraylist- resizeable (increases dynamically size),can shrink its size.
//Arraylist is implemented as an  array of object refferences (internally stored in array)


//  IMPORTANT  -  ArrayList when created its has an initial capacity (default 10) 

// INTERNAL PROCESS - check capacity -> resize if necessary ( growth factor :- 1.5 times of current capacity , copy to new array TIME COMPLEXCITY :- O(N) ) -> add/remove the elements (Check Bounds , Remove the elements , Reduce Size)

package List.ArrayList;

import java.rmi.server.Operation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;


public class Main {
    public static void main(String[] args) {

        //if size unknown  //java.util.ArrayList
        ArrayList<Integer> list = new ArrayList<>();  //size 0 , capacity 10
        list.add(1);  //index=0
        list.add(5);    //index=1
        list.add(6);      //index=3


        System.out.println(list.get(1));  //print index

        System.out.println(list.size());         //print size

        //print elements

        for(int i=0;i<list.size();i++){        
            System.out.println(list.get(i));
        }

        //we can iterate wihtout taking pointer i like prev method
        for(int x:list){
         System.out.println(x);
        }
        
        //check if list  contains element or not
        System.out.println(list.contains(5));  //true-output
        System.out.println(list.contains(4));  //false-output


        list.remove(2); //to remove element
        list.add(2,60);  //to add in betwenn elements,other elements will be shifted
        list.set(3, 80);  //it will replace the number at index



        //Interview question
        ArrayList<Integer> newlist = new ArrayList<>(1000);
        System.out.println(newlist.size());   //0
        System.out.println(newlist.get(0));  //0



         // Arrays.asList Example
         List<String> list2 = Arrays.asList("Monday", "Tuesday");   //java.util.Arrays$ArrayList
         System.out.println(list2.getClass().getName());                 // returns fixed size , cant add items only replace
         list2.set(1,"Wednesday");  //replace
         System.out.println(list2.get(1));


       

 
         // If we have an array and want to convert it into a list
         String[] array = {"Apple", "Banana", "Cherry"};                ////java.util.Arrays$ArrayList
         List<String> list3 = Arrays.asList(array);
         System.out.println(list3.getClass().getName());

         //wht if want to modify list3
         List<String> list5 = new ArrayList<>(list3); 
         list5.add("Mango");
         System.out.println(list5);




         //List.of 
         List<Integer> list4 =List.of(1,2,3);  //unmodifiable list  //unreplaceable


         //Add-all method
         List<Integer>listnew =new ArrayList<>();
         list.add(1);
         list.add(2);
         list.add(0,0);
         //System.out.println(listnew);



         List<Integer> list6 =List.of(3,4,5);

         listnew.addAll(list6);
         System.out.println(listnew);


         //removing elements- by index,by value

         //BY-VALUE
         List<String>fruits =new ArrayList<>();
         fruits.add("apple");
         fruits.add("apple");
         fruits.add("mango");

         fruits.remove("apple");
         System.out.println(fruits);  //apple,mango

         //BY-INDEX
         List<Integer>listremove =new ArrayList<>();
         listremove .add(1);
         listremove .add(2);

         listremove.remove(2);  //it removes by using index not value


         //CHANGING BY-INDEX TO BY-VALUE
         listremove.remove(Integer.valueOf(1));  //change its instance with rappper class so tht it removes value
         System.out.println(listremove);


         //list to array
         List<Integer>listchangetoarray =new ArrayList<>();
         listchangetoarray.add(1);
         listchangetoarray.add(2);
         listchangetoarray.add(3);

         Object[] arrayObj = listchangetoarray.toArray();
        Integer[] intArray = listchangetoarray.toArray(new Integer[0]);
        System.out.println(Arrays.toString(intArray)); // [1, 2, 3]


        //sort arraylist
        List<Integer>list8 =new ArrayList<>();
         list8.add(3);
         list8.add(2);
         list8.add(1);

         Collections.sort(list8);
         System.out.println(list8); //sorted
         //list8.sort(null);   //also gets sorted


         //timecomplexcity

//Operation                     	Time Complexity	Explanation

//Add (at end)	          O(1) (Amortized)	Adding at the end is O(1) unless resizing is required. If resizing occurs, it's O(N).

//Add (at index)	      O(N)	Requires shifting elements to the right after the given index.

//Get (by index)	      O(1)	Direct access by index using an internal array.

//Set (by index)	      O(1)	Direct access and replacement by index.

//Remove (by index)	      O(N)	Requires shifting elements after the removed index to the left.

//Remove (by value)	      O(N)	Needs to search for the value, then shift elements.

//Search (contains)	      O(N)	Linear search is performed to find the value.

//Iteration               O(N)	Every element is visited once.
//(for-loop,
 //enhanced-loop)
	
//Resize ArrayList	       O(N)	A new array is created, and all elements are copied.
//Sort 

//(Collections.sort)	   O(N log N)	Uses TimSort, an optimized sorting algorithm.


//Convert to Array 
//(toArray)	                O(N)	Copies all elements to a new array.




         


         



        
        
 
         
     }
 }
