import java.util.Scanner;
public class EuroConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int dollar, dollarNumber;
        double euroNumber;

        System.out.println("Enter amount in USD");
        dollar = scan.nextInt();

        System.out.println("Enter number of $ in 100 Eur");
        dollarNumber = scan.nextInt();

        euroNumber = (dollar/dollarNumber) * 100;
        System.out.println("Number of euros = " + euroNumber);
    }
}
