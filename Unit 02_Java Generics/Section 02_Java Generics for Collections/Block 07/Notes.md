
# Tutorial: Creating a Simple Resizable Array in Java Using Generics

This tutorial will guide you through creating a simple resizable array (similar to `ArrayList`) using Java's generics. It includes definitions, example code, and explanations.

---

## 1. Key Concepts
Before diving into the code, let's review key concepts.

### **Generics**
- **Definition**: Generics enable classes, interfaces, and methods to operate on different types of objects without compromising type safety.
- **Syntax**: `<T>` represents a type parameter (placeholder for the type).

### **Resizable Array**
- **Definition**: A resizable array dynamically adjusts its capacity as elements are added or removed.
- **Key Operations**: Adding, removing, resizing, and accessing elements.

---

## 2. Implementation

### Step 1: Define the Class
We will create a generic class named `ResizableArray` with a type parameter `<T>`.

```java
public class ResizableArray<T> {
    private T[] array; // Internal array to store elements
    private int size;  // Number of elements in the array

    @SuppressWarnings("unchecked")
    public ResizableArray() {
        array = (T[]) new Object[10]; // Default capacity
        size = 0;
    }
}
```

---

### Step 2: Add an Element
Implement the `add` method to add elements to the array. Resize the array if necessary.

```java
public void add(T element) {
    if (size == array.length) {
        resize();
    }
    array[size++] = element;
}

@SuppressWarnings("unchecked")
private void resize() {
    T[] newArray = (T[]) new Object[array.length * 2];
    System.arraycopy(array, 0, newArray, 0, array.length);
    array = newArray;
}
```

---

### Step 3: Get an Element
Retrieve an element at a specific index.

```java
public T get(int index) {
    if (index < 0 || index >= size) {
        throw new IndexOutOfBoundsException("Index out of bounds: " + index);
    }
    return array[index];
}
```

---

### Step 4: Remove an Element
Remove an element at a specific index and shift the remaining elements.

```java
public T remove(int index) {
    if (index < 0 || index >= size) {
        throw new IndexOutOfBoundsException("Index out of bounds: " + index);
    }
    T removedElement = array[index];
    for (int i = index; i < size - 1; i++) {
        array[i] = array[i + 1];
    }
    array[--size] = null; // Prevent memory leaks
    return removedElement;
}
```

---

### Step 5: Additional Utility Methods
Add utility methods such as `size` and `isEmpty`.

```java
public int size() {
    return size;
}

public boolean isEmpty() {
    return size == 0;
}
```

---

## 3. Complete Code
Here's the complete implementation of the `ResizableArray` class.

```java
public class ResizableArray<T> {
    private T[] array;
    private int size;

    @SuppressWarnings("unchecked")
    public ResizableArray() {
        array = (T[]) new Object[10];
        size = 0;
    }

    public void add(T element) {
        if (size == array.length) {
            resize();
        }
        array[size++] = element;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newArray = (T[]) new Object[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return array[index];
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        T removedElement = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--size] = null;
        return removedElement;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
```

---

## 4. Example Usage
Here’s how you can use the `ResizableArray` class:

```java
public class Main {
    public static void main(String[] args) {
        ResizableArray<String> resizableArray = new ResizableArray<>();

        // Add elements
        resizableArray.add("Hello");
        resizableArray.add("World");
        resizableArray.add("Java");

        // Access elements
        System.out.println(resizableArray.get(0)); // Output: Hello

        // Remove an element
        resizableArray.remove(1);
        System.out.println(resizableArray.get(1)); // Output: Java

        // Check size
        System.out.println("Size: " + resizableArray.size()); // Output: 2
    }
}
```

---

## 5. Key Takeaways
1. **Generics** ensure type safety while maintaining flexibility.
2. **Dynamic resizing** allows efficient memory usage without predefining array size.
3. **Error handling** like `IndexOutOfBoundsException` ensures robustness.

---

This resizable array is a foundational data structure that you can extend with more features like sorting, searching, or iterators.
