package Map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapVsLinkedHashMap {
    public static void main(String[] args) {

        // Creating a HashMap (Does NOT maintain insertion order)
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("banana", 9);
        hashMap.put("apple", 8);
        hashMap.put("orange", 10);
        hashMap.put("grapes", 12);

        // Creating a LinkedHashMap (Maintains insertion order) //double linked list
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        /*
         * Where:
         * true → Access order (moves recently accessed elements to the end) (useful for
         * LRU caches)
         */
        linkedHashMap.put("banana", 9);
        linkedHashMap.put("apple", 8);
        linkedHashMap.put("orange", 10);
        linkedHashMap.put("grapes", 12);

        // Displaying HashMap (Unordered)
        System.out.println("HashMap Output (Order is NOT maintained):");
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Displaying LinkedHashMap (Maintains insertion order)
        System.out.println("\nLinkedHashMap Output (Order is maintained):");
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        HashMap<String, Integer> hash = new HashMap<>();
        // Converting HashMap to LinkedHashMap
        LinkedHashMap<String, Integer> linkedHashMap1 = new LinkedHashMap<>(hash);

        hash.put("Shubham", 91);
        hash.put("Bob", 80);
        hash.put("Akshit", 78);

        Integer res = hash.getOrDefault("Vipul", 0);
        hash.putIfAbsent("Shubham", 92);
        System.out.println(res);

    }
}

/*
 * 🚀 Key Differences: HashMap vs LinkedHashMap
 * 
 * ✅ Order of Elements:
 * 🔹 HashMap : does not maintain insertion order.
 * 🔹 LinkedHashMap : maintains insertion order.
 * 
 * ✅ Performance:
 * 🔹 HashMap: is slightly faster because it doesn’t track order.
 * 🔹 LinkedHashMap : has slightly more overhead due to maintaining order.
 * 
 * ✅ Usage:
 * 🔹 Use HashMap : when ordering doesn’t matter.
 * 🔹 Use LinkedHashMap : when insertion order should be preserved.
 */