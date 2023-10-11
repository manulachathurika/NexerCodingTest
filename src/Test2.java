import java.util.stream.IntStream;

public class Test2 {
    public static void main(String[] args) {
        System.out.println("Coding Test 2:\n");

        int numberOfStars = 5; // Change this value to adjust the number of stars

        if (numberOfStars <= 0) {
            System.out.println("Number of stars should be grater than zero");
            return;
        }

        printStarsUsingJava8(numberOfStars);
        //printStars(numberOfStars);

    }

    // Print stars using Java8
    private static void printStarsUsingJava8(int numberOfStars) {
        IntStream.range(0, numberOfStars)
                .forEach(i -> {
                    String stars = "*".repeat(numberOfStars - i);
                    System.out.println(stars);
                });
    }

    // Print stars using two for loops
    private static void printStars(int rowCount) {

        for (int i = rowCount; i >= 1; i-- ) {
            for (int j = i; j >= 1; j--) {
                System.out.print("*");
            }
            System.out.println("\n");
        }
    }
}