import javax.swing.*;
import java.awt.*;

/**
 * Created by Samrat on 11/2/16.
 */
public class keyGUI2 extends JFrame{
    public void key() {
        JFrame frame = new JFrame();
        frame.setTitle("FoilMaker");
        frame.setSize(350,500);

        JPanel panel = new JPanel();

        panel.setBorder(BorderFactory.createTitledBorder("Others should use this key to join your game"));

        JPanel panel1 = new JPanel();
        JTextArea area1 = new JTextArea(1,5);
        panel.add(area1);

        panel1.setBorder(BorderFactory.createTitledBorder("Participants"));
        JPanel panel2 = new JPanel();
        JTextArea area2 = new JTextArea(12,30);
        panel1.add(area2);

        JButton nextRound = new JButton("Start Game");
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
        keyGUI2 k = new keyGUI2();
        k.key();
    }

}
