Write a Java program that:
1. Reads a list of words from the user.
2. Uses a `HashMap` to count occurrences of each word.
3. Prints the word count.

```java
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("Enter a word, or enter Q to quit:  ");
            String input = sc.nextLine();
            if(input.equals("Q")){
                break;
            }
            if (map.containsKey(input)) {
                int value = map.get(input);
                // TODO: add 1 to the value;
                map.put(input, value);
            }else{
                map.put(input, 1);
            }
        }

        int totalWordSum = 0;
        for (var entry : map.entrySet()) {
            totalWordSum += entry.getValue();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Total Word Count: " + totalWordSum);

    }
}

```