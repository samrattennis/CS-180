import java.util.*;
import java.lang.Math;

public class Player {
    private String name;
    private double positionX;
    private double positionY;

    public Player(String name){
      this.name = name;
    }
    public Player(String name, double positionX, double positionY) {
        this.name = name;
        this.positionX = positionX;
        this.positionY = positionY;
    }
    public String getName() {
        return name;
    }
    public double getPositionX() {
        return positionX;
    }
    public double getPositionY() {
        return positionY;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void moveX(double offsetX) {
        positionX = positionX + offsetX;
    }

    public void moveY(double offsetY) {
        positionY = positionY + offsetY;
    }

    public void moveInDirection(double theta, double distance) {
        distance = Math.abs(distance);
        theta = Math.toRadians(theta);

        while (theta >= (2 * Math.PI)) {
            theta = theta - (2 * Math.PI);
        }

        if (theta <= ((Math.PI)/2)) {
            positionX = positionX + (Math.cos(theta) * distance);
            positionY = positionY + (Math.sin(theta) * distance);
        } else if (theta > ((Math.PI)/2) && theta <= (Math.PI)) {
            theta = Math.PI - theta;
            Math.abs(theta);
            positionX = positionX + ((Math.cos(theta) * distance) * -1);
            positionY = positionY + (Math.sin(theta) * distance);
        } else if (theta > (Math.PI) && theta <= (((Math.PI) * 3) / 2)) {
            theta = theta - Math.PI;
            Math.abs(theta);
            positionX = positionX + ((Math.cos(theta) * distance) * -1);
            positionY = positionY + ((Math.sin(theta) * distance) * -1);
        } else {
            theta = (2 * Math.PI) - theta;
            Math.abs(theta);
            positionX = positionX + (Math.cos(theta) * distance);
            positionY = positionY + ((Math.sin(theta) * distance) * -1);
        }

     }

    public boolean hasSamePositionAs(Player player) {
        if (distanceFrom(player) <= 0.001) {
            return true;
        } else {
            return false;
        }
    }
    public double distanceFrom(Player player) {
        double distance = (Math.sqrt(Math.pow(positionX - player.positionX, 2) + Math.pow(positionY - player.positionY, 2)));
        return distance;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("What is the name of player 1:");
        String firstName = scan.nextLine();
        System.out.println("Enter the starting xPosition of " + firstName);
        double positionX = scan.nextDouble();
        System.out.println("Enter the starting yPosition of " + firstName);
        double positionY = scan.nextDouble();

        System.out.println("What is the name of player 2:");
        String secondName = scan.next();
        System.out.println("Enter the starting xPosition of " + secondName);
        double positionx = scan.nextDouble();
        System.out.println("Enter the starting yPosition of " + secondName);
        double positiony = scan.nextDouble();

        Player firstPlayer = new Player(firstName, positionX, positionY);
        Player secondPlayer = new Player(secondName, positionx, positiony);

        System.out.println("Enter " + firstName + "'s horizontal move offset");
        double horizontalOffSet1 = scan.nextDouble();
        System.out.println("Enter " + firstName + "'s vertical move offset");
        double verticalOffSet1 = scan.nextDouble();
        System.out.println("Enter " + firstName + "'s diagonal move angle degrees");
        double firstAngle = scan.nextDouble();
        System.out.println("Enter " + firstName + "'s diagonal move distance");
        double distance1 = scan.nextDouble();

        firstPlayer.moveX(horizontalOffSet1);
        firstPlayer.moveY(verticalOffSet1);
        firstPlayer.moveInDirection(firstAngle, distance1);

        System.out.println("Enter " + secondName + "'s horizontal move offset");
        double horizontalOffSet2 = scan.nextDouble();
        System.out.println("Enter " + secondName + "'s vertical move offset");
        double verticalOffSet2 = scan.nextDouble();
        System.out.println("Enter " + secondName + "'s diagonal move angle degrees");
        double secondAngle = scan.nextDouble();
        System.out.println("Enter " + secondName + "'s diagonal move distance");
        double distance2 = scan.nextDouble();

        secondPlayer.moveX(horizontalOffSet2);
        secondPlayer.moveY(verticalOffSet2);
        secondPlayer.moveInDirection(secondAngle, distance2);

        System.out.println(firstName + "'s position: " + "(" + String.format("%.5f" , firstPlayer.positionX) + ", " + String.format("%.5f" ,firstPlayer.positionY) + ")");
        System.out.println(secondName + "'s position: " + "(" + String.format("%.5f" ,secondPlayer.positionX) + ", " + String.format("%.5f" ,secondPlayer.positionY) + ")" );
        System.out.println("Distance between players: " + String.format("%.5f" ,secondPlayer.distanceFrom(firstPlayer)));
        System.out.println("Same position: " + secondPlayer.hasSamePositionAs(firstPlayer));
    }
}
