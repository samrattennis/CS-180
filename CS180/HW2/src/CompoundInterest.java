import java.util.Scanner;
import java.lang.Math;
public class CompoundInterest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double principle = 0 , interestRate = 0, years = 0;
        int interest = 0;

        System.out.println("Enter principle");
        principle = scan.nextInt();

        System.out.println("Enter interest rate");
        interestRate = scan.nextInt();

        System.out.println("Enter years");
        years = scan.nextInt();

        interest = (int) (Math.round(principle * Math.pow(1 + interestRate/100, years) - principle));
        System.out.println("Interest = " + interest);
    }
}
