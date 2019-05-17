import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Samrat on 10/28/16.
 */
public class logi extends JFrame {
    private JTextField textField1;
    private JButton button1;
    private JButton registerButton;
    private JPanel yo;
    private JPasswordField passwordField1;

    public logi() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, "Hello World!");
            }
        });
    }

    public static void main(String[] args) {
        JFrame jframe = new JFrame("Foilermaker");
        jframe.setContentPane(new logi().yo);
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
