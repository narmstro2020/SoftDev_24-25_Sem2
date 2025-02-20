# Java Tutorial: Comparators and Their Use in the Java Collections API

## Table of Contents

1. [Introduction to Comparators](#1-introduction-to-comparators)
2. [Comparator<T> Interface](#2-comparatort-interface)
3. [Implementing Comparators](#3-implementing-comparators)
4. [Using Comparators with Java Collections](#4-using-comparators-with-java-collections)
5. [Method References and Lambdas with Comparators](#5-method-references-and-lambdas-with-comparators)
6. [Built-in Comparator Methods](#6-built-in-comparator-methods)
7. [Custom Sorting Examples](#7-custom-sorting-examples)
8. [Assignments](#8-assignments)
9. [Assignment Solutions](#9-assignment-solutions)

---

## 1. Introduction to Comparators

### Vocabulary

| Term          | Definition |
|--------------|------------|
| **Comparator** | An interface in Java that defines a custom sorting order for objects. |
| **Comparable** | An interface that imposes a natural ordering of objects. |
| **Custom Sorting** | Sorting an object list using a user-defined comparator. |
| **Functional Interface** | An interface with a single abstract method, allowing lambda expressions. |

### Description

In Java, objects of a class can be sorted in two ways:
1. Using the `Comparable` interface, which defines a **natural ordering**.
2. Using the `Comparator` interface, which allows **custom ordering**.

`Comparator<T>` is useful when:
- You cannot modify the class whose objects need sorting.
- You want multiple sorting criteria for the same class.
- The natural ordering using `Comparable` isn't sufficient.

---

## 2. `Comparator<T>` Interface

### Vocabulary

| Term          | Definition |
|--------------|------------|
| **compare(T o1, T o2)** | The only abstract method in the `Comparator` interface, which compares two objects. |
| **Reversed Order** | Sorting in the opposite order of the default behavior. |
| **Equality Comparison** | Checking whether two objects are "equal" in a sorting sense. |

### Description

The `Comparator<T>` interface provides a single method:

```java
int compare(T o1, T o2);
```

- Returns **negative** if `o1` is less than `o2`.
- Returns **zero** if `o1` equals `o2`.
- Returns **positive** if `o1` is greater than `o2`.

### Example

```java
import java.util.Comparator;

public class NameComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return s1.compareTo(s2); // Alphabetical order
    }
}
```

---

## 3. Implementing Comparators

### Vocabulary

| Term          | Definition |
|--------------|------------|
| **Anonymous Class** | A class without a name, typically used for short-lived functionality. |
| **Lambda Expression** | A concise way to express an implementation of a functional interface. |
| **Sorting Criteria** | The rule that defines how elements are ordered. |

### Description

You can implement a comparator in multiple ways:

1. **Using a Separate Class** (Traditional Method)
2. **Using an Anonymous Inner Class**
3. **Using a Lambda Expression** (Modern Approach)

### Example 1: Separate Class Implementation

```java
import java.util.Comparator;

class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return Integer.compare(p1.getAge(), p2.getAge());
    }
}
```

### Example 2: Anonymous Inner Class

```java
Comparator<Person> ageComparator = new Comparator<Person>() {
    @Override
    public int compare(Person p1, Person p2) {
        return Integer.compare(p1.getAge(), p2.getAge());
    }
};
```

### Example 3: Lambda Expression

```java
Comparator<Person> ageComparator = (p1, p2) -> Integer.compare(p1.getAge(), p2.getAge());
```

---

## 4. Using Comparators with Java Collections

### Vocabulary

| Term          | Definition |
|--------------|------------|
| **Collections.sort()** | A method that sorts a list using either `Comparable` or `Comparator`. |
| **TreeSet** | A `Set` that stores elements in sorted order. |
| **PriorityQueue** | A queue that retrieves elements in a sorted order. |

### Example: Sorting a List

```java
import java.util.*;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));

        people.sort(new AgeComparator());

        System.out.println(people);
    }
}
```

---

## 8. Examples

### Examples 1: Sorting Employees
- Create an `Employee` class with `name`, `salary`, and `age`.
- Implement a comparator to sort by salary (descending order).
- Sort employees and print the results.

```java
class Employee {
    String name;
    double salary;
    int age;

    Employee(String name, double salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " - $" + salary;
    }
}

Comparator<Employee> salaryComparator = (e1, e2) -> Double.compare(e2.salary, e1.salary);
employees.sort(salaryComparator);
```


### Examples 2: Custom PriorityQueue
- Create a `PriorityQueue` of tasks (`Task` class with `priority` and `description`).
- Implement a comparator to process higher priority tasks first.

```java
class Task {
    int priority;
    String description;

    Task(int priority, String description) {
        this.priority = priority;
        this.description = description;
    }
}

PriorityQueue<Task> taskQueue = new PriorityQueue<>((t1, t2) -> Integer.compare(t2.priority, t1.priority));
```
---
