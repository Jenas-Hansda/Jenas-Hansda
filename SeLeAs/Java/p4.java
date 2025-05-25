// Program to find the maximum among three numbers
import java.util.Scanner;

public class p4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter 1st value: ");
        double a = sc.nextDouble();

        System.out.print("Enter 2nd value: ");
        double b = sc.nextDouble();

        System.out.print("Enter 3rd value: ");
        double c = sc.nextDouble();

        if (a == b && b == c) {
            System.out.println("All three values are equal: " + a);
        } else if (a >= b && a >= c) {
            System.out.println("The value " + a + " is the greatest.");
        } else if (b >= a && b >= c) {
            System.out.println("The value " + b + " is the greatest.");
        } else {
            System.out.println("The value " + c + " is the greatest.");
        }

        sc.close();
    }
}
