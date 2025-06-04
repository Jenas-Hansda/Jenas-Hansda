import java.util.*;

public class Hollow_RectangleP {
    public static void Hollow_Rectangle(int totRows, int totCols){
        // Outer Loop for no of Lines
        for(int i=1; i<=totRows; i++){
            // Inner Loop for printing Content
            for(int j = 1;j<=totCols; j++ ){
                // Cell - (i,j)
                if(i==1 || i==totRows || j==1 || j==totCols){
                    // Boundary Cells Printing
                    System.out.print("*");
                } else {
                    // Middle Cells Space
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
    public static void main(String args[]){
        // Using Scanner to User Input
        Scanner sc = new Scanner(System.in);
        // Entering First Input
        System.out.print("Enter Length/Row :- ");
        int totCols = sc.nextInt();
        // Entering Second Input
        System.out.print("Enter Bredth/Column :- ");
        int totRows = sc.nextInt();
        // Calling Function
        Hollow_Rectangle(totRows, totCols);
        sc.close();
    }
}