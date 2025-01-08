
# Complete Tutorial on Java Arrays

## Table of Contents
1. Introduction to Arrays
2. Declaring and Initializing Arrays
3. Accessing Array Elements
4. Common Array Operations
   - Traversing Arrays
   - Updating Array Elements
   - Searching in Arrays
   - Sorting Arrays
5. Multi-dimensional Arrays
6. Arrays of Objects
7. Utility Methods with `java.util.Arrays`
8. Best Practices with Arrays
9. Assignments
   - Assignment 1: Basic Array Operations
   - Assignment 2: Advanced Array Manipulation
10. Solutions to Assignments

---

## 1. Introduction to Arrays

An array in Java is a container object that holds a fixed number of values of a single data type. The length of an array is established when the array is created, and it cannot be changed after creation. Arrays in Java are zero-indexed, meaning the first element is at index `0`.

### Key Vocabulary
- **Index**: Position of an element in an array.
- **Element**: A single value stored in an array.
- **Length**: The number of elements an array can hold.

---

## 2. Declaring and Initializing Arrays

### Declaring an Array
```java
int[] numbers; // Preferred style
// or
int numbers[]; // Valid but less common
```

### Initializing an Array
You can initialize arrays in different ways:

#### Static Initialization
```java
int[] numbers = {1, 2, 3, 4, 5};
```

#### Dynamic Initialization
```java
int[] numbers = new int[5];

// Assign values
numbers[0] = 1;
numbers[1] = 2;
numbers[2] = 3;
numbers[3] = 4;
numbers[4] = 5;
```

---

## 3. Accessing Array Elements

Array elements are accessed using their indices.

```java
int[] numbers = {10, 20, 30, 40, 50};
System.out.println("First Element: " + numbers[0]); // Output: 10
System.out.println("Last Element: " + numbers[numbers.length - 1]); // Output: 50
```

### Common Error
Accessing an index outside the array bounds results in an `ArrayIndexOutOfBoundsException`.

---

## 4. Common Array Operations

### Traversing Arrays
Using a `for` loop:
```java
int[] numbers = {10, 20, 30, 40, 50};
for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}
```

Using an enhanced `for` loop:
```java
for (int number : numbers) {
    System.out.println(number);
}
```

### Updating Array Elements
```java
numbers[2] = 35; // Update the 3rd element
```

### Searching in Arrays
Linear Search:
```java
int[] numbers = {10, 20, 30, 40, 50};
int target = 30;
boolean found = false;

for (int number : numbers) {
    if (number == target) {
        found = true;
        break;
    }
}
System.out.println("Found: " + found);
```

### Sorting Arrays
```java
int[] numbers = {50, 20, 40, 10, 30};
java.util.Arrays.sort(numbers);
System.out.println(java.util.Arrays.toString(numbers)); // Output: [10, 20, 30, 40, 50]
```

---

## 5. Multi-dimensional Arrays

### Declaring and Initializing
```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};
```

### Accessing Elements
```java
System.out.println(matrix[1][2]); // Output: 6
```

### Traversing
```java
for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
    }
    System.out.println();
}
```

---

## 6. Arrays of Objects

Arrays can store objects as well as primitive types.

```java
String[] names = {"Alice", "Bob", "Charlie"};
for (String name : names) {
    System.out.println(name);
}
```

---

## 7. Utility Methods with `java.util.Arrays`

- `toString()`: Converts the array to a string.
- `sort()`: Sorts the array.
- `binarySearch()`: Searches for an element in a sorted array.
- `copyOf()`: Copies the array.
- `fill()`: Fills the array with a specified value.

Example:
```java
int[] numbers = new int[5];
java.util.Arrays.fill(numbers, 42);
System.out.println(java.util.Arrays.toString(numbers)); // Output: [42, 42, 42, 42, 42]
```

---

## 8. Best Practices with Arrays
1. Prefer `ArrayList` or other collections for dynamic-sized data.
2. Always validate array indices before accessing elements.
3. Use `java.util.Arrays` for common operations.
4. Initialize arrays to avoid `NullPointerException`.

---

