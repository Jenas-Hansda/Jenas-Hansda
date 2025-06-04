import java.util.*;
public class InvertedZeroOnePattern {
    public static void ZeroOnePatternPyramid(int n){
        // Outer Loop for No of Lines
        for(int i = 1;i<=n; i++){
            // For Printing Spaces
            for(int j=1;j<=n-i;j++){
                // Using Print to Print Space in Same Line
                if((i+j) % 2 == 0){
                    // Even
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
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
        ZeroOnePatternPyramid(n);
        sc.close();
}
}
