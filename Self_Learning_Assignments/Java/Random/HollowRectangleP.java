import java.util.*;

public class HollowRectangleP {
    public static void printHollowRectangle(int totRows, int totCols) {
        for (int i = 1; i <= totRows; i++) {
            for (int j = 1; j <= totCols; j++) {
                if (i == 1 || i == totRows || j == 1 || j == totCols) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of Rows (Height): ");
        int totRows = sc.nextInt();
        System.out.print("Enter number of Columns (Width): ");
        int totCols = sc.nextInt();

        if (totRows <= 0 || totCols <= 0) {
            System.out.println("Rows and columns must be positive integers.");
        } else {
            printHollowRectangle(totRows, totCols);
        }

        sc.close();
    }
}
