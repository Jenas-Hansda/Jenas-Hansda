import java.util.Scanner;

public class EvenNumberBetweentwoDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Starting Point: ");
        int start = scanner.nextInt();

        System.out.print("Enter Ending Point: ");
        int end = scanner.nextInt();

        System.out.println("Even numbers between " + start + " and " + end + ":");

        for (int i = start; i <= end; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }

        scanner.close();
    }
}
