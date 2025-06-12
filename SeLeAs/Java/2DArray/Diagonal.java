

public class Diagonal {

    public static int diagonalSumBruteF(int matrix[][]) {
        int sum = 0;
        // For Primary Diagonal
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j) {
                    sum += matrix[i][j];
                }
                // For Secondary
                else if(i+j == matrix.length-1){
                    sum+=matrix[i][j];
                }
            }
        }
        return sum; 
    }


    public static int diagonalSumOptimise(int matrix[][]) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            // Primary Diagonal
            sum+= matrix[i][i];
            // Secondary Diagonal
            if(i != matrix.length-1-i){
                sum+=matrix[i][matrix.length-i-1];
            }
        }
        return sum;        
    }

    public static void main(String args[]) {
        int matrix[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8, },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        
                // Brute Force O(n^2)
        // System.out.println(diagonalSumBruteF(matrix));

        // Optimise O(n)
        System.out.println(diagonalSumOptimise(matrix));
    }
}