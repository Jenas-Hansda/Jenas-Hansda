// Calculating Simple Interest
import java.util.Scanner;
public class p3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Principle Amount:- ");
        Double p = sc.nextDouble();
        System.out.println("Enter Rate of Interest:- ");
        Double r = sc.nextDouble();
        System.out.println("Enter Tenure of Amount:- ");
        Double t = sc.nextDouble();
        double si = (p*r*t)/100;
        System.out.println("Calculate Simple Interest is:- " + si);
        sc.close();



    }
}
