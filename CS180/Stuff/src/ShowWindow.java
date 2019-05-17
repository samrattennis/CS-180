import javax.swing.*;

/**
 * ShowWindow -- demonstrates a basic window being displayed.
 *
 * @author Sunil Prabhakar
 */

class ShowWindow {
    public static void main(String[] args) {
        JFrame myWindow;

        myWindow = new JFrame();
        myWindow.setSize(300, 400);
        myWindow.setTitle("My Window");
        myWindow.setResizable(true);
        myWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        myWindow.setVisible(true);
    }
}