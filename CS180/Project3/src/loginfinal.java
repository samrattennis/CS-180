import javax.swing.*;
import java.awt.*;


/**
 * Created by Samrat on 11/9/16.
 */
public class loginfinal extends JFrame {


    JLabel titleLabel;
    JLabel usernameLabel;
    JLabel passwordLabel;
    JTextField user;
    JPasswordField pass;
    Button login;
    Button register;

    public loginfinal() {
        super("FoilMaker");
        setLayout(new FlowLayout());
        setSize(390,590);

        setLocation(getHeight()/2,getWidth()/2);

        JPanel title = new JPanel();
        JPanel first = new JPanel(new GridBagLayout());
        JPanel second = new JPanel(new GridBagLayout());
        JPanel panel = new JPanel();

        titleLabel = new JLabel("FoilMaker!");
        usernameLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");
        user = new JTextField(15);
        pass = new JPasswordField(15);
        login = new Button("Login");
        register = new Button("Register");


        GridBagConstraints bag = new GridBagConstraints();
        bag.insets = new Insets(0, 15, 200, 60);
        title.add(titleLabel, bag);

        bag.insets = new Insets(150, 15, 15, 60);
        bag.gridx = 0;
        bag.gridy = 15;
        first.add(usernameLabel, bag);


        bag.insets = new Insets(150, 15, 15, 60);
        bag.gridx = 1;
        bag.gridy = 15;
        first.add(user,bag);


        bag.insets = new Insets(7, 15, 15, 60);
        bag.gridx = 0;
        bag.gridy = 16;
        first.add(passwordLabel, bag);


        bag.gridx = 1;
        bag.gridy = 16;
        first.add(pass, bag);

        bag.insets = new Insets(100, 60, 15, 60);
        bag.gridx = 20;
        bag.gridy = 100;
        second.add(login, bag);


        bag.gridx = 30;
        bag.gridy = 100;
        second.add(register, bag);

        add(title, BorderLayout.NORTH);
        add(first, BorderLayout.CENTER);
        add(second, BorderLayout.SOUTH);
    }



    public static void main(String[] args) {
        FirstWindow first = new FirstWindow();
        first.setVisible(true);
        first.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    }

