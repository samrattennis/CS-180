import javax.swing.*;
public class WordFixGUI2 {
    public static void main(String[] args) {
        String word = JOptionPane.showInputDialog(null, "Enter the word to be deciphered");
        int asterisk = word.indexOf("*");
        String last = word.substring(0,1);
        String first = word.substring(word.length() - 1, word.length());
        String part1 = word.substring(asterisk + 1, word.length() - 1);
        String part2 = word.substring(1, asterisk);
        JOptionPane.showMessageDialog(null, first + part1 + part2 + last);
    }
}
