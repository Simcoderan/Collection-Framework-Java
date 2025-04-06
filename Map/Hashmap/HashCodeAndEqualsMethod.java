package Map.Hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashCodeAndEqualsMethod {
    public static void main(String[] args) {
        HashMap<BatchStudent, String> map = new HashMap<>();
        BatchStudent p1 = new BatchStudent("Arav", 1);
        BatchStudent p2 = new BatchStudent("Bob", 2);
        BatchStudent p3 = new BatchStudent("Arav", 1);

        map.put(p1, "Engineer");  // Will store at a hash index
        map.put(p2, "Doctor");    // Different hash index
        map.put(p3, "Manager");   // If equals() & hashCode() are correctly implemented, p3 will replace p1

        System.out.println("HashMap Size: " + map.size());   // Expected: 2 if hashCode() & equals() work correctly
        System.out.println("Value for p1: " + map.get(p1));  // "Manager" if p1 and p3 are treated as the same key
        System.out.println("Value for p3: " + map.get(p3));  // "Manager"

        // HashMap with String keys
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("ashish", 90);
        map1.put("raghav", 80);
        map1.put("ashish", 99);  // Replaces the value of "ashish" from 90 to 99

        System.out.println("Value for 'ashish': " + map1.get("ashish")); // Expected: 99
    }
}

class BatchStudent {
    private String name;
    private int id;

    public BatchStudent(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // Override equals() to compare objects based on 'name' and 'id'
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BatchStudent that = (BatchStudent) obj;
        return id == that.id && Objects.equals(name, that.name);
    }

    // Override hashCode() to ensure objects with same values have same hash
    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    // Override toString() for better object representation
    @Override
    public String toString() {
        return "BatchStudent{name='" + name + "', id=" + id + "}";
    }
}
