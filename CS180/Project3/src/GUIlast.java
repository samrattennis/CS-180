import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Created by Samrat on 11/1/16.
 */
public class GUIlast extends JFrame{
    public void GUI() {
        JFrame frame = new JFrame();
        frame.setTitle("FoilMaker");
        frame.setSize(350,500);

        JPanel panel = new JPanel();

        panel.setBorder(new TitledBorder("Round Result"));

        JPanel panel1 = new JPanel();
        JTextArea area1 = new JTextArea(50,50);
        panel.add(area1);

        panel1.setBorder(new TitledBorder("Overall Results"));
        JPanel panel2 = new JPanel();
        JTextArea area2 = new JTextArea(50,50);
        panel1.add(area2);

        JButton nextRound = new JButton("Next Round");
        panel2.add(nextRound);

        JPanel panel3 = new JPanel();

        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        panel3.add(panel);
        panel3.add(panel1);
        panel3.add(panel2, BorderLayout.SOUTH);

        frame.add(panel3);

        frame.setVisible(true);


    }

    public static void main(String[] args) {
        GUIlast g = new GUIlast();
        g.GUI();
        g.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
