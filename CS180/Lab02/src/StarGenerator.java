import java.util.*;

public class StarGenerator {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random r = new Random();
        int ran = r.nextInt(4)+1;

        System.out.println("Please enter your name:");
        String name = scan.nextLine();

        System.out.println("Enter the college that you are in:");
        String college = scan.nextLine();

        String lower = name.toLowerCase();
        int space    = lower.indexOf(" ");
        int length   = lower.length();

        String first = lower.substring(0,1);
        String last  = lower.substring(space+1, length);
        String email = first + last + "@purdue.edu";

        String upper = college.toUpperCase();
        String col   = upper.substring(0,3);
        String star  = col + ran;

        System.out.println("Your Name: " + name);
        System.out.println("Your Email: " + email);
        System.out.println("Your College: " + college);
        System.out.println("STAR Group: " + star);

    }
}
