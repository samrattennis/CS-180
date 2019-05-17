//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//
///**
// * FlowLayoutExample.java
// * Sample class to show the FowLayout manager that extends JFrame
// *
// * @author Sunil Prabhakar
// *         (sunil@cs.purdue.edu)
// *         October 2009
// */
//public class FlowLayoutExample extends JFrame implements ActionListener {
//
//    private JButton[] buttons;
//    /**
//     * array of button
//     */
//    private final int NUM_BUTTONS = 6; /** number of buttons */
//
//    /**
//     * Constructor
//     */
//    public FlowLayoutExample() {
//        this.setTitle("Flow Layout");
//        addElements();
//    }
//
//    /**
//     * Method to add buttons to pane.
//     */
//    private void addElements() {
//        String[] buttonNames = {"login", "canvrl"};
//        Container contentPane = this.getContentPane();
//        contentPane.setLayout(new FlowLayout());
//        //contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 50));
//        buttons = new JButton[NUM_BUTTONS];
//
//        for (int i = 0; i < NUM_BUTTONS; i++) {
//            buttons[i] = new JButton("Button" + i);
//            contentPane.add(buttons[i]);
//
//            buttons[i].addActionListener(this);
//        }
//    }
//
//    /**
//     * actionPerformed method simply displays which button was pressed
//     *
//     * @param e the actionEvent object.
//     */
//    public void actionPerformed(ActionEvent e) {
//        JButton b = (JButton) e.getSource();
//        System.out.println(b.getText() + " pressed");
//    }
//
//
//    /**
//     * Main method
//     *
//     * @param args command line arguments
//     */
//    public static void main(String[] args) {
//        FlowLayoutExample window = new FlowLayoutExample();
//        window.pack();
//        window.setVisible(true);
//    }
//
//}
