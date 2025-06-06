import java.util.*;

public class PositiveorNegative{
    public static void Solution(int n){
        if(n==0){
            System.out.print("The Number is Zero");
        } else if(n>0){
            System.out.print("The Number is positive");
        }else {
            System.out.print("The Number is negative");
        }
    }
    public static void main(String ars[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Digit:- ");
        int n = sc.nextInt();
        Solution(n);
        sc.close();
    }
}