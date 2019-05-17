import javax.swing.*;

public class WordFixGUI {
    public static void main(String[] args) {

        String word = JOptionPane.showInputDialog(null, "Enter the word to be deciphered:");

        int asterisk = word.indexOf('*');
        int length = word.length();

        String last  = word.substring(0, 1);
        String first = word.substring(length - 1, length);
        String part1 = word.substring(asterisk + 1, length-1);
        String part2 = word.substring(1, asterisk);

        JOptionPane.showMessageDialog(null, first + part1 + part2 + last);



    }
}
