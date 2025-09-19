package Functions;

import java.util.*;

public class Average {

    public static void Solution(double a, double b, double c) {
        double Ave = (a + b + c) / 3;
        System.out.print("The Average is " + Ave);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter First Value :- ");
        double a = sc.nextDouble();
        System.out.print("Enter Second Value :- ");
        double b = sc.nextDouble();
        System.out.print("Enter Third Value :- ");
        double c = sc.nextDouble();
        Solution(a, b, c);
        sc.close();

    }
}