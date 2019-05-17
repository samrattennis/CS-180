import java.util.*;

public class Game {

    private final static int ROCK = 1;
    private final static int PAPER = 2;
    private final static int SCISSORS = 3;
    private int computerMove;

    public void runGame() {
        Scanner scan = new Scanner(System.in);
        int num = 0;
        System.out.println("Welcome");
        while (num != 4) {
            System.out.println("Please enter an option: ");
            System.out.println("1. Rock" + "\n" + "2. Paper" + "\n" + "3. Scissors" + "\n" + "4. Exit");
            num = scan.nextInt();
            computerMove = simulateComputerMove();
            checkWinner(num, computerMove);
        }
    }

    private int checkWinner(int move1, int move2) {
        if (move1 == ROCK) {
            if (move2 == ROCK)
                System.out.println("You played rock!" + "\n" + "The computer played rock!" + "\n" + "Draw!");
        } else if (move1 == PAPER) {
            if (move2 == PAPER)
                System.out.println("You played paper!" + "\n" + "The computer played paper!" + "\n" + "Draw!");
        } else if (move1 == SCISSORS) {
            if (move2 == SCISSORS)
                System.out.println("You played scissors!" + "\n" + "The computer played scissors!" + "\n" + "Draw!");
        }
        if (move1 == PAPER) {
            if (move2 == ROCK)
                System.out.println("You played paper!" + "\n" + "The computer played rock!" + "\n" + "You win!");
        } else if (move1 == SCISSORS) {
            if (move2 == PAPER)
                System.out.println("You played scissors!" + "\n" + "The computer played paper!" + "\n" + "You win!");
        } else if (move1 == ROCK) {
            if (move2 == SCISSORS)
                System.out.println("You played rock!" + "\n" + "The computer played scissors!" + "\n" + "You win!");
        }
        if (move1 == SCISSORS) {
            if (move2 == ROCK)
                System.out.println("You played scissors!" + "\n" + "The computer played rock!" + "\n" + "You lose!");
        } else if (move1 == ROCK) {
            if (move2 == PAPER)
                System.out.println("You played rock!" + "\n" + "The computer played paper!" + "\n" + "You lose!");
        } else if (move1 == PAPER) {
            if (move2 == SCISSORS)
                System.out.println("You played paper!" + "\n" + "The computer played scissors!" + "\n" + "You lose!");
        }
        if (move1 == 4) {
            System.out.println("Thanks for playing!");
        }
        return 0;
    }

    private int simulateComputerMove() {
        Random r = new Random();
        computerMove = r.nextInt(3) + 1;
        return computerMove;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.runGame();
    }
}


