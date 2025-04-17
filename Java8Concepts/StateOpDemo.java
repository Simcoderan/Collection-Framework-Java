package Java8Concepts;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StateOpDemo {
    public static void main(String[] args) {
        
        // Example List of numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        // STATLESS OPERATION:
        // Stateless operations are operations that do not depend on any previous or 
        // future elements in the stream. Each element is processed independently.
        
        // map() - Squaring the numbers
        // map() applies a transformation to each element and produces a new stream with the transformed elements.
        // In this case, we're squaring each number.
        // map is considered stateless because it only applies the operation to each element independently.
        
        List<Integer> squaredNumbers = numbers.stream()
                                               .map(n -> n * n)  // Stateless operation: Applies the square operation on each element independently.
                                               .collect(Collectors.toList());
        
        System.out.println("Squared Numbers (Stateless Operation): " + squaredNumbers);
        // Output: [1, 4, 9, 16, 25]
        
        // STATEFUL OPERATION:
        // Stateful operations are operations that depend on the state of elements or the result of previous elements.
        // They maintain state across elements, either to track information or accumulate results.
        
        // sorted() - Sorting the numbers
        // The sorted() operation sorts the elements based on a given comparator or natural order.
        // Sorting requires comparing the elements, which means it has to remember the state of the stream's data.
        // Hence, sorting is a stateful operation because the final result depends on the ordering of elements in the stream.
        
        List<Integer> sortedNumbers = numbers.stream()
                                             .sorted()  // Stateful operation: The order of the stream elements is important.
                                             .collect(Collectors.toList());
        
        System.out.println("Sorted Numbers (Stateful Operation): " + sortedNumbers);
        // Output: [1, 2, 3, 4, 5]
        
        // Another Stateful Operation - distinct()
        // distinct() removes duplicate elements from the stream.
        // It requires maintaining a record of all previously seen elements in order to filter out duplicates.
        // As it requires memory and tracking previous elements, it is considered stateful.
        
        List<Integer> duplicateList = Arrays.asList(1, 2, 2, 3, 3, 4, 5, 5);
        List<Integer> distinctNumbers = duplicateList.stream()
                                                     .distinct()  // Stateful operation: Tracks previously seen elements to remove duplicates.
                                                     .collect(Collectors.toList());
        
        System.out.println("Distinct Numbers (Stateful Operation): " + distinctNumbers);
        // Output: [1, 2, 3, 4, 5]
        
        // Another Stateful Operation - reduce()
        // reduce() is an operation that accumulates elements into a single result.
        // It operates on the intermediate elements and maintains a state to compute a final result.
        // Here, we are summing up all the numbers. The previous sum is used to calculate the new sum.
        // This is an example of a stateful operation because the result depends on the accumulation of previous results.
        
        int sum = numbers.stream()
                         .reduce(0, Integer::sum);  // Stateful operation: Accumulates values into a single result.
                         
        System.out.println("Sum of Numbers (Stateful Operation): " + sum);
        // Output: 15
    }
}

/*
  -------------------------
  KEY CONCEPTS AND EXPLANATION
  -------------------------
  
  1. Stateless Operations:
     - **Definition**: Stateless operations do not rely on any previous or future state of elements in the stream.
       Each element is processed independently without any memory of previous elements.
     - **Examples**: `map()`, `filter()`, `flatMap()`
     - **Behavior**: Stateless operations can be parallelized without any issues because they do not require any intermediate state from previous elements.
  
     In the code example:
     - **`map(n -> n * n)`**: This is a stateless operation because it simply transforms each element (by squaring) independently of other elements.

  2. Stateful Operations:
     - **Definition**: Stateful operations maintain or depend on the state of the elements or the results of previous elements.
       They often require tracking intermediate data or positions within the stream.
     - **Examples**: `sorted()`, `distinct()`, `reduce()`
     - **Behavior**: Stateful operations tend to require more resources (e.g., memory, CPU) because they must keep track of information about previous elements.

     In the code example:
     - **`sorted()`**: This is a stateful operation because the final order of the stream elements depends on comparing each element with others, which requires maintaining some state.
     - **`distinct()`**: This is a stateful operation because it needs to remember previously encountered elements in order to filter out duplicates.
     - **`reduce()`**: This operation accumulates elements into a single result (like sum or multiplication), so it is stateful since it remembers the intermediate accumulated result.

  -------------------------
  COMPARISON BETWEEN STATELESS AND STATEFUL OPERATIONS
  -------------------------
  
  1. **Performance**:
     - **Stateless operations** are typically faster as they don't need to store or track any intermediate states.
     - **Stateful operations** may be slower due to the added complexity of maintaining state (e.g., sorting, removing duplicates, etc.).

  2. **Memory**:
     - **Stateless operations** do not require additional memory because they do not track previous elements.
     - **Stateful operations** often require extra memory, as they need to remember previous states or track elements (e.g., `distinct()`).

  3. **Execution Order**:
     - **Stateless operations** can be parallelized easily since each element is independent.
     - **Stateful operations** typically require sequential execution because they depend on the order or previous results of the elements (e.g., `sorted()`, `reduce()`).

  4. **Use Cases**:
     - **Stateless operations** are ideal when you need to apply simple transformations or filters that do not rely on the stream's order.
     - **Stateful operations** are useful when you need to maintain order, remove duplicates, or accumulate results over multiple elements.

  -------------------------
  PRACTICAL EXAMPLES
  -------------------------
  
  1. **Stateless Operation Example**: 
     - **`map()`**: Transforms each element in the stream (e.g., squaring numbers). Each element is processed independently.
  
  2. **Stateful Operation Example**:
     - **`sorted()`**: Sorts elements in a particular order, which requires comparing the elements and thus maintaining state.
     - **`distinct()`**: Removes duplicate elements by keeping track of previously seen elements, requiring memory.

  -------------------------
  CONCLUSION
  -------------------------
  
  - **Stateless operations** are generally more efficient as they don’t require additional memory or computational overhead.
  - **Stateful operations**, although more powerful (e.g., sorting, removing duplicates), come with a performance cost and require extra memory or tracking.
*/
