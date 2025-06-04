import java.util.Scanner;

public class SpacedFlyodPattern {
    public static void SFlyodsTrianglePattern(int n){
        // Outer Loop
        int count = 1;
        for(int i =1; i<=n ; i++){
            // Inner Loop for space
            for(int j=1; j<=n-i ; j++){
                System.out.print(" ");
            }
            // Inner Loop for Digit
            for(int j=1; j<=i ; j++){
                System.out.print(count+" ");
                count++;
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Digit :- ");
        int n = sc.nextInt();
        SFlyodsTrianglePattern(n);
        sc.close();
    }
}
