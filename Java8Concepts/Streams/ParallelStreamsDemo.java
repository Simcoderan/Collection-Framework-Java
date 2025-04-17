package Java8Concepts.Streams;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.*;

public class ParallelStreamsDemo {

    public static void main(String[] args) {

        // ✅ Example 1: Basic Parallel Stream
        List<String> names = Arrays.asList("Simran", "Saurabh", "Ritika", "Roop", "Sandeep");
        List<String> upperCaseNames = names.parallelStream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Uppercase Names: " + upperCaseNames);

        // ✅ Example 2: Parallel Stream Performance Comparison
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Sequential Stream
        long startTime = System.nanoTime();
        int sumSequential = numbers.stream().mapToInt(Integer::intValue).sum();
        long endTime = System.nanoTime();
        System.out.println("Sequential Sum: " + sumSequential);
        System.out.println("Time for Sequential: " + (endTime - startTime) + "ns");

        // Parallel Stream
        startTime = System.nanoTime();
        int sumParallel = numbers.parallelStream().mapToInt(Integer::intValue).sum();
        endTime = System.nanoTime();
        System.out.println("Parallel Sum: " + sumParallel);
        System.out.println("Time for Parallel: " + (endTime - startTime) + "ns");

        // ✅ Example 3: Sorting with Parallel Stream
        List<String> sortedNames = names.parallelStream().sorted().collect(Collectors.toList());
        System.out.println("Sorted Names: " + sortedNames);

        // ✅ Example 4: Handling Large Dataset with Parallel Stream
        List<Integer> largeNumbers = new ArrayList<>();
        for (int i = 1; i <= 1_000_000; i++) largeNumbers.add(i);
        long largeDatasetStart = System.nanoTime();
        long largeDatasetSum = largeNumbers.parallelStream().mapToLong(Integer::longValue).sum();
        long largeDatasetEnd = System.nanoTime();
        System.out.println("Large Dataset Sum: " + largeDatasetSum);
        System.out.println("Time for Large Dataset: " + (largeDatasetEnd - largeDatasetStart) + "ns");

        // ✅ Example 5: Thread-Safety with Parallel Stream
        Map<String, Integer> nameFrequency = new ConcurrentHashMap<>();
        names.parallelStream().forEach(name -> nameFrequency.merge(name, 1, Integer::sum));
        System.out.println("Name Frequency Map: " + nameFrequency);
    }
}

/*
 * ============================================================
 * 🧠 Parallel Streams in Java (Java 8+)
 * ============================================================
 * 
 * ✅ **What are Parallel Streams?**
 * - Parallel streams allow you to process data concurrently, taking advantage of multiple CPU cores.
 * - Operations are divided into smaller tasks and processed in parallel.
 * 
 * ✅ **How to Create a Parallel Stream?**
 * - `parallelStream()` method on collections creates a parallel stream.
 * 
 * ✅ **When to Use Parallel Streams?**
 * - Use for CPU-bound tasks like sorting, filtering, or computationally intensive operations.
 * - Avoid for small datasets or I/O-bound operations as parallelism may add overhead.
 * 
 * ✅ **Advantages of Parallel Streams:**
 * - Speed up processing of large datasets with parallelism.
 * 
 * ✅ **Caution:**
 * - Ensure thread safety when modifying shared resources (e.g., using `ConcurrentHashMap`).
 * 
 * ============================================================
 * ⚙️ **Thread Safety in Parallel Streams:**
 * - Shared resources (e.g., maps) should be thread-safe when used in parallel streams.
 * - Use thread-safe collections like `ConcurrentHashMap`.
 * 
 * ============================================================
 * 🔁 **Performance Considerations:**
 * - Parallel streams can improve performance for large, CPU-intensive tasks but may add overhead for smaller tasks.
 * 
 * ============================================================
 * 🔁 **Common Interview Questions:**
 * 
 * Q1: **What is the difference between sequential and parallel streams?**
 * - Sequential streams process elements one at a time, while parallel streams divide tasks across multiple threads.
 * 
 * Q2: **When should parallel streams be used?**
 * - For large datasets or CPU-intensive tasks that can be divided into independent sub-tasks.
 * 
 * Q3: **What are the risks of using parallel streams?**
 * - Risk of thread safety issues if shared resources are not properly handled.
 * - Parallel streams may be slower for small datasets due to overhead.
 */
