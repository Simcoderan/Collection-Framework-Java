package Map;  // Declaring the package

import java.util.HashMap;
import java.util.Set;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        // Creating a HashMap with Integer keys and String values
        HashMap<Integer, String> map = new HashMap<>();  

        // Adding key-value pairs to the HashMap
        map.put(1, "Shreya");
        map.put(2, "Neha");
        map.put(3, "Akshit");

        // Printing the entire HashMap (Order is not guaranteed)
        System.out.println("HashMap: " + map);

        // Retrieving a value using a key
        String student = map.get(3);
        System.out.println("Value for key 3: " + student);

        // Trying to get a value for a non-existing key
        String s = map.get(6);
        System.out.println("Value for key 6: " + s); // Output: null

        // Checking if a key exists
        System.out.println("Contains key 2? " + map.containsKey(2));

        // Checking if a value exists
        System.out.println("Contains value 'Shreya'? " + map.containsValue("Shreya"));

        // Iterating through the HashMap using keySet()
        System.out.println("\nIterating using keySet():");
        for (int key : map.keySet()) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }

        // Iterating using entrySet() to get key-value pairs
        System.out.println("\nIterating using entrySet():");
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
            entry.setValue(entry.getValue().toUpperCase());
        }
        System.out.println(map);

      //  map.remove(2);
      //  System.out.println(map);

      boolean res = map.remove(31, "Nitin");
      System.out.println("REMOVED ? :" + res);



    }
}

/*📌 HashMap in Java – Key Characteristics
🔹 Unordered
    -Does not maintain any specific order for its elements.

🔹 Allows Null Keys and Values
     -Can store one null key and multiple null values.

🔹 Not Synchronized
      -Not thread-safe by default.
      -Requires external synchronization in multi-threaded environments.

🔹 Performance 🚀
      -Provides O(1) time complexity for basic operations like put() and get(), assuming a well-distributed hash function.- */
