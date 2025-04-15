package Queue.NonBlockingQueue;

import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentLinkedDequeExample {
    public static void main(String[] args) {
        ConcurrentLinkedDeque<String> deque = new ConcurrentLinkedDeque<>();

        // Add elements at both ends
        deque.addFirst("A");
        deque.addLast("B");
        deque.addLast("C");
        deque.addFirst("Start");

        // Peek elements
        System.out.println("First: " + deque.peekFirst()); // Start
        System.out.println("Last: " + deque.peekLast());   // C

        // Remove elements from both ends
        System.out.println("Removed First: " + deque.removeFirst()); // Start
        System.out.println("Removed Last: " + deque.removeLast());   // C

        // Check remaining elements
        System.out.println("Remaining: " + deque); // [A, B]
    }
}

/*
📌 Concept: ConcurrentLinkedDeque (Java)

✅ What is it?
A non-blocking, thread-safe double-ended queue (deque) based on linked nodes.
Allows fast concurrent access from both ends.

🧠 Key Points:
- It is part of java.util.concurrent package.
- Lock-free: uses Compare-And-Swap (CAS) for thread-safety.
- Multiple threads can add/remove from both ends simultaneously.

🔧 Common Methods:
- addFirst(E e) ➤ Inserts element at the front
- addLast(E e) ➤ Inserts element at the end
- removeFirst() ➤ Removes and returns the first element
- removeLast() ➤ Removes and returns the last element
- peekFirst() ➤ Returns head without removing
- peekLast() ➤ Returns tail without removing

🚀 Use Case:
- Suitable for high-concurrency environments like producer-consumer,
  job scheduling, or undo-redo operations.

🧪 Example Output:
First: Start  
Last: C  
Removed First: Start  
Removed Last: C  
Remaining: [A, B]
*/
