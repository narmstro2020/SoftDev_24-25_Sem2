# Java 2D Arrays Manipulation Tutorial

## Vocabulary

- **2D Array**: A two-dimensional array, also called a matrix, is an array of arrays where data is stored in rows and columns.
- **Row**: A single horizontal collection of elements in a 2D array.
- **Column**: A single vertical collection of elements in a 2D array.
- **Index**: The position of an element in the array, represented by a pair of integers for 2D arrays (row and column).
- **Iteration**: The process of traversing through the elements of an array.

## Detailed Explanations

### Declaring and Initializing 2D Arrays

In Java, a 2D array is declared using the following syntax:

```java
int[][] array = new int[rows][columns];
```

You can also initialize a 2D array directly with values:

```java
int[][] array = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};
```

### Accessing Elements

Elements in a 2D array are accessed using their row and column indices:

```java
int value = array[row][column];
```

### Iterating Through a 2D Array

#### Using Nested Loops

```java
for (int i = 0; i < array.length; i++) { // Loop through rows
    for (int j = 0; j < array[i].length; j++) { // Loop through columns
        System.out.print(array[i][j] + " ");
    }
    System.out.println();
}
```

#### Using Enhanced For Loop

```java
for (int[] row : array) {
    for (int value : row) {
        System.out.print(value + " ");
    }
    System.out.println();
}
```

### Common Operations

#### Sum of All Elements

```java
int sum = 0;
for (int i = 0; i < array.length; i++) {
    for (int j = 0; j < array[i].length; j++) {
        sum += array[i][j];
    }
}
System.out.println("Sum: " + sum);
```

#### Finding the Maximum Element

```java
int max = Integer.MIN_VALUE;
for (int i = 0; i < array.length; i++) {
    for (int j = 0; j < array[i].length; j++) {
        if (array[i][j] > max) {
            max = array[i][j];
        }
    }
}
System.out.println("Max: " + max);
```

#### Transposing a Matrix

```java
int[][] transpose = new int[array[0].length][array.length];
for (int i = 0; i < array.length; i++) {
    for (int j = 0; j < array[i].length; j++) {
        transpose[j][i] = array[i][j];
    }
}
```