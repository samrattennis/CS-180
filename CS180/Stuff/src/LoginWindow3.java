import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * LoginWindow3.java
 * A simple class to shows the use  of a subclass of JFrame to create windows.
 * A simple action handler is also defined.
 *
 * @author Sunil Prabhakar
 *         (sunil@cs.purdue.edu)
 *         October 2009
 */
public class LoginWindow3 extends JFrame implements ActionListener {
    private JButton loginButton, cancelButton;
    private JTextField nameInput;

    /**
     * Constructor
     *
     * @param title the title for this window
     */
    public LoginWindow3(String title) {
        this.setTitle(title);
        this.setSize(200, 100);
        loginButton = new JButton("Login");
        cancelButton = new JButton("Cancel");
        JLabel label = new JLabel("Name");
        nameInput = new JTextField("<Enter name>");
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(label);
        contentPane.add(nameInput);
        contentPane.add(loginButton);
        contentPane.add(cancelButton);

        loginButton.addActionListener(this);
        cancelButton.addActionListener(this);
        nameInput.addActionListener(this);
        this.pack();
        this.setVisible(true);
    }

    /**
     * The ActionListener interface method actionPerformed
     *
     * @param e the Action Event object
     */
    public void actionPerformed(ActionEvent e) {
        String name;
        Object source = e.getSource();
        if (source instanceof JButton) {
            JButton button = (JButton) source;
            if (source == loginButton) {
                name = nameInput.getText();
                System.out.println(name + " is logging in");
            } else {
                System.out.println("Action cancelled");
                this.setVisible(false);
            }
        } else {
            name = ((JTextField) source).getText();
            System.out.println(name + " is logging in");
        }
    }
}
