package Map;

import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapDemo {
    public static void main(String[] args) {
        String key1 = new String("key"); // 🔹 Creates a new object with value "key"
        String key2 = new String("key"); // 🔹 Another new object with same value, different reference

        // 🔍 Print identity hash codes (memory reference based)
        System.out.println(System.identityHashCode(key1)); // different hashcode
        System.out.println(System.identityHashCode(key2)); // different hashcode


        // 🔍 hashCode() → based on content since String overrides hashCode()
        System.out.println(key1.hashCode()); 
        System.out.println(key2.hashCode()); 


        Map<String, Integer> map = new IdentityHashMap<>();

        // 🔸 Despite equal content, key1 and key2 are different objects (== comparison fails)
        map.put(key1, 1); // key1, 1
        map.put(key2, 2); // key2, 2

        // 🖨️ Output will show both entries as keys are different by reference
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

