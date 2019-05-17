import java.util.Scanner;
public class SwapDigit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number, swappedNumber, one, two;

        System.out.println("Enter number");
        number = scan.nextInt();

        one = number % 10;
        two = number/10;
        swappedNumber = one * 10 + two;

        System.out.println("Swapped: " + swappedNumber);
    }
}
