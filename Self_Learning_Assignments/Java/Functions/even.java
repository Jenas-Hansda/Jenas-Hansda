package Functions;
import java.util.*;
public class even {
    public static void isEven(int n){
        if( n%2 == 0){
            System.out.printf("The digit %d is Even",n);
        } else {
            System.out.printf("The digit %d is Not Even",n);
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Value :- ");
        int n = sc.nextInt();
        isEven(n);
        sc.close();
    }
}
