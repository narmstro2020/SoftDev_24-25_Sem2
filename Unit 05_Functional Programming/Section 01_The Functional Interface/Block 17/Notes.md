
# Java Functional Programming Interface Tutorial

## Table of Contents
1. **Introduction to Functional Programming in Java**
2. **Core Vocabulary**
3. **Functional Interfaces**
4. **Lambda Expressions**
5. **Method References**
6. **Built-in Functional Interfaces**
    - Predicate
    - Function
    - Consumer
    - Supplier
    - UnaryOperator
    - BinaryOperator
7. **Streams API Integration**
8. **Custom Functional Interfaces**
9. **Higher-Order Functions**
10. **Pure Functions and Immutability**
11. **Assignments**
12. **Solutions**

---

### 1. Introduction to Functional Programming in Java

Functional programming (FP) is a programming paradigm where functions are first-class citizens. Java introduced functional programming constructs starting with Java 8, enabling developers to write more concise, readable, and maintainable code.

**Benefits of Functional Programming:**
- Concise code
- Easier testing
- Encourages immutability
- Reduces side effects

**Comparison with Object-Oriented Programming:**
- Focuses on functions rather than objects
- Reduces state management complexity
- Emphasizes immutability instead of encapsulation

---

### 2. Core Vocabulary
| Term                | Definition |
|---------------------|------------|
| **Functional Interface** | An interface with a single abstract method (SAM). |
| **Lambda Expression**   | A concise way to represent an instance of a functional interface. |
| **Higher-Order Function** | A function that takes another function as an argument or returns a function. |
| **Immutability**        | The property where data cannot be changed once created. |
| **Closure**             | A function that captures variables from its surrounding scope. |
| **Currying**            | Breaking down a function that takes multiple arguments into a series of functions that each take one argument. |
| **Lazy Evaluation**     | Postponing computation until the result is needed. |

---

### 3. Functional Interfaces

A **functional interface** is an interface that contains exactly one abstract method. Examples include `Runnable`, `Callable`, and custom interfaces.

**Real-World Use Cases:**
- Event listeners
- Custom sorting logic in collections
- Callback functions

**Syntax Example:**
```java
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}
```

---

### 4. Lambda Expressions

A **lambda expression** is a shorthand representation of an anonymous function.

**Syntax:**
```java
(parameters) -> expression
```

**Multi-Line Example:**
```java
Calculator add = (a, b) -> {
    int result = a + b;
    return result;
};
System.out.println(add.calculate(5, 3)); // Output: 8
```

**Capturing Variables:**
```java
int factor = 2;
Calculator multiply = (a, b) -> (a + b) * factor;
System.out.println(multiply.calculate(2, 3)); // Output: 10
```

---

### 5. Method References

A **method reference** refers to a method without invoking it.

**Syntax:**
```java
ClassName::methodName
```

**Example:**
```java
List<String> list = Arrays.asList("apple", "banana", "cherry");
list.forEach(System.out::println);
```

**Constructor Reference:**
```java
Supplier<List<String>> listSupplier = ArrayList::new;
```

**Instance Method Reference:**
```java
String prefix = "Hello, ";
Function<String, String> greeter = prefix::concat;
```

---

### 6. Built-in Functional Interfaces

Java provides several built-in functional interfaces in `java.util.function` package:

#### a) Predicate
Tests a condition and returns a boolean.

**Syntax:**
```java
Predicate<String> isEmpty = String::isEmpty;
```

#### b) Function
Takes one argument and returns a result.

**Syntax:**
```java
Function<String, Integer> length = String::length;
```

#### c) Consumer
Consumes input and returns nothing.

**Syntax:**
```java
Consumer<String> printer = System.out::println;
```

#### d) Supplier
Supplies a result without any input.

**Syntax:**
```java
Supplier<Double> randomSupplier = Math::random;
```

#### e) UnaryOperator
Represents an operation on a single operand that produces a result of the same type.

**Syntax:**
```java
UnaryOperator<Integer> square = x -> x * x;
```

#### f) BinaryOperator
Represents an operation on two operands of the same type.

**Syntax:**
```java
BinaryOperator<Integer> add = (a, b) -> a + b;
```

---

### 7. Streams API Integration

Streams allow functional-style operations on collections.

**Example:**
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
List<String> filtered = names.stream()
    .filter(name -> name.startsWith("A"))
    .collect(Collectors.toList());
```

**Terminal Operations:**
```java
int sum = IntStream.of(1, 2, 3, 4, 5)
    .reduce(0, Integer::sum);
```

---

### 8. Custom Functional Interfaces

You can create custom interfaces to suit specific needs.

**Example:**
```java
@FunctionalInterface
interface StringManipulator {
    String manipulate(String input);
}
```

**When to Use Custom Interfaces:**
- Complex domain-specific operations
- When built-in interfaces don’t meet specific requirements

---

### 9. Higher-Order Functions

Functions that take other functions as arguments or return functions.

**Example:**
```java
public static void executeOperation(Calculator calc, int a, int b) {
    System.out.println(calc.calculate(a, b));
}

public static Calculator multiplyByFactor(int factor) {
    return (a, b) -> (a + b) * factor;
}
```

---

### 10. Pure Functions and Immutability

- **Pure Function:** Always returns the same output for the same input without side effects.
- **Immutability:** Prevents changing state after creation.

**Example of Pure Function:**
```java
int square(int x) {
    return x * x;
}
```

**Using `final` for Immutability:**
```java
final List<String> immutableList = List.of("Java", "Functional", "Programming");
```

---

### 11. Examples


#### **Example 1: Filtering and Transforming a List**
Using Java's Streams API:
- Filter out all even numbers from a list of integers.
- Square the remaining odd numbers.
- Collect and print the squared numbers as a new list.
```java
import java.util.*;
import java.util.stream.*;

public class StreamFilterExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> result = numbers.stream()
            .filter(n -> n % 2 != 0)  // Filter odd numbers
            .map(n -> n * n)         // Square each number
            .collect(Collectors.toList());

        System.out.println("Squared odd numbers: " + result); // Output: [1, 9, 25]
    }
}
```
#### **Example 2: Filtering Strings by Length**
Create a program that:
- Uses the `Predicate` interface to filter a list of strings.
- Filters strings that have more than 5 characters.
- Prints the filtered list.
```java
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class StringFilter {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hello", "world", "functional", "java", "stream");
        Predicate<String> lengthPredicate = word -> word.length() > 5;
        
        List<String> filteredWords = words.stream()
            .filter(lengthPredicate)
            .collect(Collectors.toList());

        System.out.println("Words longer than 5 characters: " + filteredWords); // Output: [functional, stream]
    }
}
```
---
