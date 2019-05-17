import java.awt.*;
import javax.swing.*;

public class loginMain extends JFrame{


    public loginMain() {
        super("FoilMaker");
        setLayout(new FlowLayout());
        setSize(390,590);

        setLocation(getHeight()/2,getWidth()/2);
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel(new GridBagLayout());
        JPanel panel2 = new JPanel(new GridBagLayout());

        JLabel foilmaker = new JLabel("FoilMaker!");

        JLabel userName = new JLabel("Username");

        JLabel password = new JLabel("Password");

        JTextField text = new JTextField(14);

        JPasswordField passwordField = new JPasswordField(14);

        JButton loginButton = new JButton("Login");

        JButton registerButton = new JButton("Register");


        GridBagConstraints bag = new GridBagConstraints();
        bag.insets = new Insets(0, 15, 200, 60);
        panel.add(foilmaker, bag);

        bag.insets = new Insets(145, 13, 13, 59);
        bag.gridx = 0;
        bag.gridy = 13;
        panel1.add(userName, bag);

        bag.insets = new Insets(145, 13, 13, 59);
        bag.gridx = 1;
        bag.gridy = 13;
        panel1.add(text, bag);

        bag.insets = new Insets(7, 15, 15, 60);
        bag.gridx = 0;
        bag.gridy = 17;
        panel1.add(password, bag);

        bag.gridx = 1;
        bag.gridy = 17;
        panel1.add(passwordField, bag);

        bag.insets = new Insets(100, 1, 300, 5);
        bag.gridx = 17;
        bag.gridy = 98;
        panel2.add(loginButton, bag);

        bag.gridx = 27;
        bag.gridy = 98;
        panel2.add(registerButton, bag);

        add(panel, BorderLayout.NORTH);
        add(panel1, BorderLayout.CENTER);
        add(panel2, BorderLayout.SOUTH);
    }



    public static void main(String[] args) {
        FirstWindow first = new FirstWindow();
        first.setVisible(true);
        first.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
