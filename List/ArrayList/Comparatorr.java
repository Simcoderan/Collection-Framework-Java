
        //Comparator- its an interface,compare 2 objects with same type and determine thier order
        //before using it need to make implementation class or make lambda class which implements    int compare(T o1, T o2);


package List.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;




// Comparator for sorting strings by their length
class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        // Sort by string length in desending order
        return Integer.compare(s1.length() , s2.length());
    }
}

// Comparator for sorting integers in descending order
class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        // Sort integers in descending order
        return o2 - o1;          //int negative-o1 first (asending order)    //int positive-o1 after (desending order) 
    }
}

public class Comparatorr {
    public static void main(String[] args) {
       
        // Integer sorting with custom comparator
        List<Integer> list9 = new ArrayList<>();
        list9.add(3);
        list9.add(2);
        list9.add(1);

        // Sort integers in descending order using MyComparator
        list9.sort(new MyComparator());
        System.out.println("Sorted Integers (Descending Order): " + list9);


        //Lambda class//import java.util.*
// Sort integers in descending order
//list9.sort((o1, o2) -> o2 - o1);  
//System.out.println("Sorted Integers (Descending Order): " + list9);



        // String sorting with custom comparator
        List<String> words = Arrays.asList("banana", "apple", "date", "kiwi");
        
        // Sort strings by length using StringLengthComparator
        words.sort(new StringLengthComparator());
        System.out.println("Sorted Strings (By Length): " + words);

       //Lambda class//import java.util.*
 // Sort strings by length using lambda
 //words.sort((s1, s2) -> Integer.compare(s2.length(), s1.length()));
 //System.out.println("Sorted Strings (By Length, Descending): " + words);



        
    }
}


//Collections.sort(students,comparator);