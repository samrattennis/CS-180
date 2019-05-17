import java.util.*;
public class StarGenerator1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();

        int ran = r.nextInt(4) + 1;
        System.out.println("Please enter your name:");
        String name = s.nextLine();
        System.out.println("Please enter the college that you are in:");
        String college = s.nextLine();
        
        String email = name.toLowerCase();
        String college1 = college.toUpperCase();
        String col = college1.substring(0, 3);

        String part1 = email.substring(0,1);
        String part2 = email.substring(email.indexOf(" ") + 1);
        String email1 = part1 + part2;

        System.out.println("Your Name: " + name);
        System.out.println("Your Email: " + email1 +"@purdue.edu" );
        System.out.println("Your College: " + college);
        System.out.println("STAR Group: " + col + ran);
    }
}
