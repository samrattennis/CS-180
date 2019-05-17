import javax.swing.*;
import java.awt.*;

/**
 * MyWindow.java
 * A simple class to shows the use  of a subclass of JFrame to create a window.
 *
 * @author Sunil Prabhakar
 *         (sunil@cs.purdue.edu)
 */

public class MyWindow extends JFrame {

    /**
     * Constructor
     *
     * @param title the title of the window
     */
    public MyWindow(String title) {
        setSize(300, 400);
        setTitle(title);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        Container cPane = this.getContentPane();
        cPane.setBackground(Color.YELLOW);

        JButton loginButton = new JButton("Login");
        cPane.setLayout(new FlowLayout());

        cPane.add(loginButton);
    }
}