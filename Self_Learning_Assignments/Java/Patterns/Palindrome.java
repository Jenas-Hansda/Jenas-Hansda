import java.util.Scanner;

public class Palindrome {
    public static void palindrome(int n){
        // Outer Loop 
        for(int i = 1;i<=n; i++){
            // Inner Loop for Spaces
            for(int j=1;j<=n-i;j++){
                System.out.print("  ");
            }
            for(int j=1;j<=i;j++){
                System.out.print(j+" ");
            }
            for(int j=1;j<=i-1;j++){
                // To Reverse Digit
                System.out.print(j+" ");
            }
            System.out.println();
        }
        // To Reverse the Palindrome
        for(int i = n-1;i>=1; i--){
            for(int j=1;j<=n-i;j++){
                System.out.print("  ");
            }
            for(int j=1;j<=i;j++){
                System.out.print(j+" ");
            }
            for(int j=1;j<=i-1;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter No Between 2 to 9 :- ");
        int n = sc.nextInt();
        palindrome(n);
        sc.close();
    }
}
