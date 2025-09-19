import java.util.*;

public class WeekName {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Digit between 1 to 7 :- ");
        int n = sc.nextInt();
        switch(n){
            case 1: System.out.println("Monday");
            break ;
            case 2: System.out.println("Tuesday");
            break ;
            case 3: System.out.println("Wednesday");
            break ;
            case 4: System.out.println("Thrusday");
            break ;
            case 5: System.out.println("Friday");
            break ;
            case 6: System.out.println("Saturday");
            break ;
            case 7: System.out.println("Sunday");
            break ;
            default :
            System.out.println("Entered Invalid Digit");

        }
        sc.close();

    }
    
}
