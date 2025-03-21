package List.Stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Demostack {
    public static void main(String[] args) {
        // Since Stack extends Vector,it is synchronized,making it thread-safe.
        // principle-LIFO
        // Inheritance- stack is subclass of Vector,which means it inherits all the
        // features of a dynamic array but is constrained by the stacks's LIFO nature.
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack); // [1,2,3,4,5]

        Integer removedElement = stack.pop(); // stack.pop();
        System.out.println(stack); // [1,2,3,4]

        Integer peek = stack.peek(); // whts kept at the peek of the stack
        System.out.println(peek);

        System.out.println(stack.isEmpty()); // check if empty
        System.out.println(stack.size());

        int search = stack.search(3); // 1 based indexing //search from top and will give index
        // 4
        // 3
        // 2
        // 1
        // output-2 index

        // We can use linkedlist as stack:-

        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);

        linkedList.getLast(); // peek
        linkedList.removeLast(); // pop
        linkedList.size();
        linkedList.isEmpty(); 

        //arraylist as stack?-not easy

         ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        int topElement = arrayList.get(arrayList.size() - 1); // peek
        arrayList.remove(arrayList.size() - 1); // pop

    }

}
