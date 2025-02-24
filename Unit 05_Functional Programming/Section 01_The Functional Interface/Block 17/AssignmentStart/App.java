public class App {

    public static void main(String[] args) {

        GCDCalculator gcd = (a, b) -> {
            while (b != 0) {
                int oldB = b;
                b = a % b;
                a = oldB;
            }
            return a;
        };
    }

    @FunctionalInterface
    public interface GCDCalculator {
        int gcd(int a, int b);
    }

    // GCD Notes

    // gcd of 12, 8 is what:      12 % 8 = 1 R 4 = 4
    // 12 -> 2, 2, 3
    // 8 -> 2, 2
    // gcd = 2 * 2 = 4

    // 1st Cycle
    // a = 12, b = 8
    // b = a % b, a = oldB  : a = 8, b = 4
    // 2nd Cycle
    // a = 4, b = 0
}
