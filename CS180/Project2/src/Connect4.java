/**
 * Created by Samrat on 10/10/16.
 */

import java.util.*;
import java.util.Arrays;

public class Connect4 {
    char[][] board = new char[6][7];
    Scanner in = new Scanner(System.in);

    public Connect4() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++)
                board[i][j] = ' ';
        }
    }

    public char[][] getBoard() {
        return Arrays.copyOf(board, board.length);
    }

    public int putPiece(int column, char color) {
        int r = 5;

        while (r != -1) {
            if (board[r][column] == ' ')
                break;
            r--;
        }

        while (r == -1) {
            System.out.print("Error: Column full. Choose another column: ");
            column = Integer.parseInt(in.nextLine());
            r = 5;

            while (r != -1) {
                if (board[r][column] == ' ')
                    break;
                r--;
            }
        }

        board[r][column] = color;
        return r;
    }

    public char checkAlignment(int row, int column) {
        int flag = 0;

        String list = "";

        //Vertical check
        for (int i = 0; i < 6; i++)
            list += board[i][column] + "";
        list = list.trim();

        if (list.equals("XXXX") || list.equals("OOOO"))
            flag++;

        if (list.length() > 4 && flag == 0) {
            for (int i = 4; i < list.length(); i++) {
                if (list.substring(i - 4, i).equals("XXXX") || list.substring(i - 4, i).equals("OOOO")) {
                    flag++;
                    break;
                }
            }
        }

        //Horizontal check

        if (flag == 0) {
            list = "";

            for (int i = 0; i < 7; i++)
                list += board[row][i] + "";

            if (list.equals("XXXX") || list.equals("OOOO"))
                flag++;

            if (list.length() > 4 && flag == 0) {
                for (int i = 4; i < list.length() + 1; i++) {
                    if (list.substring(i - 4, i).equals("XXXX") || list.substring(i - 4, i).equals("OOOO")) {
                        flag++;
                        break;
                    }
                }
            }
        }

        //Left to bottom right diagonal

        if (flag == 0) {
            list = "";
            int x = row;
            int y = column;

            while (x != 5 && y != 6) {
                x++;
                y++;
            }

            while (x != -1 && y != -1) {
                list += board[x][y];
                x--;
                y--;
            }

            if (list.equals("XXXX") || list.equals("OOOO"))
                flag++;

            if (list.length() > 4 && flag == 0) {
                for (int i = 4; i < list.length(); i++) {
                    if (list.substring(i - 4, i).equals("XXXX") || list.substring(i - 4, i).equals("OOOO")) {
                        flag++;
                        break;
                    }
                }
            }
        }

        //Right diagonal

        if (flag == 0) {
            list = "";
            int x = row;
            int y = column;

            while (x != 5 && y != 0) {
                x++;
                y--;
            }

            while (x != -1 && y != 7) {
                list += board[x][y];
                x--;
                y++;
            }

            if (list.equals("XXXX") || list.equals("OOOO"))
                flag++;

            if (list.length() > 4 && flag == 0) {
                for (int i = 4; i < list.length(); i++) {
                    if (list.substring(i - 4, i).equals("XXXX") || list.substring(i - 4, i).equals("OOOO")) {
                        flag++;
                        break;
                    }
                }
            }
        }

        if (flag == 1)
            return board[row][column];

        else
            return ' ';
    }

    public void printScreen() {
        System.out.println("    0   1   2   3   4   5   6 ");
        System.out.println("  ------------------------------");
        for (int i = 0; i < 6; i++) {
            char c = (char) ('A' + i);
            System.out.print(c + " ");
            System.out.print("| ");
            for (int j = 0; j < 7; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("  ------------------------------");
        }
    }

    public void play() {
        printScreen();
        System.out.println("Current player: 'O'");
        System.out.print("Choose a column: ");
        int col = Integer.parseInt(in.nextLine());

        while (col < 0 || col > 6) {
            System.out.println("Error: Invalid number! Select a proper column.");
            col = Integer.parseInt(in.nextLine());
        }

        int row = putPiece(col, 'O');

        char win = ' ';
        char c = 'O';
        int pieces = 1;

        while (win == ' ' && pieces != 42) {
            printScreen();
            if (c == 'X')
                c = 'O';
            else
                c = 'X';

            System.out.println("Current player: " + "'" + c + "'");
            System.out.print("Choose a column: ");
            col = Integer.parseInt(in.nextLine());
            System.out.println();

            while (col < 0 || col > 6) {
                System.out.println("Error: Invalid number! Select a proper column.");
                col = Integer.parseInt(in.nextLine());
            }

            row = putPiece(col, c);
            pieces++;
            win = checkAlignment(row, col);
            if (win == ' ' && pieces == 42) {
                printScreen();
                System.out.println("!!! Draw !!!");
                break;
            }
        }

        if (win == 'X') {
            printScreen();
            System.out.println("!!! Winner is Player 'X' !!!");
        } else if (win == 'O') {
            printScreen();
            System.out.println("!!! Winner is Player 'O' !!!");
        }

    }
}
//011220021033110133023324244556654655446665