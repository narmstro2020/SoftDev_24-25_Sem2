
# Complete Tutorial on Java Generics

## Table of Contents
1. **Introduction to Generics**
    - Definition
    - Benefits of Using Generics
    - Vocabulary
2. **Syntax of Generics**
    - Generic Classes
    - Generic Methods
    - Bounded Type Parameters
3. **Generics with Collections**
    - Overview of Java Collections Framework
    - Using Generics with Collections
4. **Wildcards in Generics**
    - The `?` Wildcard
    - Bounded Wildcards
5. **Generic Interfaces**
    - Definition
    - Examples
6. **Type Erasure**
    - What is Type Erasure?
    - Implications of Type Erasure
7. **Best Practices and Common Pitfalls**
8. **Assignments**
9. **Assignment Solutions**

---

## 1. Introduction to Generics

### Definition
Generics are a feature in Java that allows types (classes and interfaces) to be parameterized. They were introduced in Java 5 to ensure type safety and reduce the risk of `ClassCastException` at runtime.

### Benefits of Using Generics
- **Type Safety**: Generics ensure that only specific types of objects are added to collections or variables.
- **Elimination of Type Casting**: Generics eliminate the need for explicit casting.
- **Code Reusability**: Generic code can be written once and reused with different types.

### Vocabulary
- **Type Parameter**: A placeholder for a type (e.g., `<T>`).
- **Bounded Type**: A type parameter that is constrained by a superclass or interface.
- **Wildcard**: A special kind of parameter (`?`) used in generics.
- **Type Erasure**: The process by which type parameters are removed at runtime.

---

## 2. Syntax of Generics

### Generic Classes
A generic class is defined with one or more type parameters.

```java
public class Box<T> {
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}
```

### Generic Methods
Methods can also use generics.

```java
public static <T> void printArray(T[] array) {
    for (T element : array) {
        System.out.println(element);
    }
}
```

### Bounded Type Parameters
Bounded type parameters constrain the types that can be used as arguments.

```java
public class NumberBox<T extends Number> {
    private T number;

    public void setNumber(T number) {
        this.number = number;
    }

    public T getNumber() {
        return number;
    }
}
```

---

## 3. Generics with Collections

### Overview of Java Collections Framework
The Java Collections Framework includes interfaces like `List`, `Set`, `Map`, and classes like `ArrayList`, `HashSet`, and `HashMap`.

### Using Generics with Collections
```java
List<String> list = new ArrayList<>();
list.add("Hello");
String value = list.get(0); // No need for casting
```

---

## 4. Wildcards in Generics

### The `?` Wildcard
The `?` wildcard represents an unknown type.

```java
public void printList(List<?> list) {
    for (Object obj : list) {
        System.out.println(obj);
    }
}
```

### Bounded Wildcards
- **Upper Bound**: Restricts the wildcard to a type or its subtypes.
  ```java
  public void processNumbers(List<? extends Number> numbers) { }
  ```
- **Lower Bound**: Restricts the wildcard to a type or its supertypes.
  ```java
  public void addNumbers(List<? super Integer> numbers) { }
  ```

---

## 5. Generic Interfaces

### Definition
Generic interfaces define type parameters for use in methods.

```java
public interface Pair<K, V> {
    K getKey();
    V getValue();
}
```

### Examples
```java
public class OrderedPair<K, V> implements Pair<K, V> {
    private K key;
    private V value;

    public OrderedPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }
}
```

---

## 6. Type Erasure

### What is Type Erasure?
Type erasure removes type parameters at runtime, replacing them with their bounds or `Object` if no bounds are specified.

### Implications
- No runtime type information for generics.
- Cannot use primitives as type parameters directly.

---

## 7. Best Practices and Common Pitfalls

### Best Practices
- Use descriptive type parameter names like `<T>` (Type), `<E>` (Element), `<K>` (Key), `<V>` (Value).
- Use wildcards to improve API flexibility.

### Common Pitfalls
- Overusing wildcards can lead to confusion.
- Mixing raw types with generics leads to warnings and potential runtime issues.

---