import java.util.*;

public class FlyodTrianglePattern {
    public static void FlyodsTrianglePattern(int n){
        // Outer Loop
        int count = 1;
        for(int i =1; i<=n ; i++){
            // Inner Loop
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
        FlyodsTrianglePattern(n);
        sc.close();
    }
}