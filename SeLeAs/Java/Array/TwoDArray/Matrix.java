package Array.TwoDArray;
import java.util.*;
public class Matrix {
    public static boolean search(int matrix[][], int key){
        for(int i=0; i<matrix.length ; i++){
            for(int j=0 ; j<matrix[0].length ; j++){
                if(matrix[i][j] == key){
                    System.out.println("Found at cell ( "+i+" , "+j+" )");
                    return true;
            }
            }
        }
        System.out.print("Key not Found");
        return false;
    }
    public static void main(String args[]){
        int matrix[][] = new int[3][3];
        int n = matrix.length,  m = matrix[0].length;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Value(e.g., 1 2 3 4 5 6 7 8 9) :- ");
        for(int i=0; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        // Output
        for(int i=0; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                System.out.print(matrix[i][j] + " ");                
            }
            System.out.println();
            
        }
        search(matrix, 5);
    }
}
