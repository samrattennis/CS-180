import javax.swing.*;
import java.awt.*;

/**
 * LoginWindow.java
 * A simple class to shows the use  of a subclass of JFrame to create windows
 *
 * @author Sunil Prabhakar
 *         (sunil@cs.purdue.edu)
 *         October 2009
 */
public class LoginWindow extends JFrame {
    private JButton loginButton;
    /**
     * Login button
     */
    private JButton cancelButton;
    /**
     * Cancel button
     */
    private JTextField nameInput; /** Input field for user name */

    /**
     * Constructor
     *
     * @param title the title for this window
     */
    public LoginWindow(String title) {
        this.setTitle(title);
        this.setSize(800, 100);
        // create buttons and textfield objects
        loginButton = new JButton("Login");
        cancelButton = new JButton("Cancel");
        JLabel label = new JLabel("Name");
        nameInput = new JTextField("<Enter name>");

        //get container and set layout to be used
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout());

        //add components
        contentPane.add(label);
        contentPane.add(nameInput);
        contentPane.add(loginButton);
        contentPane.add(cancelButton);

        //display GUI
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        LoginWindow myWindow = new LoginWindow("test");

    }
}