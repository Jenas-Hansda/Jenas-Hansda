import java.util.Scanner;

public class AreaofCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the radius: ");
        double r = sc.nextDouble();

        if (r < 0) {
            System.out.println("Radius cannot be negative.");
        } else {
            double area = Math.PI * r * r;
            System.out.printf("The area of the circle with radius %.2f is %.2f\n", r, area);
        }

        sc.close();
    }
}
