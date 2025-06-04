import java.util.*;
public class ZeroOnePattern {
    public static void ZeroOne(int n){
        // Outer Loop        
        for(int i =1; i<=n ; i++){
            // Inner Loop
            for(int j=1; j<=i ; j++){
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
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter No of Column :- ");
        int n = sc.nextInt();
        ZeroOne(n);
        sc.close();
    }
}
