import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;
/**
 * Created by Samrat on 10/27/16.
 */
public class newgame extends JFrame{

    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(300,300);
        jf.setTitle("FoilMaker");
        JPanel jp = new JPanel();

        JPanel jp1 = new JPanel();
        JButton start = new JButton("Start game");
        JButton join = new JButton("Join game");

        jp.add(start, BorderLayout.CENTER);
        jp.add(join, BorderLayout.CENTER);

        jf.add(jp);

        jf.setVisible(true);

        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }



}
