package SortingAndComparision;

import java.util.*; // Required for List, ArrayList, Collections



class Student implements Comparable<Student> {
    int rollNo;
    String name;

    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    @Override
    public int compareTo(Student s) {
        return this.rollNo - s.rollNo; // sort by rollNo ascending
    }

    @Override
    public String toString() {
        return rollNo + " - " + name;
    }
}

public class ComparableDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(10, "Simran"));
        list.add(new Student(5, "Aman"));
        list.add(new Student(20, "Riya"));

        Collections.sort(list);  // Uses compareTo()

        for (Student s : list) {
            System.out.println(s);
        }
    }
}

/*
-------------------------------------------------------------
🔷 Comparable Interface in Java (Interview Notes)
-------------------------------------------------------------

✅ Purpose:
- Used to define the *natural/default sorting order* of objects.
- Found in the java.lang package.
- Useful for sorting objects in Collections like TreeSet, TreeMap, or using Collections.sort().

✅ Method:
- public int compareTo(T o)
  → Returns:
    - Negative: current object < passed object
    - Zero: current object == passed object
    - Positive: current object > passed object

✅ Key Points:
- Class must implement Comparable<T> interface.
- Only one compareTo() method = one natural order per class.
- Commonly used with Collections.sort() or Arrays.sort()

✅ Example Use Case:
- Sorting students by roll number, employees by salary, etc.

✅ Related Classes:
- TreeSet and TreeMap use compareTo() for automatic sorting.

✅ Difference from Comparator:
- Comparable → defines natural order (inside the class itself)
- Comparator → defines custom order (outside the class or as a separate class)

✅ Best Practice:
- Override toString() for better display when printing objects.
- Keep compareTo() consistent with equals() for predictable behavior.

💬 Interview Tip:
"Comparable is used when an object needs a natural ordering (like sorting students by roll number). It defines a single way of sorting using compareTo()."

-------------------------------------------------------------
*/
