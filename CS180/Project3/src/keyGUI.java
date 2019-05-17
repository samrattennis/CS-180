import javax.swing.*;
import java.awt.*;

/**
 * Created by Samrat on 11/2/16.
 */
public class keyGUI extends JFrame{
    public void key1() {
        JFrame frame = new JFrame();
        frame.setTitle("FoilMaker");
        frame.setSize(350,500);

        JPanel panel = new JPanel();

        panel.setBorder(BorderFactory.createTitledBorder(""));

        JPanel panel1 = new JPanel();
        JTextArea area1 = new JTextArea(0,0);
        panel.add(area1);

        panel1.setBorder(BorderFactory.createTitledBorder("Enter the game key to join the game"));
        JPanel panel2 = new JPanel();
        JTextArea area2 = new JTextArea(1,3);
        panel1.add(area2);

        JButton nextRound = new JButton("Join Game");
        panel2.add(nextRound);

        JPanel panel3 = new JPanel();

        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        panel3.add(panel, BorderLayout.CENTER);
        panel3.add(panel1);
        panel3.add(panel2, BorderLayout.SOUTH);

        frame.add(panel3);

        frame.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        keyGUI k = new keyGUI();
        k.key1();
    }

}
