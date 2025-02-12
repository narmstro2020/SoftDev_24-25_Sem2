# Java Collections Framework Tutorial

## 1. Lists

### Vocabulary
- **List**: An ordered collection (also known as a sequence).
- **ArrayList**: A resizable array implementation of the List interface.
- **LinkedList**: A doubly-linked list implementation of the List interface.
- **Vector**: A synchronized, resizable array implementation.
- **Stack**: A subclass of Vector representing a last-in-first-out (LIFO) stack.

### Description
A `List` is an ordered collection that allows duplicate elements. The elements in a `List` are indexed, meaning they can be accessed using their position in the list.

### Example Code
```java
import java.util.*;

public class ListExample {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Cherry");

        System.out.println("ArrayList: " + arrayList);
    }
}
```

## 2. Sets

### Vocabulary
- **Set**: A collection that does not allow duplicate elements.
- **HashSet**: Implements a set using a hash table.
- **TreeSet**: Implements a sorted set using a red-black tree.
- **LinkedHashSet**: Maintains insertion order while avoiding duplicates.

### Description
A `Set` is an unordered collection that ensures uniqueness of elements.

### Example Code
```java
import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>();
        numbers.add(5);
        numbers.add(10);
        numbers.add(5);

        System.out.println("HashSet: " + numbers);
    }
}
```

## 3. Maps

### Vocabulary
- **Map**: A collection that maps keys to values.
- **HashMap**: Implements a map using a hash table.
- **TreeMap**: Implements a sorted map using a red-black tree.
- **LinkedHashMap**: Maintains insertion order of key-value pairs.

### Description
A `Map` is a collection of key-value pairs where each key is unique.

### Example Code
```java
import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        Map<String, Integer> ages = new HashMap<>();
        ages.put("Alice", 25);
        ages.put("Bob", 30);

        System.out.println("HashMap: " + ages);
    }
}
```

## 4. Common Implementations

| Collection Type | Implementation | Order Maintained | Allows Duplicates |
|----------------|---------------|-----------------|-----------------|
| List | ArrayList | Yes | Yes |
| List | LinkedList | Yes | Yes |
| Set | HashSet | No | No |
| Set | TreeSet | Sorted | No |
| Map | HashMap | No | No |
| Map | TreeMap | Sorted | No |

## 5. Iterators

### Vocabulary
- **Iterator**: An object for traversing collections.
- **ListIterator**: An iterator specifically for lists, allowing bidirectional iteration.

### Example Code
```java
import java.util.*;

public class IteratorExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B", "C");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
```

## 6. Streams

### Vocabulary
- **Stream**: A sequence of elements supporting functional-style operations.
- **filter()**: Filters elements based on a condition.
- **map()**: Transforms each element.
- **collect()**: Collects results into a collection.

### Example Code
```java
import java.util.*;
import java.util.stream.*;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println("Even Numbers: " + evenNumbers);
    }
}
```

## 7. Queues and Deques

### Vocabulary
- **Queue**: A collection designed for holding elements prior to processing.
- **Deque (Double-ended Queue)**: Allows insertion and removal from both ends.
- **PriorityQueue**: A queue where elements are ordered based on priority.

### Example Code
```java
import java.util.*;

public class QueueExample {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("Alice");
        queue.add("Bob");
        queue.add("Charlie");

        System.out.println("Queue: " + queue);
        System.out.println("Removed: " + queue.poll());
    }
}
```

