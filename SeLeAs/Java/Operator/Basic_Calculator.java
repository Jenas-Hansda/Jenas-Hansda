package Operator;

import java.util.Scanner;

public class Basic_Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter 1st Value:- ");
        double fi = sc.nextDouble();
        System.out.print("Enter 2nd Value:- ");
        double se = sc.nextDouble();
        System.out.printf("The Modulas of %f and %f is %f\n", fi, se, fi % se);
        System.out.printf("The Division of %f and %f is %f\n", fi, se, fi / se);
        System.out.printf("The Multiplication of %f and %f is %f\n", fi, se, fi * se);
        System.out.printf("The Addition of %f and %f is %f\n", fi, se, fi + se);
        System.out.printf("The Substraction of %f and %f is %f\n", fi, se, fi - se);
        sc.close();
    }
}