/**
 * Created by Samrat on 10/27/16.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class finalLogin extends JFrame{

    private JButton login, register;
    private JLabel log, reg;
    private JTextField log1, log2;

    public finalLogin() {
        this.setTitle("FoilMaker");
        this.setSize(200,100);

        JPanel p1 = new JPanel(new BorderLayout(6,6));
        JPanel p = new JPanel();
        p.setBorder(BorderFactory.createTitledBorder("FoilMaker!"));
        p1.add(p, BorderLayout.SOUTH);
        login = new JButton("Login");
        login.setBounds(180, 80, 80, 25);
        register = new JButton("Register");
        register.setBounds(10, 80, 80, 25);
        log = new JLabel("Username");
        log.setBounds(10, 10, 80, 25);
        reg = new JLabel("Password");
        reg.setBounds(10, 40, 80, 25);
        log1 = new JTextField();
        log1.setBounds(100, 10, 160, 25);
        log2 = new JTextField();
        log2.setBounds(100, 40, 160, 25 );


        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());

        c.add(log);
        c.add(reg);
        c.add(log1, BorderLayout.SOUTH);
        c.add(log2, BorderLayout.SOUTH);
        c.add(login, BorderLayout.SOUTH);
        c.add(register, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        finalLogin login = new finalLogin();
        login.pack();
        login.setVisible(true);
        login.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

