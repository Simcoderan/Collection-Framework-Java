package Map.ImmutableMap;

import java.util.*;

public class ImmutableMapDemo {
    public static void main(String[] args) {

        // Immutable map using Map.of()
        Map<String, Integer> map1 = Map.of(
            "Apple", 10,
            "Banana", 20,
            "Orange", 30
        );

        // Immutable map using Map.ofEntries() (used directly in print)
        System.out.println("Map using Map.ofEntries(): " +
            Map.ofEntries(
                Map.entry("A", "Alpha"),
                Map.entry("B", "Beta")
            )
        );

        // Immutable map using unmodifiableMap()
        Map<String, String> mutableMap = new HashMap<>();
        mutableMap.put("X", "Xray");
        mutableMap.put("Y", "Yankee");

        Map<String, String> immutableMap = Collections.unmodifiableMap(mutableMap);

        System.out.println("Immutable Map using Map.of(): " + map1);
        System.out.println("Immutable Map using unmodifiableMap(): " + immutableMap);
    }
}



/*
==================================================
📌 IMMUTABLE MAP IN JAVA – INTERVIEW CRASH NOTES
==================================================

🔹 What is an Immutable Map?
   - A Map that cannot be changed after creation.
   - Any modification attempt throws `UnsupportedOperationException`.

🔹 Why Use It?
   ✅ Thread-safe without synchronization
   ✅ Prevents accidental modifications
   ✅ Ideal for constants, configs, and multi-threaded code

   
==================================================
   ⚠️ LIMITATIONS OF DIFFERENT METHODS
==================================================

📌 Map.of()
   - ❌ Max 10 entries
   - ❌ No null keys/values
   - ❌ No duplicate keys

📌 Collections.unmodifiableMap()
   - ❌ Original map can still change
   - ✅ Only blocks direct modifications on the view

📌 Guava ImmutableMap
   - ❌ Requires external dependency
   - ❌ Null keys/values are not allowed



🔹 How to Create Immutable Maps:

   ✅ Java 9+:
   --------------------------
   Map<String, Integer> map = Map.of(
       "A", 1,
       "B", 2
   );

   Map<String, String> map2 = Map.ofEntries(
       Map.entry("X", "X-ray"),
       Map.entry("Y", "Yankee")
   );

   ✅ Java 8 and below:
   --------------------------
   Map<String, String> base = new HashMap<>();
   base.put("A", "Alpha");
   Map<String, String> immutable = Collections.unmodifiableMap(base);

   ✅ Google Guava:
   --------------------------
// import com.google.common.collect.ImmutableMap;
// ImmutableMap<String, Integer> guavaMap = ImmutableMap.of("One", 1, "Two", 2);

==================================================
💬 QUICK INTERVIEW Q&A
==================================================

1. ❓ What is an immutable map?
   ✅ A map that cannot be changed once created.

2. ❓ Java 8 vs Java 9+ approach?
   ✅ Java 8: `Collections.unmodifiableMap()`
   ✅ Java 9+: `Map.of()` or `Map.ofEntries()`

3. ❓ Is `unmodifiableMap()` truly immutable?
   ❌ No. If the original map is changed, the wrapped map reflects changes.

4. ❓ Are immutable maps thread-safe?
   ✅ Yes, because they cannot be modified.

5. ❓ Real-world use cases?
   ✅ Config settings, constants, enum lookups, concurrent apps.

6. ❓ Defensive copy?
   ✅ `Collections.unmodifiableMap(new HashMap<>(inputMap))`

7. ❓ What happens on modification attempt?
   ✅ Throws `UnsupportedOperationException`.

==================================================
🛠 PRO TIP:
==================================================
🧠 Prefer `Map.of()` for simple, safe, and clean immutability (Java 9+)
🧠 Mention immutability avoids race conditions in multi-threaded environments
🧠 Always highlight the difference between *unmodifiable* and *immutable*
*/
