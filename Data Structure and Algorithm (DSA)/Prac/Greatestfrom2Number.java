import java.util.Scanner;

public class Greatestfrom2Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter First Digit: ");
        double first = scanner.nextDouble();

        System.out.print("Enter Second Digit: ");
        double second = scanner.nextDouble();

        if (first > second) {
            System.out.printf("First Digit : %.2f is greater than Second Digit: %.2f%n", first, second);
        } else if (first == second) {
            System.out.printf("First Digit: %.2f is equal to Second Digit: %.2f%n", first, second);
        } else {
            System.out.printf("Second Digit: %.2f is greater than FirstDigit: %.2f%n", second, first);
        }

        scanner.close();
    }
}
