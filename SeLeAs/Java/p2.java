// The Sum of First n Natural Numbers using while loop

import java.util.Scanner;

public class p2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a valid number: ");
        int n = sc.nextInt();

        int result = usingFor(n);  // 👈 calling external function

        System.out.println("The Sum of First " + n + " Natural Numbers is: " + result);

        sc.close();
    }

    // 👇 External method to calculate sum Using for loop
    public static int usingFor(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    // 👇 External method to calculate sum Using while loop
    public static int usingWhile(int n) {
        int sum = 0;
        int i = 1; // Start from 1 since natural numbers start at 1

        while (i <= n) {
            sum = sum + i;
            i++;
        }
        return sum;
    }
}
