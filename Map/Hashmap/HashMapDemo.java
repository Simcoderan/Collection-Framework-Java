package Map.Hashmap; // Declaring the package

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

        // map.remove(2);
        // System.out.println(map);

        boolean res = map.remove(31, "Nitin");
        System.out.println("REMOVED ? :" + res);

    }
}



















/*
 * 📌 HashMap in Java – Key Characteristics
 * 🔹 Unordered
 * -Does not maintain any specific order for its elements.
 * 
 * 🔹 Allows Null Keys and Values
 * -Can store one null key and multiple null values.
 * 
 * 🔹 Not Synchronized
 * -Not thread-safe by default.
 * -Requires external synchronization in multi-threaded environments.
 * 
 * 🔹 Performance 🚀
 * -Provides O(1) time complexity for basic operations like put() and get(),
 * assuming a well-distributed hash function.-
 */

/*
 * 🎯 BASIC COMPONENTS OF HASHMAP 🎯
 * KEY
 * VALUE
 * BUCKET - a place where key-value pairs are stored.Think of buckets as cells
 * in a list(array).
 * HASH FUNCTION - converts a key into a index (bucket location)for storage.
 */

/*
 * 📂 HASH FUNCTION 📂
 * 
 * -A hash function is an algorithm that takes an input (or "key") and produces
 * a fixed-size string of bytes, typically a numerical value.
 * 
 * -The output of this function is called a hash code, hash value, or simply a
 * hash.
 * 
 * -The primary purpose of a hash function is to map data of arbitrary size to
 * data of fixed size.
 */

/*
 * 🎯 Key properties of a hash function.
 * 🔹 Deterministic – The same input will always produce the same output.
 * 🔹 Fixed Output Size – No matter how big or small the input is, the hash
 * value will have a consistent size (e.g., 32-bit, 64-bit).
 * 🔹 Efficient Computation – The hash function should compute the hash quickly.
 */

/*
 * 📂HOW DATA IS STORED IN HASHMAP 📂
 * 
 * 🔹Hashing the Key
 * -The key is passed through a hash function to generate a unique hash code (an
 * integer).
 * -This hash code determines where the key-value pair will be stored.
 * -The storage structure used is called a "bucket array."
 * 
 * 🔹Calculating the Index
 * -The hash code is used to calculate an index in the array (bucket location)
 * using:
 * int index = hashCode % arraySize;
 * -The index determines which bucket will store the key-value pair.
 * -Example: If the array size is 16, the key’s hash code is divided by 16, and
 * the remainder becomes the index.
 * 
 * 🔹Storing in the Bucket
 * 
 * -The key-value pair is stored in the bucket at the calculated index.
 * -Each bucket can hold multiple key-value pairs.
 * -This is due to a collision handling mechanism.
 * 
 * 
 * 🚀 EXAMPLE :- map.put("apple",50);
 * 
 * ✅ "apple" is the key.
 * 
 * ✅ 50 is the value.
 * 
 * ✅ The hash code of "apple" is calculated.
 * 
 * ✅ The index is found using the hash code.
 * 
 * ✅ The pair ("apple", 50) is stored in the corresponding bucket.
 * 
 * 
 * 
 * 
 */

/*
 * 🔍 How HashMap Retrieves Data 🔍
 * 🏷️ Hashing the Key: The key is hashed using the same hash function as during
 * insertion to generate its hash code.
 * 
 * 🔢 Finding the Index: The hash code is used to determine the index of the
 * bucket where the key-value pair is stored.
 * 
 * 🔎 Searching in the Bucket:
 * 
 * ✅The correct bucket is located.
 * 
 * ✅It checks if the key exists in that bucket.
 * 
 * ✅ If found, it returns the associated value.
 */

/*
 * 🚀 Concept of Collision in HashMap:-
 * A collision occurs when two different keys generate the same hash code and
 * are assigned to the same bucket.
 * Since HashMaps use a bucket array, multiple key-value pairs can end up in the
 * same bucket.
 * 
 * Collision Handling Mechanisms
 * 🚀 Chaining (Separate Chaining)
 * - Each bucket stores a linked list of key-value pairs.
 * -If a collision occurs, the new entry is added to the list in the same
 * bucket.
 * -When retrieving data, the list is searched for the correct key.
 * 
 * 🚀 Open Addressing (Probing)
 * -If a collision happens, the algorithm finds another available slot in the
 * array.
 * -Techniques like Linear Probing, Quadratic Probing, or Double Hashing are
 * used to find the next available index.
 * - Among these, chaining is more common in HashMaps because it avoids shifting
 * elements and works well even when the table is partially filled.
 */

/*
 * 🔹Collision handling in HashMap. :
 * 
 * 🏷️ Collision Occurrence:
 * 
 * -Different keys may produce the same index due to the hash function.
 * 
 * -This results in multiple key-value pairs mapping to the same bucket.
 * 
 * 🏷️Handling Collisions:
 * 
 * -Java's HashMap uses Linked Lists to store multiple entries in the same
 * bucket.
 * 
 * -After Java 8, it switches to Balanced Trees(RED-BLACK tree-self balancing
 * binary search tree) for better efficiency
 * when the number of collisions is high.
 * 
 * 🏷️Retrieving Data:
 * 
 * -When a key is searched, HashMap traverses the linked list (or tree) in the
 * bucket.
 * 
 * -It checks each key in the list until it finds a match.
 */

/*
 * 🚀HashMap Resizing (Rehashing):🚀
 * 
 * ✅Initial Size:
 * -The internal array size of a HashMap is 16 by default.
 * 
 * ✅Load Factor:
 * -HashMap resizes when the number of elements exceeds load factor × current
 * size.
 * -The default load factor is 0.75, meaning resizing happens after 16 × 0.75 =
 * 12 elements.
 * 
 * ✅Rehashing Process:
 * -When more than 12 elements are inserted, HashMap doubles its size to
 * accommodate more data.
 * -Existing key-value pairs are rehashed and placed in new buckets.
 * -This ensures efficient data storage and retrieval while preventing excessive
 * collisions.
 */

/*
 * 🚀 HashMap Rehashing 🚀
 * 
 * ✅ Array Size is Doubled:
 * - When the HashMap reaches its **load factor threshold**, the internal array
 * size is **increased to twice its current size**.
 * 
 * ✅ Rehashing Entries:
 * - All existing **key-value pairs are rehashed** (their positions are
 * recalculated using the new array size)
 * and placed into the **new array**.
 * 
 * ✅ Efficiency Maintenance:
 * - This process ensures that the **HashMap remains efficient** as more data is
 * added.
 * - **Reduces collisions** and maintains **fast retrieval times**.
 */

/*
 * 🚀 Time Complexity of HashMap 🚀
 * 
 * ✅ Average Case (With a Good Hash Function):
 * - Insertion: O(1)
 * - Deletion: O(1)
 * - Search (Get/ContainsKey): O(1)
 * 
 * ✅ Worst Case (When Collisions Occur Frequently):
 * - Insertion: O(n) (If all keys hash to the same bucket, forming a linked
 * list).
 * - Deletion: O(n) (Traversing a long linked list or tree in the worst case).
 * - Search: O(n) (If the bucket contains multiple elements due to collisions).
 * 
 * ✅ Java HashMap After Java 8:
 * - If a bucket has too many elements, it converts from a linked list to a
 * balanced tree (Red-Black Tree).
 * - This improves worst-case complexity from O(n) to O(log n) for search,
 * insertion, and deletion.
 * 
 * ✅ Amortized Complexity:
 * - Due to rehashing, individual operations may take O(n) occasionally, but the
 * amortized complexity remains O(1) for most cases.
 * 
 * Using a good hash function ensures that HashMap remains efficient with O(1)
 * average time complexity!
 */

 /*OBJECT CLASS -HashCode (memory address)
                -Equals(reference)
  */
