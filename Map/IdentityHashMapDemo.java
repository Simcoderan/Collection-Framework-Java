package Map;

import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapDemo {
    public static void main(String[] args) {
        // 🔹 key1 and key2 have same content but are different objects (different references)
        String key1 = new String("key");
        String key2 = new String("key");

        // ✅ Using IdentityHashMap to demonstrate reference-based comparison
        Map<String, Integer> map = new IdentityHashMap<>();

        // 🔸 Although content is same, identity (reference) is different
        map.put(key1, 1);
        map.put(key2, 2);

        System.out.println(map);
    }
}


/*
📌 INTERVIEW NOTES: IdentityHashMap in Java

🔹 What is IdentityHashMap?
   - A Map that uses **reference equality** (==) instead of `.equals()` for comparing keys.
   - Unlike HashMap, which uses `key1.equals(key2)` and `key1.hashCode() == key2.hashCode()`.

🔹 Why is it useful?
   - To distinguish keys that are "equal" in content but are different object references.
   - Useful for object identity tracking, such as parsing, graph algorithms, or interning mechanisms.

🔹 Key Difference from HashMap:
   - HashMap → uses `.equals()` → key1 and key2 would be treated as same (same value).
   - IdentityHashMap → uses `==` → key1 and key2 are treated differently (different objects).

🔹 Example:
   String key1 = new String("key");
   String key2 = new String("key");
   → key1.equals(key2) is true
   → key1 == key2 is false

   So:
   - In HashMap: one key will overwrite the other.
   - In IdentityHashMap: both keys are treated separately.

🔹 Output for this program:
   - IdentityHashMap: {key=1, key=2} → two entries
   - HashMap: {key=2} → one entry, second put overwrites first

🔹 Is it thread-safe?
   - ❌ No, not synchronized.

🔹 Memory Consideration:
   - Slightly optimized for performance but rarely used in everyday coding.
   - Mainly for very specific scenarios involving object identity.

🔹 Related Concepts:
   - `==` vs `.equals()` in Java
   - Object identity vs object equality

*/

