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

        //Sort
        resizableArray.sort();
    }
}