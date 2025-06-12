

public class Sol1 {
    public static void BruteForce(int[][] matrix, int key) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == key) {
                    count++;
                }
            }
        }

        if (count > 0) {
            System.out.println("Element Found " + count + " time(s).");
        } else {
            System.out.println("Element Not Found.");
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {4, 7, 8},
            {8, 8, 7}
        };
        int key = 7;
        BruteForce(matrix, key);
    }
}
