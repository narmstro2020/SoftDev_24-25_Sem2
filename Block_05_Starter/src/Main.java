public class Main {
    public static void main(String[] args) {
        ResizableArray<String> stringArray = new ResizableArray<>();
        ResizableArray<Integer> integerArray = new ResizableArray<>();
        ResizableArray<Double> doubleArray = new ResizableArray<>();

        stringArray.add("World");
        stringArray.add("World");
        stringArray.add("Hello");
        stringArray.add("World");
        stringArray.add("Hello");
        stringArray.add("Hello");
        stringArray.add("World");
        stringArray.add("Hello");
        stringArray.add("World");

        stringArray.sort();

        for(int i = 0; i < stringArray.size(); i++){
            System.out.println(stringArray.get(i));
        }

    }

}
