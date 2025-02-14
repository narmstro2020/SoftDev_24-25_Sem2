# **Java Comparable Interface and Its Use in the Java Collections API**

## **Table of Contents**
1. Introduction to the Comparable Interface
2. Comparable Interface Methods
3. Implementing Comparable in a Custom Class
4. Sorting Collections with Comparable
5. Comparable vs Comparator
6. Best Practices for Implementing Comparable
7. Assignments
8. Assignment Solutions

---

## **1. Introduction to the Comparable Interface**
### **Vocabulary**
| Term | Definition |
|------|------------|
| `Comparable<T>` | A functional interface in Java that allows objects of a class to be compared to each other. |
| Natural Ordering | The default order in which objects are sorted (e.g., alphabetical for strings, ascending for numbers). |
| `compareTo()` | The method defined in the `Comparable` interface that compares `this` object to another object. |
| Sorting | Arranging elements in a specific order, typically ascending or descending. |
| Collections API | A framework in Java that provides classes and interfaces for handling groups of objects, including sorting methods. |

### **Description**
The `Comparable` interface is used in Java when we want to define a natural ordering for a class. It allows objects to be sorted automatically when used with Java’s sorting methods, such as `Collections.sort()`.

### **Key Features**
- The `Comparable` interface is part of `java.lang` and does not require an import.
- It is a functional interface with a single method:
  ```java
  int compareTo(T o);
  ```
- The `compareTo()` method returns:
    - A negative integer if `this` object is **less than** `o`.
    - Zero if they are **equal**.
    - A positive integer if `this` object is **greater than** `o`.

---

## **2. Comparable Interface Methods**
### **Vocabulary**
| Term | Definition |
|------|------------|
| `compareTo(T o)` | The only method in `Comparable` used to compare two objects. |
| Contract | A set of rules that methods must follow to ensure consistent and reliable results. |

### **Method Signature**
```java
int compareTo(T o);
```

### **Method Behavior**
The `compareTo()` method compares the current object (`this`) with another object (`o`).

### **Return Values**
| Return Value | Meaning |
|-------------|---------|
| `< 0` | `this` is less than `o` |
| `0` | `this` is equal to `o` |
| `> 0` | `this` is greater than `o` |

### **Example**
```java
public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return name + " (" + age + " years old)";
    }
}
```

In this example, `compareTo()` sorts `Person` objects by age.

---

## **3. Implementing Comparable in a Custom Class**
### **Vocabulary**
| Term | Definition |
|------|------------|
| Custom Class | A user-defined class that models real-world entities. |
| Natural Order | The default sorting order for objects of a class. |

### **Steps to Implement Comparable**
1. Make the class implement `Comparable<T>`.
2. Override the `compareTo()` method.
3. Implement comparison logic.

### **Example: Sorting Books by Title**
```java
import java.util.*;

class Book implements Comparable<Book> {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }

    @Override
    public String toString() {
        return "Book: " + title;
    }
}

public class ComparableExample {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Java Programming"));
        books.add(new Book("Algorithms"));
        books.add(new Book("Data Structures"));

        Collections.sort(books);
        System.out.println(books);
    }
}
```
**Output:**
```
[Book: Algorithms, Book: Data Structures, Book: Java Programming]
```

---

## **4. Sorting Collections with Comparable**
### **Vocabulary**
| Term | Definition |
|------|------------|
| `Collections.sort()` | A method that sorts a list of objects implementing `Comparable`. |
| Immutable | A state in which an object cannot be modified after creation. |

### **Sorting a List**
```java
List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 4);
Collections.sort(numbers);
System.out.println(numbers); // Output: [1, 2, 4, 5, 9]
```

### **Sorting Custom Objects**
```java
Collections.sort(books);
```
This works if `Book` implements `Comparable<Book>`.

---

## **5. Comparable vs Comparator**
### **Vocabulary**
| Term | Definition |
|------|------------|
| `Comparator<T>` | A separate interface used to define custom sorting logic. |
| `compare()` | A method in `Comparator` that takes two objects and compares them. |

### **Comparison Table**
| Feature | Comparable | Comparator |
|---------|-----------|-----------|
| Interface Type | Functional | Functional |
| Method | `compareTo(T o)` | `compare(T o1, T o2)` |
| Location | Inside the class | Separate class |
| Used For | Natural ordering | Custom ordering |

### **Example: Using Comparator**
```java
class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return Integer.compare(p1.getAge(), p2.getAge());
    }
}
```

---

## **6. Best Practices for Implementing Comparable**
1. Ensure `compareTo()` is **consistent** with `equals()`.
2. Avoid using multiple fields in comparison unless necessary.
3. Use `Integer.compare()`, `Double.compare()`, and `String.compareTo()` for clarity.
4. Consider `Comparator` for multiple sorting criteria.

---

## **7. More Examples**
1. Create an `Employee` class with `name` and `salary`. Implement `Comparable<Employee>` to sort employees alphabetically.

---

## **8. More Examples Solutions**

### **1. Sorting Employees Solution**
```java
class Employee implements Comparable<Employee> {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee other) {
        return this.name.compareTo(other.name);
    }
}
```
