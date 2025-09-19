package Operator;

import java.util.Scanner;

public class Swap {

    public static void swap(int numbers[]) {
        // Assuming you want to swap numbers[0] and numbers[1]
        if (numbers.length < 2) {
            System.out.println("Need at least two elements to swap.");
            return;
        }

        System.out.println("Before swapping: a = " + numbers[0] + ", b = " + numbers[1]);

        // Swap using arithmetic
        numbers[0] = numbers[0] + numbers[1];  // a = a+b
        numbers[1] = numbers[0] - numbers[1];  // b = (a+b)-b
        numbers[0] = numbers[0] - numbers[1];  // a = (a+b)-a

        System.out.println("After swapping: a = " + numbers[0] + ", b = " + numbers[1]);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = new int[2];
        System.out.print("Enter first number: ");
        numbers[0] = sc.nextInt();

        System.out.print("Enter second number: ");
        numbers[1] = sc.nextInt();

        swap(numbers);

        sc.close();
    }
}
