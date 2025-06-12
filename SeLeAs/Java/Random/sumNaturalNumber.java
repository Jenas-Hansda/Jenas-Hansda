import java.util.Scanner;

public class sumNaturalNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive number: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a number greater than zero.");
            sc.close();
            return;
        }

        // Call usingWhile or usingFor here
        int result = usingWhile(n);  // Change to usingFor(n) if desired

        System.out.println("The sum of the first " + n + " natural numbers is: " + result);

        sc.close();
    }

    public static int usingFor(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static int usingWhile(int n) {
        int sum = 0;
        int i = 1;
        while (i <= n) {
            sum += i;
            i++;
        }
        return sum;
    }
}
