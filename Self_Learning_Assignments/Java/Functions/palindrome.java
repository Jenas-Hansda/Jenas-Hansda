package Functions;

import java.util.*;

public class palindrome {
    public static void ispalindrome(int n){
        int palindrome = n; // copied number into variable
        int reverse = 0;
        while (palindrome != 0) {
            int remainder = palindrome % 10;
            reverse = reverse * 10 + remainder;
            palindrome = palindrome / 10;
        }
        if (n == reverse) {
            System.out.printf("The Value %d is Palindrome", n);
        } else {
            System.out.printf("The Value %d is Not Palindrome", n);
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Value :- ");
        int n = sc.nextInt();
        ispalindrome(n);
        sc.close();
    }
}
