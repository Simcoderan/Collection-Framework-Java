package Map.EnumMap;

import java.util.EnumMap;
import java.util.Map;

// MAP → ENUM → FAST ACCESS → EnumMap
// Implements – Map interface, optimized for enums as keys
//ordinal-index

public class EnumMapDemo {

    public static void main(String[] args) {

        // ✅ EnumMap is a specialized map for enum constants as keys
        // It provides fast lookups and storage efficiency for enum types.
        // EnumMap is sorted by the enum's ordinal values (the order defined in the enum declaration).
        // Only enum types can be used as keys in EnumMap.

        // Create an EnumMap with Day as the enum type and String as the value type
        EnumMap<Day, String> schedule = new EnumMap<>(Day.class);

        // 🔹 put() — inserts key-value pairs
        // Adds a new entry with the enum constant as the key and a string as the value
        schedule.put(Day.MONDAY, "Go to work");
        schedule.put(Day.FRIDAY, "Hang out with friends");
        schedule.put(Day.SUNDAY, "Relax");

        // 🔹 Display entries — automatically sorted by enum constant order (ordinal order)
        // The entries will be printed in the order of the enum constants: MONDAY, FRIDAY, SUNDAY.
        System.out.println("EnumMap (Sorted by Day Order): " + schedule);

        // 🔹 get() — retrieve a value by key (enum constant)
        // Retrieve the schedule for Friday using the enum constant as the key.
        System.out.println("Friday's Schedule: " + schedule.get(Day.FRIDAY));

        // 🔹 remove() — delete a key-value pair
        // Removes the entry for Monday
        schedule.remove(Day.MONDAY);
        System.out.println("After removing Monday: " + schedule);

        // 🔹 containsKey() — check if a specific key exists
        // Check if Friday is present as a key in the EnumMap.
        System.out.println("Contains Friday? " + schedule.containsKey(Day.FRIDAY));

        // 🔹 forEach loop — iterate over the EnumMap
        // Iterates over all entries and prints each key-value pair in the map
        System.out.println("Iterating with forEach:");
        schedule.forEach((k, v) -> System.out.println(k + " -> " + v));
    }

    // Enum representing the days of the week
    // This enum is used as the key type for the EnumMap
    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    /*
     * 🔹 INTERVIEW NOTES: EnumMap (Java-ready)
     * 
     * 1. **EnumMap Basics:**
     * - **EnumMap** is a specialized **Map** for enum constants as keys.
     * - It is **optimized** for enum types, offering **faster access** and **better memory efficiency** compared to general-purpose maps like **HashMap**.
     * 
     * 2. **Thread Safety:**
     * - **Not thread-safe** by default. If needed, **external synchronization** is required for concurrent access.
     * 
     * 3. **Initialization:**
     * - **EnumMap<Day, String> schedule = new EnumMap<>(Day.class);**
     * - The enum class (`Day.class`) is passed as an argument to initialize the map.
     * 
     * 4. **Key Restrictions:**
     * - **Only enum constants** can be used as keys.
     * - **Null keys are not allowed**; attempting to use `null` as a key results in `NullPointerException`.
     * 
     * 5. **Performance:**
     * - **Faster than `HashMap`**: Enums use their ordinal values internally, which allows for fast lookups.
     * - **Memory Efficient**: Uses an array internally, reducing memory overhead.
     * 
     * 6. **Sorting:**
     * - Entries are automatically sorted by **ordinal values** of the enum (the order in which the enum constants are defined).
     * 
     * 7. **Common Methods:**
     * - `put(K key, V value)`: Adds a key-value pair to the map.
     * - `get(Object key)`: Retrieves the value associated with the specified key.
     * - `remove(Object key)`: Removes the key-value pair from the map.
     * - `containsKey(Object key)`: Checks if the map contains a specific key.
     * - `forEach()`: Iterates over all key-value pairs in the map.
     * 
     * 8. **Time Complexity:**
     * - **Put, Get, Remove**: **O(1)** (constant time).
     * - **Iteration**: **O(n)** (linear time).
     * 
     * 9. **Memory Efficiency:**
     * - **EnumMap** is more **memory-efficient** than other map types because it uses an **array** internally for enum constants.
     * 
     * 10. **Use Cases:**
     * - **Mapping enum constants to values** where performance is critical, such as configurations, state-based machines, or event handlers.
     * - **Efficient lookups** for applications involving **predefined constants**.
     */
}
