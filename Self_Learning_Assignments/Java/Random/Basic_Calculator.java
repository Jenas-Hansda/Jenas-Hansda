

import java.util.Scanner;

public class Basic_Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter 1st Value: ");
        double fi = sc.nextDouble();
        System.out.print("Enter 2nd Value: ");
        double se = sc.nextDouble();

        if (se == 0) {
            System.out.println("Division or modulus by zero is not allowed.");
        } else {
            System.out.printf("The Modulus of %.2f and %.2f is %.2f\n", fi, se, fi % se);
            System.out.printf("The Division of %.2f and %.2f is %.2f\n", fi, se, fi / se);
        }

        System.out.printf("The Multiplication of %.2f and %.2f is %.2f\n", fi, se, fi * se);
        System.out.printf("The Addition of %.2f and %.2f is %.2f\n", fi, se, fi + se);
        System.out.printf("The Subtraction of %.2f and %.2f is %.2f\n", fi, se, fi - se);

        sc.close();
    }
}
