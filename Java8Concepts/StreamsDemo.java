package Java8Concepts;

import java.util.*;
import java.util.stream.*;

public class StreamsDemo {

    public static void main(String[] args) {

        // ✅ Creating Stream from a Collection (List)
        List<String> namesList = Arrays.asList("Simran", "Saurabh", "Ritika", "Roop", "Sandeep", "Saurabh");
        Stream<String> nameStream = namesList.stream(); // Sequential Stream
        Stream<String> parallelNameStream = namesList.parallelStream(); // Parallel Stream

        // ✅ Creating Stream from an Array
        String[] nameArray = { "Simran", "Saurabh", "Ritika" };
        Stream<String> arrayStream = Arrays.stream(nameArray);

        // ✅ Using Stream.of() for small fixed collections
        Stream<Integer> numberStream = Stream.of(10, 20, 30, 40);

        // ---------------------------------------------
        // Stream Examples
        // ---------------------------------------------

        // ✅ Example 1: Filter names starting with 'S'
        List<String> filteredNames = namesList.stream()
                .filter(name -> name.startsWith("S"))
                .collect(Collectors.toList());
        System.out.println("Names starting with S: " + filteredNames);

        // ✅ Example 2: Convert all names to uppercase using map()
        List<String> upperCaseNames = namesList.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Uppercase names: " + upperCaseNames);

        // ✅ Example 3: Remove duplicates using distinct()
        List<String> distinctNames = namesList.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Distinct names: " + distinctNames);

        // ✅ Example 4: Count names with length > 6
        long nameCount = namesList.stream()
                .filter(name -> name.length() > 6)
                .count();
        System.out.println("Names with length > 6: " + nameCount);

        // ✅ Example 5: Sort the names
        List<String> sortedNames = namesList.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorted names: " + sortedNames);

        // ✅ Creating Infinite Streams

        // Infinite Stream using Stream.iterate()
        Stream<Integer> infiniteNumbers = Stream.iterate(1, n -> n + 1)
                .limit(10);
        System.out.println("Infinite Stream using iterate (first 10 numbers):");
        infiniteNumbers.forEach(System.out::println);

        // Infinite Stream using Stream.generate()
        Stream<Double> randomNumbers = Stream.generate(Math::random)
                .limit(5);
        System.out.println("Infinite Stream using generate (5 random numbers):");
        randomNumbers.forEach(System.out::println);

        // ✅ limit(n): Get only first 3 elements
        List<Integer> limited = Stream.of(10, 20, 30, 40, 50)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("Limited (first 3): " + limited);

        // ✅ skip(n): Skip first 3 elements
        List<Integer> skipped = Stream.of(10, 20, 30, 40, 50)
                .skip(3)
                .collect(Collectors.toList());
        System.out.println("Skipped (after 3): " + skipped);

        // ✅ reduce(): Sum all elements in the list
        int sum = Stream.of(10, 20, 30, 40)
                .reduce(0, Integer::sum);
        System.out.println("Reduced (sum): " + sum);

        // ✅ Filtering and Collecting Names (length > 3)
        List<String> someNames = Arrays.asList("Anna", "Bob", "Charlie", "David");
        System.out.println("Names with length > 3: " +
                someNames.stream()
                        .filter(x -> x.length() > 3)
                        .toList()
        );

        // ✅ Squaring and Sorting Numbers
        List<Integer> numbersList = Arrays.asList(5, 2, 9, 1, 6);
        System.out.println("Squared and Sorted: " +
                numbersList.stream()
                        .map(x -> x * x)
                        .sorted()
                        .toList()
        );

        // ✅ Squaring and Summing Numbers
        int sumOfSquares = numbersList.stream()
                .map(x -> x * x)
                .reduce(0, Integer::sum);
        System.out.println("Sum of Squares: " + sumOfSquares);

        // ✅ Counting Occurrences of a Character
        String sentence = "Hello world";

        // ✅ Count how many times 'l' appears
        long charCount = sentence.chars()
                .filter(x -> x == 'l')
                .count();
        System.out.println("Count of 'l': " + charCount);
    }
}



/*
 * ============================================================
 * 🧠 CONCEPTUAL NOTES: Java Streams API (Java 8+)
 * ============================================================
 * 
 * 👉 What is a Stream?
 * - A Stream in Java is a sequence of elements supporting sequential and
 * parallel aggregate operations.
 * - It is **not a data structure**, but an abstraction for processing
 * collections in a **functional style**.
 * 
 * 📦 Defined in: java.util.stream package
 * 
 * 🔁 How to create a Stream:
 * - From collections: `collection.stream()`
 * - From arrays: `Arrays.stream(array)`
 * - From static factory: `Stream.of(…)`
 * 
 * 🎯 Common Stream Operations:
 * ✅ Intermediate Operations (return a Stream):
 * - `filter(Predicate)` → filters elements
 * - `map(Function)` → transforms each element
 * - `sorted()` → sorts stream elements
 * - `distinct()` → removes duplicates
 * - `limit(n)`, `skip(n)` → pagination-like ops
 * 
 * ✅ Terminal Operations (return non-stream result):
 * - `collect(Collectors.toList())` → collect result
 * - `count()` → count elements
 * - `forEach()` → perform action on each
 * - `anyMatch()`, `allMatch()`, `noneMatch()` → matching
 * 
 * ⚡ Benefits of Streams:
 * - Concise and readable code
 * - Parallelism support via `.parallelStream()`
 * - Functional-style programming (no side-effects)
 * 
 * ⚠️ Stream characteristics:
 * - Streams cannot be reused once consumed.
 * - Lazy evaluation: intermediate ops don’t run until terminal op is invoked.
 * 
 * ============================================================
 * 💡 TIP for Interviews:
 * - Be clear on difference between `map()` and `flatMap()`
 * - Know when to use `filter` vs `distinct`
 * - Always mention lazy evaluation and non-mutating nature
 * 
 * ============================================================
 * 
 * 
 * 🔍 **INTERVIEW QUESTIONS AND ANSWERS**:
 * 
 * Q1: **What is the difference between `map()` and `flatMap()`?**
 * 
 * ✅ - `map()` transforms each element of the stream into another form, i.e., it
 * **returns a new stream of transformed elements**.
 * ✅- `flatMap()` is used when the transformation produces a **stream of
 * streams**. It **flattens these nested streams into a single stream**.
 * 
 * 👉Example:
 * - `map()`: Converts a list of strings into a list of their lengths.
 * - `flatMap()`: When each string is split into an array of characters,
 * `flatMap()` will flatten the arrays into a single stream of characters.
 * 
 * 
 * 
 * Q2: **What is the difference between `filter()` and `distinct()` in
 * Streams?**
 * 
 * ✅ - `filter()` is used to **select elements based on a given condition**
 * (predicate).
 * ✅- `distinct()` removes **duplicate elements** in the stream.
 * 
 * 
 * 
 * Q3: How does lazy evaluation work in Java Streams?
 * 
 * ✅ -Streams use lazy evaluation, meaning that intermediate operations (like
 * filter(), map()) are not executed until a terminal operation (like collect(),
 * count()) is invoked.
 * ✅-This allows operations to be chained without performing unnecessary work
 * until the final result is required.
 * 
 * 👉 example code-
 * Stream<Integer> result = numbers.stream()
 * .filter(n -> n > 5) // intermediate operation
 * .map(n -> n * 2); // intermediate operation
 * // Nothing is processed until a terminal operation is invoked like:
 * result.collect(Collectors.toList()); // now the operations are executed
 * 
 * 
 * 
 * 
 * 
 * Q4: Can a Stream be reused after consumption?
 * 
 * ✅-No, once a stream is consumed (terminal operation invoked), it cannot be
 * reused.
 * ✅-If you need to reuse the data, you should recreate the stream.
 * 
 * 👉 example code-
 * Stream<String> nameStream = names.stream();
 * nameStream.forEach(System.out::println); // Consumed
 * nameStream.forEach(System.out::println); // Error: Stream cannot be reused
 * 
 * 
 * 
 * 
 * Q5: What is the advantage of using parallelStream()?
 * 
 * ✅-parallelStream() allows the stream to be processed in parallel across
 * multiple threads, improving performance on large datasets.
 * ✅-It is beneficial when the operations are independent and can be processed
 * concurrently.
 * 
 * 👉 example code-
 * List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
 * numbers.parallelStream()
 * .map(n -> n * 2)
 * .forEach(System.out::println);
 * 
 * 
 * 
 * 
 * Q6: What is reduce() in Streams?
 * 
 * ✅ -reduce() is a terminal operation that aggregates elements in the stream
 * into a single result (such as sum, product, concatenation, etc.).
 * ✅ -It takes a binary operator and combines elements iteratively.
 * 
 * 
 * 👉 example code-
 * int sum = numbers.stream()
 * .reduce(0, (a, b) -> a + b); // Sum of numbers
 * 
 * 
 * 
 * Q7: What is Collectors.toList() used for in Streams?
 * 
 * ✅ -Collectors.toList() is a collector that collects the elements of the
 * stream into a List.
 * ✅ -It is often used with the collect() terminal operation to collect the
 * results of a stream into a specific collection type (List, Set, etc.).
 * 
 * 👉 example code-
 * List<String> list = names.stream()
 * .collect(Collectors.toList());
 * 
 * 
 */

/*
 * ============================================================
 * 🔁 INFINITE STREAMS IN JAVA
 * ============================================================
 * 
 * 🧪 Java 8 allows creation of infinite streams that **don't have a fixed
 * size**.
 * They are useful for sequences like infinite number generation, sensor feeds,
 * or random data.
 * 
 * 👉 Ways to Create:
 * 
 * ✅ Stream.iterate(seed, unaryOperator)
 * - Starts from a given seed value and applies the function repeatedly.
 * - Example: Stream.iterate(0, n -> n + 2) → 0, 2, 4, 6, ...
 * 
 * ✅ Stream.generate(supplier)
 * - Uses a Supplier to generate values.
 * - Example: Stream.generate(Math::random) → random infinite doubles
 * 
 * ⚠️ WARNING:
 * - These streams are **infinite by default**, so always use `.limit(n)` when
 * working with them to avoid memory issues.
 * 
 * ============================================================
 * 
 * 🔁 Intermediate Operations in Java Streams
 * 👉 Definition: Intermediate operations are stream methods that return another
 * Stream.
 * They don’t perform any computation immediately, but instead prepare a
 * processing pipeline.
 * They are lazy, which means they wait until a terminal operation is called to
 * actually execute.
 */
