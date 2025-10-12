import java.util.Scanner;

public class AreaofaCircle{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Radius ");
        double r = scanner.nextDouble();
        double area = Math.PI*r*r;
        System.out.printf("Area of Circle with Radius %.2f is: %.2f%n", r, area);
        scanner.close();
    }
}