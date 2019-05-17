/**
 * CS180 - Lab 07
 *
 * This class contains a list of some of the on-campus and off-campus restaurants and cafes.
 * You should complete it to fulfill the requirements of lab07
 *
 */
import java.util.*;
public class Restaurants {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("1 - On campus " + "\n" + "2 - Off campus");
        int num1 = scan.nextInt();

        if (num1 == 1) {
            System.out.println("   Dietary" + "\n" + "restrictions?" + "\n" + "    (Y/N)");
            String yes = scan.next();

            if (yes.equals("Y")) {
                System.out.println("1 - Vegan" + "\n" + "2 - Vegetarian" + "\n" + "3 - Gluten-free");
                int num2 = scan.nextInt();
                if (num2 == 1) {
                    System.out.println(ON_CAMPUS_VEGAN);
                }
                else if (num2 == 2) {
                    System.out.println(ON_CAMPUS_VEGETARIAN);
                }
                else if (num2 == 3) {
                    System.out.println(ON_CAMPUS_GLUTEN_FREE);
                }
            }
            if (yes.equals("N")) {
                System.out.println("   Food" + "\n" + "preference?" + "\n" + "   (Y/N)");
                String no = scan.next();

                if (no.equals("Y")) {
                    System.out.println("1 - Burgers" + "\n" + "2 - Sandwiches" + "\n" + "3 - Others");
                    int num3 = scan.nextInt();
                    if (num3 == 1) {
                        System.out.println(ON_CAMPUS_BURGERS);
                    }
                    else if (num3 == 2) {
                        System.out.println(ON_CAMPUS_SANDWICHES);
                    }
                    else if (num3 == 3) {
                        System.out.println(ON_CAMPUS_OTHERS);
                    }
                }
                if (no.equals("N")) {
                    System.out.println(ON_CAMPUS_ALL);
                }
            }
        }
        if (num1 == 2) {
            System.out.println("   Dietary" + "\n" + "restrictions?" + "\n" + "    (Y/N)");
            String yes1 = scan.next();

            if (yes1.equals("Y")) {
                System.out.println("1 - Vegan" + "\n" + "2 - Vegetarian" + "\n" + "3 - Gluten-free");
                int num4 = scan.nextInt();
                if (num4 == 1) {
                    System.out.println(OFF_CAMPUS_VEGAN);
                }
                else if (num4 == 2) {
                    System.out.println(OFF_CAMPUS_VEGETARIAN);
                }
                else if (num4 == 3) {
                    System.out.println(OFF_CAMPUS_GLUTEN_FREE);
                }
            }
            if (yes1.equals("N")) {
                System.out.println("   Food" + "\n" + "preference?" + "\n" + "   (Y/N)");
                String no1 = scan.next();

                if (no1.equals("Y")) {
                    System.out.println("1 - Burgers" + "\n" + "2 - Sandwiches" + "\n" + "3 - Pizzas" + "\n" + "4 - Others");
                    int num5 = scan.nextInt();
                    if (num5 == 1) {
                        System.out.println(OFF_CAMPUS_BURGERS);
                    }
                    else if (num5 == 2) {
                        System.out.println(OFF_CAMPUS_SANDWICHES);
                    }
                    else if (num5 == 3) {
                        System.out.println(OFF_CAMPUS_PIZZAS);
                    }
                    else if (num5 == 4) {
                        System.out.println(OFF_CAMPUS_OTHERS);
                    }
                }
                if (no1.equals("N")) {
                    System.out.println(offCampusAll);
                }
            }
        }

    }
    // On campus
    public static final String ON_CAMPUS_VEGAN = "Purdue Dining Courts\nFlatbreads";
    public static final String ON_CAMPUS_VEGETARIAN = ON_CAMPUS_VEGAN + "\nOasis Cafe\nAh*Z\nFreshens";
    public static final String ON_CAMPUS_GLUTEN_FREE = "Purdue Dining Courts\nFlatbreads\nOasis Cafe\nPappy's " +
            "Sweet Shop";
    public static final String ON_CAMPUS_BURGERS = "Pappy's Sweet Shop\nCary Knight Spot";
    public static final String ON_CAMPUS_SANDWICHES = "Flatbreads\nOasis Cafe\nErbert & Gerbert's";
    public static final String ON_CAMPUS_OTHERS = "Purdue Dining Courts\nAh*Z\nFreshens\nLemongrass";
    public static final String ON_CAMPUS_ALL = ON_CAMPUS_BURGERS + "\n" + ON_CAMPUS_SANDWICHES + "\n" +
            ON_CAMPUS_OTHERS;

    // Off campus
    public static final String OFF_CAMPUS_VEGAN = "Chipotle\nQdoba\nNine Irish Brothers\nFive Guys\n Puccini's " +
            "Smiling Teeth\nPanera Bread";
    public static final String OFF_CAMPUS_VEGETARIAN = OFF_CAMPUS_VEGAN + "\nWendy's\nBruno's Pizza\nJimmy " +
            "John's\nPotbelly Sandwich Shop\nBasil Thai\nIndia Mahal";
    public static final String OFF_CAMPUS_GLUTEN_FREE = "Chipotle\nQdoba\nNine Irish Brothers\nPuccini's Smiling " +
            "Teeth\nWendy's\nScotty's Brewhouse\nPanera Bread\nBasil Thai";
    public static final String OFF_CAMPUS_BURGERS = "Five Guys\nWendy's\nTriple XXX\nScotty's Brewhouse";
    public static final String OFF_CAMPUS_SANDWICHES ="Panera Bread\nJimmy John's\nPotbelly Sandwich Shop";
    public static final String OFF_CAMPUS_PIZZAS = "Puccini's Smiling Teeth\nMad Mushroom Pizza\nBruno's Pizza\n";
    public static final String OFF_CAMPUS_OTHERS = "Chipotle\nQdoba\nNine Irish Brothers\nFamous Frank's\n Von's " +
            "Dough Shack\nBuffalo Wild Wings\nBasil Thai\nMaru Sushi\nIndia Mahal\nHappy China\nYori";
    public static final String offCampusAll = OFF_CAMPUS_BURGERS + "\n" + OFF_CAMPUS_SANDWICHES + "\n" +
            OFF_CAMPUS_PIZZAS + OFF_CAMPUS_OTHERS;
}
