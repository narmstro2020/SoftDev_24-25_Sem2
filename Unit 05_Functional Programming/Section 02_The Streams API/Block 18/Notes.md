# Java Stream API Tutorial

## Table of Contents
1. Introduction to Java Stream API
2. Key Vocabulary
3. Creating Streams
4. Intermediate Operations
5. Terminal Operations
6. Collecting Results with Collectors
7. Parallel Streams
8. Stream API Best Practices
9. Assignments
10. Assignment Solutions

---

## 1. Introduction to Java Stream API
The Java Stream API was introduced in Java 8 to facilitate functional-style operations on collections of elements. It allows developers to process data in a declarative way, reducing boilerplate code and improving readability.

### Benefits of Streams:
- Provides a functional approach to handling collections
- Supports operations like filtering, mapping, and reducing
- Enables parallel execution for performance improvement
- Works efficiently with lambda expressions

---

## 2. Key Vocabulary

| Term | Definition |
|------|------------|
| Stream | A sequence of elements supporting sequential and parallel aggregate operations. |
| Intermediate Operation | An operation on a stream that returns another stream, allowing method chaining. |
| Terminal Operation | An operation that produces a result or side effect and terminates the stream pipeline. |
| Lazy Evaluation | The principle where intermediate operations are not executed until a terminal operation is invoked. |
| Parallel Stream | A stream that can process elements in parallel to improve performance. |

---

## 3. Creating Streams
Streams can be created from different data sources like collections, arrays, and I/O channels.

### Example Code:
```java
import java.util.*;
import java.util.stream.*;

public class StreamCreation {
    public static void main(String[] args) {
        // Creating a stream from a list
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        Stream<String> nameStream = names.stream();

        // Creating a stream from an array
        String[] nameArray = {"Dave", "Eve", "Frank"};
        Stream<String> arrayStream = Arrays.stream(nameArray);

        // Creating a stream using Stream.of()
        Stream<Integer> numberStream = Stream.of(1, 2, 3, 4, 5);

        // Creating an infinite stream
        Stream<Integer> infiniteStream = Stream.iterate(0, n -> n + 2);
    }
}
```

---

## 4. Intermediate Operations
Intermediate operations transform a stream into another stream. They are executed lazily.

### Common Intermediate Operations:

| Method | Description |
|--------|-------------|
| `filter(Predicate<T>)` | Filters elements based on a condition. |
| `map(Function<T,R>)` | Transforms elements using a function. |
| `flatMap(Function<T, Stream<R>>)` | Flattens nested structures into a single stream. |
| `distinct()` | Removes duplicate elements. |
| `sorted()` | Sorts elements in natural order. |
| `limit(long n)` | Truncates the stream to the first `n` elements. |

### Example Code:
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Alice");
names.stream()
     .filter(name -> name.length() > 3)
     .distinct()
     .sorted()
     .forEach(System.out::println);
```

---

## 5. Terminal Operations
Terminal operations end the stream processing and produce a result.

### Common Terminal Operations:

| Method | Description |
|--------|-------------|
| `forEach(Consumer<T>)` | Iterates over each element. |
| `collect(Collector<T,A,R>)` | Converts a stream into a collection. |
| `reduce(BinaryOperator<T>)` | Reduces elements to a single value. |
| `count()` | Counts elements in a stream. |
| `anyMatch(Predicate<T>)` | Checks if any element matches a condition. |
| `allMatch(Predicate<T>)` | Checks if all elements match a condition. |

### Example Code:
```java
long count = Stream.of("Alice", "Bob", "Charlie")
                  .count();
System.out.println("Count: " + count);
```

---

## 6. Collecting Results with Collectors
Collectors help gather stream elements into collections or aggregate results.

### Example Code:
```java
List<String> collectedList = Stream.of("Apple", "Banana", "Cherry")
                                   .collect(Collectors.toList());
```

---

## 7. Parallel Streams
Parallel streams enable multi-threaded processing for performance optimization.

### Example Code:
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
numbers.parallelStream()
       .forEach(System.out::println);
```

---

## 8. Stream API Best Practices
- Avoid modifying the underlying data source inside a stream.
- Use parallel streams wisely, as they may not always improve performance.
- Prefer method references (`::`) for readability.

---

## 9. Examples

### Example 1: Word Count
Given a list of words, count how many words have more than four letters.
```java
List<String> words = Arrays.asList("apple", "dog", "elephant", "car");
long count = words.stream()
                  .filter(word -> word.length() > 4)
                  .count();
System.out.println("Count: " + count);
```
### Example 2: Parallel Processing
Convert a list of integers into their squares using a parallel stream.
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
List<Integer> squares = numbers.parallelStream()
                               .map(n -> n * n)
                               .collect(Collectors.toList());
System.out.println(squares);
```
---
