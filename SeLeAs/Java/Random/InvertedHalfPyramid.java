import java.util.*;

public class InvertedHalfPyramid {
    public static void printInvertedHalfPyramid(int numRows) {
        for (int i = 1; i <= numRows; i++) {
            for (int j = 1; j <= numRows - i + 1; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Rows: ");
        int numRows = sc.nextInt();

        if (numRows <= 0) {
            System.out.println("Please enter a positive number.");
        } else {
            printInvertedHalfPyramid(numRows);
        }

        sc.close();
    }
}
