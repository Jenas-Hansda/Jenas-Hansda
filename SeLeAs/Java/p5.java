// Area of Circle
import java.util.Scanner;

public class p5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the radius: ");
        double r = sc.nextDouble();

        double area = Math.PI * r * r;

        System.out.printf("The area of the circle with radius %.2f is %.2f\n", r, area);

        sc.close();
    }
}
