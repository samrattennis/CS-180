import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Samrat on 10/27/16.
 */
public class Login extends JFrame{

    JTextField textField;
    JLabel label;
    JFrame j;

    public Login() {
        j = new JFrame("FoilMaker");
        j.setSize(500,200);
        j.setLocation(100,300);

        j.setLayout(null);
        j.setDefaultCloseOperation(j.EXIT_ON_CLOSE);

        label = new JLabel("Username");
        label.setLocation(10, 10);
        label.setSize(label.getPreferredSize());
        j.add(label);

        textField = new JTextField();
        textField.setColumns(15);
        textField.setSize(textField.getPreferredSize());

        textField.setLocation(150, 10);
        textField.setToolTipText("Username");
        j.add(textField);

        label = new JLabel("Password");
        label.setLocation(10, 40);
        label.setSize(label.getPreferredSize());
        j.add(label);
        j.setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }


}
