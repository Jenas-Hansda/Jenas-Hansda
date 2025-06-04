import java.util.*;

public class InvertedHalfPyramid {
    public static void Pyramid_Number(int n){
        // Outer Loop
        for(int i=1; i<=n; i++){
            // Inner Loop
            for(int j=1; j<=n-i+1; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number:- ");
        int n = sc.nextInt();
        Pyramid_Number(n);
        sc.close();
    }
}