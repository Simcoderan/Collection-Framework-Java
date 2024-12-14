//List  parent interface ,arraylist implements it
//arraylist- resizeable (increases dynamically size),can shrink its size.
//Arraylist is implemented as an  array of object refferences (internally stored in array)


//  IMPORTANT  -  ArrayList when created its has an initial capacity (default 10) 

// INTERNAL PROCESS - check capacity -> resize if necessary ( growth factor :- 1.5 times of current capacity , copy to new array TIME COMPLEXCITY :- O(N) ) -> add/remove the elements (Check Bounds , Remove the elements , Reduce Size)

package List.ArrayList;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //if size unknown
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








        
    }
    
    
}
