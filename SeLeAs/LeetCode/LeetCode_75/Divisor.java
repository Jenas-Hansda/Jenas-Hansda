import java.util.Scanner;

class Divisor {
    public boolean isThree(int n) {
        if (n <= 3) {
            return false;
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }

        return count == 3;  // Simplified return statement
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        Divisor sol = new Divisor();
        boolean result = sol.isThree(number);

        System.out.println("Does " +number + " has exactly three divisors: " + result);

        scanner.close(); // Close the scanner to prevent resource leaks
    }
}
