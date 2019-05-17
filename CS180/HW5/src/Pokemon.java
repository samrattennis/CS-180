import java.util.*;
public class Pokemon {
    private static int NUM_POKEMONS = 0;
    private String name;
    private int Id;
    private String type;
    private int healthPower;
    private double baseAttackPower;

    public Pokemon(String name, String type, int healthPower, double baseAttackPower) {
        this.name = name;
        if (type.equalsIgnoreCase("Fire") || type.equalsIgnoreCase("Electric") || type.equalsIgnoreCase("Water") ||
                type.equalsIgnoreCase("Grass")) {
            type = type.substring(0, 1).toUpperCase() + type.substring(1).toLowerCase();
            this.type = type;
        } else {
            this.type = "Fire";
        }
        if (healthPower > 0) {
            this.healthPower = healthPower;
        } else {
            this.healthPower = 0;
        }
        if (baseAttackPower > 0) {
            this.baseAttackPower = baseAttackPower;
        } else {
            this.baseAttackPower = 1;
        }
        this.Id = NUM_POKEMONS++;

    }
    public String getName() {
        return name;
    }

    public int getId() {
        return Id;
    }

    public String getType() {
        return type;
    }

    public int getHealthPower() {
        return healthPower;
    }

    public double getBaseAttackPower() {
        return baseAttackPower;
    }

    public boolean setType(String type) {
        if (type.equalsIgnoreCase("Fire") || type.equalsIgnoreCase("Water") ||
                type.equalsIgnoreCase("Grass") || type.equalsIgnoreCase("Electric")) {
            this.type = type;
            return true;
        } else {
            return false;
        }
    }

    public boolean setHealthPower(int healthPower) {
        if (healthPower > 0) {
            this.healthPower = healthPower;
            return true;
        } else {
            this.healthPower = 0;
            return false;
        }
    }

    public boolean setBaseAttackPower(double baseAttackPower) {
        if (baseAttackPower < 0) {
            return false;
        } else {
            this.baseAttackPower = baseAttackPower;
            return true;
        }
    }

    public String toString() {
        return ("Name: " + getName() + "\n" + "ID: " + getId() + "\n" + "Type: " + getType() +
                "\n" + "Health Power (HP): " + getHealthPower() + "\n" + "Attack Power: " + getBaseAttackPower());
    }

    public boolean isDead() {
        if (healthPower == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void boostHealthPower(int healthPower) {
        this.healthPower += healthPower;
    }

    public void reduceHealthPower(int healthPower) {
        if (healthPower > getHealthPower()) {
            this.healthPower = 0;
        } else {
            this.healthPower -= healthPower;
        }
    }

    public static int battle(Pokemon p1, Pokemon p2) {
        double newHealthPower = p1.getHealthPower();
        double newHealthPower2 = p2.getHealthPower();

        double newBasePower = p1.getBaseAttackPower();
        double newBasePower2 = p2.getBaseAttackPower();

        while (newHealthPower > 0 && newHealthPower2 > 0) {
            newHealthPower = newHealthPower - (newBasePower2 * getAttackMultiplier(p2, p1));
            newHealthPower2 = newHealthPower2 - (newBasePower * getAttackMultiplier(p1, p2));
        }

        p1.setHealthPower((int) newHealthPower);
        p2.setHealthPower((int) newHealthPower2);

        if (p1.getHealthPower() > p2.getHealthPower()) {
            return 1;
        } else {
            return 2;
        }
    }

    public static double getAttackMultiplier(Pokemon attacker, Pokemon defender) {
        if ((attacker.getType().equals("Grass") && defender.getType().equals("Grass")) ||
                (attacker.getType().equals("Grass") && defender.getType().equals("Fire")) ||
                (attacker.getType().equals("Electric") && defender.getType().equals("Electric")) ||
                (attacker.getType().equals("Electric") && defender.getType().equals("Grass")) ||
                (attacker.getType().equals("Water") && defender.getType().equals("Water")) ||
                (attacker.getType().equals("Water") && defender.getType().equals("Grass")) ||
                (attacker.getType().equals("Fire") && defender.getType().equals("Fire")) ||
                (attacker.getType().equals("Fire") && defender.getType().equals("Water"))) {
            return 0.5;
        } else if ((attacker.getType().equals("Grass") && defender.getType().equals("Electric")) ||
                (attacker.getType().equals("Electric") && defender.getType().equals("Fire")) ||
                (attacker.getType().equals("Water") && defender.getType().equals("Electric")) ||
                (attacker.getType().equals("Fire") && defender.getType().equals("Electric"))) {
            return 1;
        } else {
            return 2;
        }
    }

    public static int battleOracle(Pokemon p1, Pokemon p2) {
        double newHealthPower = p1.getHealthPower();
        double newHealthPower2 = p2.getHealthPower();

        double newBasePower = p1.getBaseAttackPower();
        double newBasePower2 = p2.getBaseAttackPower();

        while (newHealthPower > 0 && newHealthPower2 > 0) {
            newHealthPower = (newHealthPower - (newBasePower2 * getAttackMultiplier(p2, p1)));
            newHealthPower2 = (newHealthPower2 - (newBasePower * getAttackMultiplier(p1, p2)));
        }

        if (newHealthPower > newHealthPower2) {
            return 1;
        } else {
            return 2;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("----- CS180 Pokemon Gym -----");

        System.out.println("Enter the first Pokemon's name:");
        String firstPokemon = scan.nextLine();
        MyUtils my = new MyUtils();
        my.formatStr(firstPokemon);

        System.out.println("Enter the first Pokemon's type:");
        String type = my.formatStr(scan.nextLine());

        System.out.println("Enter the first Pokemon's Health Power (HP):");
        String healthPower = scan.nextLine();
        while (!my.isNumeric(healthPower)) {
            if (!my.isNumeric(healthPower)) {
                System.out.println("Invalid Health Power (HP) entered. Please re-enter." + "\n" +
                        "Enter the first Pokemon's Health Power (HP):" );
            }
            healthPower = scan.nextLine();
        }
            int hp = Integer.parseInt(healthPower);

        System.out.println("Enter the first Pokemon's Base Attack's Power:");
        String attackPower = scan.nextLine();
        while (!my.isNumeric(attackPower)) {
            if (!my.isNumeric(attackPower)) {
                System.out.println("Invalid Base Attack Power entered. Please re-enter." + "\n" +
                        "Enter the second Pokemon's Base Attack Power:" );
            }
            attackPower = scan.nextLine();
        }
        int ap = Integer.parseInt(attackPower);

        Pokemon pk1 = new Pokemon(firstPokemon, type, hp, ap);

        System.out.println("Enter the second Pokemon's name:");
        String secondPokemon = scan.next();
        my.formatStr(secondPokemon);

        System.out.println("Enter the second Pokemon's type:");
        String type2 = scan.next();
        my.formatStr(type2);

        System.out.println("Enter the second Pokemon's Health Power (HP):");
        String healthPower2 = scan.next();
        while(!my.isNumeric(healthPower2)) {
            if (!my.isNumeric(healthPower2)) {
                System.out.println("Invalid Health Power (HP) entered. Please re-enter." + "\n" +
                        "Enter the second Pokemon's Health Power (HP):");
            }
            healthPower2 = scan.next();
        }
        int hp2 = Integer.parseInt(healthPower2);

        System.out.println("Enter the second Pokemon Base Attack's Power:");
        String attackPower2 = scan.next();
        while (!my.isNumeric(attackPower2)) {
            if (!my.isNumeric(attackPower2)) {
                System.out.println("Invalid Base Attack Power entered. Please re-enter." + "\n" +
                        "Enter the second Pokemon's Base Attack Power :" );
            }
            attackPower2 = scan.next();
        }
        int ap2 = Integer.parseInt(attackPower2);

        Pokemon pk2 = new Pokemon(secondPokemon, type2, hp2, ap2);

        int winnerOfBattle = battle(pk1, pk2);

        System.out.println("Reducing by " + ap2);
        System.out.println(pk1.getHealthPower());

        System.out.println("Reducing by " + ap);
        System.out.println(pk2.getHealthPower());

        System.out.println("First Pokemon's Stats after the battle:" + "\n");

        System.out.println(pk1.toString());
        System.out.println("----------------" + "\n" + "\n" + "Second Pokemon's Stats after the battle:" + "\n");
        System.out.println(pk2.toString());
        System.out.println("----------------------------");
        System.out.print("----------------------------");

        if (winnerOfBattle == 1) {
            System.out.println("\n" + "\n" + "The winner of battle is " + pk1.getName());
        } else {
            System.out.println("\n" + "\n" + "The winner of battle is " + pk2.getName());
        }
    }
}

