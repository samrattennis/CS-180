import javax.swing.*;

/**
 * Created by Samrat on 11/2/16.
 */
public class messageGUI extends JFrame {
    public void message() {
        JFrame frame = new JFrame();
        frame.setTitle("FoilMaker");
        frame.setSize(350,500);

        JPanel panel = new JPanel();

        panel.setBorder(BorderFactory.createTitledBorder(""));

        JPanel panel1 = new JPanel();

        panel1.setBorder(BorderFactory.createTitledBorder("Waiting for leader ..."));

        JPanel panel3 = new JPanel();

        panel3.setLayout(new BoxLayout(panel3, BoxLayout.PAGE_AXIS));
        panel3.add(panel1);

        frame.add(panel3);

        frame.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        messageGUI m = new messageGUI();
        m.message();
    }

}
