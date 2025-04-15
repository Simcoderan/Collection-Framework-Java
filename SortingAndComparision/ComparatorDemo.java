package SortingAndComparision;
import java.util.*;



class Student {
    int rollNo;
    String name;

    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    @Override
    public String toString() {
        return rollNo + " - " + name;
    }
}

public class ComparatorDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(10, "Simran"));
        list.add(new Student(5, "Aman"));
        list.add(new Student(20, "Riya"));

        // Sort by name (alphabetically) using Comparator (Lambda)
        Collections.sort(list, (s1, s2) -> s1.name.compareTo(s2.name));

        System.out.println("Sorted by name:");
        for (Student s : list) {
            System.out.println(s);
        }

        // Sort by rollNo (ascending) using Comparator (Anonymous class)
        Collections.sort(list, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s1.rollNo - s2.rollNo;
            }
        });

        System.out.println("\nSorted by roll number:");
        for (Student s : list) {
            System.out.println(s);
        }
    }
}


// -------------------------------------------------------------
// 🔷 Comparator Interface in Java (Interview Notes)
// -------------------------------------------------------------

/*
✅ Purpose:
- Used to define **custom sorting logic** for objects.
- Useful when you need multiple ways to sort (e.g., by name, then by roll no).

✅ Method:
- public int compare(T o1, T o2)
  → Returns:
    - Negative: o1 < o2
    - Zero: o1 == o2
    - Positive: o1 > o2

✅ Key Points:
- Defined in java.util package.
- Does NOT require modifying the original class.
- Can have multiple comparator implementations for different sort orders.

✅ Example Use Case:
- Sorting students by name, employees by salary, etc.

✅ Difference from Comparable:
- Comparable → defines *natural order* (inside the class)
- Comparator → defines *custom order* (outside the class)

✅ Syntax Tip:
- Can use **anonymous class**, **lambda expression**, or **separate class** to implement Comparator.

✅ Common Use:
- Collections.sort(list, comparator)
- TreeSet/TreeMap with custom comparator

💬 Interview Tip:
"Use Comparator when you want to sort objects in more than one way without modifying their class."


*/