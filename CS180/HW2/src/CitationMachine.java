import javax.swing.*;
public class CitationMachine {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Enter book details to generate APA format citation.");

        String authorName = JOptionPane.showInputDialog(null, "Author Name:" );

        String publication = JOptionPane.showInputDialog(null, "Year of Publication:");

        String title = JOptionPane.showInputDialog(null, "Title of work:");

        String publisher = JOptionPane.showInputDialog(null, "Publisher:");

        String location = JOptionPane.showInputDialog(null, "Location:");

        JOptionPane.showMessageDialog(null, authorName.substring(authorName.indexOf(" ") + 1)+ ", " + authorName.substring(0,1) + ". " + "(" + publication + "). " + title + ". " + location + ": " + publisher + ".");
    }
}
