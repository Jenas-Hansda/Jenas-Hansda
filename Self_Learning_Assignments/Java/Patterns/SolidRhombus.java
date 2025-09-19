import java.util.*;

public class SolidRhombus {
    public static void SolidRhombusPyramid(int n){
        // Outer Loop for No of Lines
        for(int i = 1;i<=n; i++){
            // For Printing Spaces
            for(int j=1;j<=n-i;j++){
                // Using Print to Print Space in Same Line
                System.out.print(" ");
            }
            for(int j=1;j<=n;j++){
                // Using Print to Print * in Same Line
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        // Using Scanner to User Input
        Scanner sc = new Scanner(System.in);
        // Entering Input
        System.out.print("Enter Number :- ");
        int n = sc.nextInt();
        // Calling Function
        SolidRhombusPyramid(n);
        sc.close();
}
}