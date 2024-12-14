//List  parent interface ,arraylist implements it
//arraylist- resizeable (increases dynamically size)

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //if size unknown
        ArrayList<Integer> list = new ArrayList<>();
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







        
    }
    
    
}
