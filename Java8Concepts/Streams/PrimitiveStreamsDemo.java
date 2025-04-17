package Java8Concepts.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;

public class PrimitiveStreamsDemo {

    public static void main(String[] args) {
        
        // 1. Primitive Stream of Integers (IntStream)
        IntStream intStream = Arrays.stream(new int[] {1, 2, 3, 4, 5});
        System.out.println("IntStream: ");
        intStream.forEach(System.out::println);  // Printing all elements in the IntStream
        
        // 2. Primitive Stream of Longs (LongStream)
        LongStream longStream = Arrays.stream(new long[] {100L, 200L, 300L});
        System.out.println("\nLongStream: ");
        longStream.forEach(System.out::println);  // Printing all elements in the LongStream
        
        // 3. Primitive Stream of Doubles (DoubleStream)
        DoubleStream doubleStream = Arrays.stream(new double[] {1.1, 2.2, 3.3});
        System.out.println("\nDoubleStream: ");
        doubleStream.forEach(System.out::println);  // Printing all elements in the DoubleStream
        
        // 4. Creating Primitive Stream from List of Integers
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        int sum = integerList.stream()
                             .mapToInt(Integer::intValue)  // Converting Integer to int (Primitive)
                             .sum();  // Summing the elements
        
        System.out.println("\nSum of List elements (converted to IntStream): " + sum);
        
        // 5. Operations with Primitive Streams
        int max = intStream.max().orElseThrow(() -> new IllegalArgumentException("Stream is empty"));
        System.out.println("\nMaximum value in IntStream: " + max);
        
        long count = longStream.count();  // Counting elements in LongStream
        System.out.println("\nNumber of elements in LongStream: " + count);
        
        double average = doubleStream.average().orElseThrow(() -> new IllegalArgumentException("Stream is empty"));
        System.out.println("\nAverage value in DoubleStream: " + average);
    }
}


/*
    ------------------------------
   ✅ PRIMITIVE STREAMS IN JAVA 8
    ------------------------------

    Primitive streams are a special kind of stream in Java 8 that are optimized for handling primitive types like `int`, `long`, and `double`. They offer better performance by avoiding unnecessary boxing/unboxing of primitives that can occur when working with the general `Stream<T>` API.

    Java 8 provides three specialized primitive stream types:
    
    1. **IntStream** (for `int` values)
    2. **LongStream** (for `long` values)
    3. **DoubleStream** (for `double` values)

    **Why Use Primitive Streams?**
    - **Performance Improvement**: Primitive streams are more efficient because they avoid the overhead of boxing and unboxing primitives.
    - **Better Support for Numerical Data**: Specialized streams provide convenient methods for common operations on numbers, like sum, average, max, min, etc.

    ------------------------------------
       ✅Types of Primitive Streams
    ------------------------------------

    1. **`IntStream`**: 
        - Designed specifically for working with `int` values.
        - Provides methods like `sum()`, `average()`, `max()`, `min()`, and `count()` to perform common numerical operations.

    2. **`LongStream`**:
        - Designed specifically for working with `long` values.
        - Similar to `IntStream`, it provides numerical operations but with long values instead.

    3. **`DoubleStream`**:
        - Designed specifically for working with `double` values.
        - Provides methods like `sum()`, `average()`, `max()`, `min()`, and `count()` but for `double` values.

    -------------------------------------------
       ✅Creating Primitive Streams
    -------------------------------------------
    
    1. **From Arrays**: 
        - You can create primitive streams directly from primitive arrays using `Arrays.stream()`.
        - Example:
          ```java
          IntStream intStream = Arrays.stream(new int[] {1, 2, 3, 4, 5});
          ```

    2. **From Collections**: 
        - To convert a `List<Integer>` to an `IntStream`, use `mapToInt()`.
        - Example:
          ```java
          List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
          int sum = integerList.stream()
                               .mapToInt(Integer::intValue)  // Converting Integer to int
                               .sum();  // Summing the elements
          ```

    ---------------------------------------------
      ✅Common Operations on Primitive Streams
    ---------------------------------------------
    
    1. Aggregation Operations:
        - **`sum()`**: Calculates the sum of elements.
        - **`average()`**: Calculates the average of elements.
        - **`min()`** and **`max()`**: Finds the minimum and maximum values.
        - **`count()`**: Counts the number of elements.

    2. Reduction:
        - Similar to `reduce()` in regular streams, you can perform reduction operations on primitive streams as well.
        
    3. Mapping:
        - You can map a primitive stream into another stream of primitives using methods like `mapToInt()`, `mapToLong()`, and `mapToDouble()`.
        
    4. Filtering:
        - Filtering is supported in primitive streams through methods like `filter()`.
        
    5. ForEach:
        - Just like regular streams, primitive streams also support `forEach()` for iterating over elements.
        
    6. Short-circuiting operations:
        - Primitive streams support short-circuiting operations like `anyMatch()`, `allMatch()`, and `noneMatch()`.

    ------------------------
    ✅Important Interview Questions
    ------------------------

    1. What are primitive streams in Java 8?**
        - Primitive streams (`IntStream`, `LongStream`, `DoubleStream`) are specialized streams for handling primitive data types, which improve performance by avoiding boxing and unboxing of primitive types into wrapper classes.

    2. Why should I use primitive streams over regular streams?**
        - Primitive streams offer better performance for numerical operations by avoiding the overhead of boxing/unboxing. They are optimized for handling large amounts of numeric data efficiently.

    3. Can we convert a `List<Integer>` to a primitive `IntStream`?**
        - Yes, you can convert a `List<Integer>` to an `IntStream` using the `mapToInt()` method. Example:
          ```java
          List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
          int sum = integerList.stream()
                               .mapToInt(Integer::intValue)
                               .sum();
          ```

    4. What is the difference between `IntStream` and `Stream<Integer>`?**
        - `IntStream` is a specialized stream for handling primitive `int` values directly, while `Stream<Integer>` is a regular stream that handles `Integer` objects, which involve boxing and unboxing, causing overhead. `IntStream` is more efficient for numerical operations.

    5. What methods are available in primitive streams?**
        - Primitive streams support methods like `sum()`, `average()`, `min()`, `max()`, `count()`, and other aggregation operations. They also support mapping, filtering, and reducing operations specifically for primitive values.

    6. Can you perform operations like `reduce()` on primitive streams?**
        - Yes, operations like `reduce()` are supported on primitive streams, but they are more efficient in handling primitive types directly.

    7. How do you create a primitive stream from an array?**
        - You can use the `Arrays.stream()` method to create primitive streams from an array:
          ```java
          IntStream intStream = Arrays.stream(new int[] {1, 2, 3});
          ```

    ------------------------------
     ✅ Key Points to Remember:
    ------------------------------
    - Primitive streams (`IntStream`, `LongStream`, `DoubleStream`) are more efficient for numerical data.
    - They eliminate the need for boxing/unboxing, which results in better performance.
    - These streams provide powerful aggregation and reduction methods tailored for primitives.
    - Use `mapToInt()`, `mapToLong()`, or `mapToDouble()` to convert regular streams into primitive streams.

*/
