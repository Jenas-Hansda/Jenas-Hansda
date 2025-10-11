import java.util.Scanner;

public class SumNaturalNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a Positive Integer");
        int n = scanner.nextInt();
        int result = 0;

        for (int i = 1; i <= n; i++) {
            result = result + i;
        }

        System.out.println("Sum of first " + n + " natural numbers is: " + result);
        scanner.close();
    }
}
