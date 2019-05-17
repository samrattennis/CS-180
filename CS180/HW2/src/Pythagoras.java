import java.util.Scanner;
import java.lang.Math;
public class Pythagoras {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a, b;

        System.out.println("Enter a");
        a = scan.nextInt();

        System.out.println("Enter b");
        b = scan.nextInt();

        double hypotenuse = Math.round(Math.sqrt(a*a +b*b));
        System.out.println("Hypotenuse = " + hypotenuse);
    }
}
