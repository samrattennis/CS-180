import javax.swing.*;
import java.awt.*;
/**
 * Created by Samrat on 11/1/16.
 */
public class guiSuggestion extends JFrame {

        public void guiSuggestion() {
            JFrame frame = new JFrame();
            frame.setTitle("FoilMaker");
            frame.setSize(350,500);

            JPanel panel = new JPanel();

            panel.setBorder(BorderFactory.createTitledBorder("What is the word for"));

            JPanel panel1 = new JPanel();
            JTextArea area1 = new JTextArea(10,25);
            panel.add(area1);

            panel1.setBorder(BorderFactory.createTitledBorder("Your Suggestion"));
            JPanel panel2 = new JPanel();
            JTextArea area2 = new JTextArea(1,25);
            panel1.add(area2);

            JButton nextRound = new JButton("Submit Suggestion");
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
            guiSuggestion g = new guiSuggestion();
            g.guiSuggestion();
            g.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
    }


