package Java8Concepts.Collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsDemo {

    public static void main(String[] args) {
        
        // Sample List of Strings
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        
        // 1. collect() - Collecting into a List
        List<String> wordList = words.stream()
                                     .collect(Collectors.toList());  // Collecting into a List
        
        System.out.println("List of Words: " + wordList);
        
        // 2. collect() - Collecting into a Set (removes duplicates)
        Set<String> wordSet = words.stream()
                                   .collect(Collectors.toSet());  // Collecting into a Set (removes duplicates)
        
        System.out.println("Set of Words: " + wordSet);
        
        // 3. collect() - Collecting into a Map
        Map<String, Integer> wordCountMap = words.stream()
                                                 .collect(Collectors.toMap(
                                                     Function.identity(),  // Using the word itself as the key
                                                     String::length));      // Using the length of the word as the value
        
        System.out.println("Word Count Map: " + wordCountMap);
        
        // 4. collect() - Grouping by a Property (Collectors.groupingBy())
        Map<Integer, List<String>> groupedByLength = words.stream()
                                                          .collect(Collectors.groupingBy(String::length));  // Grouping words by their length
        
        System.out.println("Grouped by Length: " + groupedByLength);
        
        // 5. collect() - Partitioning by a Predicate (Collectors.partitioningBy())
        Map<Boolean, List<String>> partitionedByLengthGreaterThanFive = words.stream()
                                                                          .collect(Collectors.partitioningBy(word -> word.length() > 5));  // Partition by word length greater than 5
        
        System.out.println("Partitioned by Length > 5: " + partitionedByLengthGreaterThanFive);
        
        // 6. collect() - Counting Elements (Collectors.counting())
        long wordCount = words.stream()
                              .collect(Collectors.counting());  // Counting the number of words
        
        System.out.println("Total Word Count: " + wordCount);
        
        // 7. collect() - Summing Elements (Collectors.summingInt())
        int totalLength = words.stream()
                               .collect(Collectors.summingInt(String::length));  // Summing the lengths of words
        
        System.out.println("Total Length of Words: " + totalLength);
        
        // 8. collect() - Averaging Elements (Collectors.averagingInt())
        double averageLength = words.stream()
                                    .collect(Collectors.averagingInt(String::length));  // Averaging the lengths of words
        
        System.out.println("Average Length of Words: " + averageLength);
        
        // 9. collect() - Joining Elements (Collectors.joining())
        String joinedWords = words.stream()
                                  .collect(Collectors.joining(", ", "[", "]"));  // Joining with a comma separator and enclosing in square brackets
        
        System.out.println("Joined Words: " + joinedWords);
        
        // 10. collect() - Reducing (Collectors.reducing())
        String concatenatedWords = words.stream()
                                        .collect(Collectors.reducing("", (word1, word2) -> word1 + word2));  // Concatenating all words
        
        System.out.println("Concatenated Words: " + concatenatedWords);
    }
}


/*
    -------------------------
   ✅  COLLECTORS IN JAVA 8
    -------------------------
    
    Collectors are a fundamental part of the Stream API in Java 8. They allow us to transform a stream into a collection or other types of results. The `collect()` method is used to accumulate elements into containers such as List, Set, Map, etc.

    Below are the commonly used Collectors in Java 8:

    1. **`Collectors.toList()`**:
        - **Usage**: Collects stream elements into a `List`.
        - **Use case**: When you need to store the result in a List.
        - **Interview Tip**: This is the most commonly used collector.

    2. **`Collectors.toSet()`**:
        - **Usage**: Collects stream elements into a `Set` (duplicates are removed).
        - **Use case**: When you want to remove duplicates automatically.
        - **Interview Tip**: Useful when the uniqueness of elements is important.
        
    3. **`Collectors.toMap()`**:
        - **Usage**: Collects elements into a `Map`, where you define the key and the value.
        - **Use case**: Collect data in a Map format, e.g., storing words as keys and their lengths as values.
        - **Interview Tip**: Focus on understanding how to extract keys and values for map creation.
        
    4. **`Collectors.groupingBy()`**:
        - **Usage**: Groups elements of the stream by a classifier function.
        - **Use case**: When you need to categorize elements into groups.
        - **Interview Tip**: It's often used to group data based on certain criteria (e.g., length of the word).
        
    5. **`Collectors.partitioningBy()`**:
        - **Usage**: Partitions elements of the stream into two groups based on a predicate.
        - **Use case**: When you need to split the stream into two categories based on a condition.
        - **Interview Tip**: Know how to use this collector to divide elements into two categories (true/false).
        
    6. **`Collectors.counting()`**:
        - **Usage**: Counts the number of elements in the stream.
        - **Use case**: When you need to count the number of items in a stream.
        - **Interview Tip**: Often used in combination with other collectors to count the elements that meet specific criteria.
        
    7. **`Collectors.summingInt()`**:
        - **Usage**: Sums the integer values derived from the elements in the stream.
        - **Use case**: When you want to sum values like the length of words, numeric values, etc.
        - **Interview Tip**: Understand how to sum values based on a specific property of the elements.
        
    8. **`Collectors.averagingInt()`**:
        - **Usage**: Computes the average of integer values derived from the elements.
        - **Use case**: When you need to calculate the average of certain values (e.g., average word length).
        - **Interview Tip**: Often combined with `summingInt()` to calculate other statistics like average and sum.
        
    9. **`Collectors.joining()`**:
        - **Usage**: Joins the stream elements into a single string with optional delimiters, prefix, and suffix.
        - **Use case**: When you want to combine elements into a single String (e.g., creating a comma-separated list).
        - **Interview Tip**: Very useful when working with strings and need to output a formatted result.
        
    10. **`Collectors.reducing()`**:
        - **Usage**: Performs a reduction on the elements of the stream using an associative accumulation function (e.g., sum, concat).
        - **Use case**: When you need to combine elements in a certain way (e.g., summing numbers or concatenating strings).
        - **Interview Tip**: Useful for merging elements into a single result, like concatenating strings or summing numbers.

    ---------------------------------------
    ✅Important Interview Questions:
    ---------------------------------------
    
    1. **What are collectors in Java 8?**
        - Collectors are used to accumulate the elements of a stream into a desired form like a List, Set, Map, or other types of containers. The `collect()` method is used with collectors to gather elements.
    
    2. **What is the difference between `toList()` and `toSet()`?**
        - `toList()` collects the elements into a List, while `toSet()` collects the elements into a Set. The key difference is that a Set automatically removes duplicates, whereas a List allows duplicates.
    
    3. **How does `groupingBy()` work in Java 8?**
        - `groupingBy()` is used to group elements in a stream by a classifier function. It returns a `Map` where the keys are the result of the classifier function and the values are lists of elements that match the key.
    
    4. **What is the use of `partitioningBy()`?**
        - `partitioningBy()` is used to split elements into two groups based on a given predicate. It returns a `Map<Boolean, List<T>>`, where true represents elements satisfying the condition and false represents those that don’t.

    5. **What is the purpose of `reducing()` collector in Java 8?**
        - The `reducing()` collector performs a reduction on the elements in the stream using an associative accumulation function (e.g., summing or concatenating). It is useful when you need to merge elements into a single result.
    
    6. **Can you give an example where `joining()` is used?**
        - `joining()` is often used when we want to concatenate elements of a stream into a single String. For example, joining a list of words with commas or creating a comma-separated values (CSV) output.
    
    7. **What is the difference between `counting()` and `summarizingInt()`?**
        - `counting()` counts the number of elements in a stream, while `summarizingInt()` provides a summary that includes count, sum, min, average, and max of the elements.

    -----------------------------------
    ✅ Tips for Interview Preparation:
    -----------------------------------
    - Understand how to use collectors effectively in different use cases.
    - Be clear about the difference between `toList()`, `toSet()`, and `toMap()`.
    - Know how `groupingBy()` and `partitioningBy()` can be applied in categorizing data.
    - Understand reducing operations and how they can be used for concatenation, summing, etc.
    - Practice writing interview-ready code snippets for common collectors like `joining()`, `groupingBy()`, and `partitioningBy()`.
*/
