package Queue.BlockingQueue;

import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        
        // 📘 Create a PriorityBlockingQueue with a custom comparator to define priority order.
        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();

        // ✅ Adding elements to the queue (elements will be ordered based on priority)
        queue.put(5);   // Adds 5 to the queue
        queue.put(3);   // Adds 3 to the queue
        queue.put(8);   // Adds 8 to the queue
        queue.put(1);   // Adds 1 to the queue
        
        System.out.println("Queue after adding elements: " + queue);
        
        // ✅ Taking elements from the queue (they are retrieved in priority order)
        System.out.println("Taking from queue (priority order):");
        while (!queue.isEmpty()) {
            System.out.println(queue.take());  // Retrieves and removes the head of the queue
        }

        // ✅ The queue is now empty
        System.out.println("Queue after taking all elements: " + queue);
        
        // 📘 **PriorityBlockingQueue** Characteristics:
        //----------------------------------------------
        /*
        🔹 **Priority Blocking Queue**:
        - PriorityBlockingQueue is a type of BlockingQueue that orders elements based on their natural ordering, or by a comparator provided at the time of construction.
        - Unlike ArrayBlockingQueue or LinkedBlockingQueue, the priority of elements is important, and the queue ensures that the element with the highest priority is always at the head.
        
        🔹 **Custom Ordering**:
        - By default, the elements are ordered in natural order. But you can specify a custom comparator at the time of instantiation to define how elements are prioritized.
        
        🔹 **Thread Safety**:
        - PriorityBlockingQueue is **thread-safe**, meaning that multiple threads can safely insert and remove elements without causing data inconsistency.

        🔹 **Blocking Behavior**:
        - **`put(E e)`**: If the queue is full, this operation will block until space becomes available. 
        - **`take()`**: If the queue is empty, the thread will be blocked until an element becomes available.
        - **`offer(E e)`**: Adds an element to the queue if possible, returning `false` if the queue is full.
        - **`poll()`**: Retrieves and removes the highest-priority element, or `null` if the queue is empty.
        
        🔹 **Capacity**:
        - There is no fixed capacity for `PriorityBlockingQueue`. It can grow dynamically as elements are added.
        - You can, however, set an upper bound (the queue can still grow beyond it).

        🔹 **Use Cases**:
        - **Task Scheduling**: It is ideal for scheduling tasks where tasks with higher priority should be executed first.
        - **Producer-Consumer**: When multiple threads produce and consume elements, and you want to control the order based on priority.
        - **Real-Time Systems**: In systems where tasks need to be processed in priority order.

        🧠 **Important Points**:
        ------------------------
        1. **Comparator**: You can define custom order by providing a comparator when constructing the queue. For example, to reverse the order, you could provide a comparator that reverses the natural order.
        
        2. **Thread Safety**: Like other `BlockingQueue` implementations, it is thread-safe, but the elements' retrieval order is controlled by their priority.

        3. **No Capacity Limit**: Unlike `ArrayBlockingQueue`, it has no capacity limitation, allowing dynamic growth.
        */
    }
}
