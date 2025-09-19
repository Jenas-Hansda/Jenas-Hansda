import java.util.Scanner;

public class SimpleInterest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Principal Amount: ");
        double principal = sc.nextDouble();

        System.out.print("Enter Rate of Interest (in %): ");
        double rate = sc.nextDouble();

        System.out.print("Enter Time Period (in years): ");
        double time = sc.nextDouble();

        double simpleInterest = (principal * rate * time) / 100;

        System.out.printf("Calculated Simple Interest is: %.2f\n", simpleInterest);

        sc.close();
    }
}
