//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//
///**
// * BorderLayoutExample.java
// * Sample class to show the BorderLayout manager that extends JFrame
// *
// * @author Sunil Prabhakar
// *         (sunil@cs.purdue.edu)
// *         October 2009
// */
//public class BorderLayoutExample extends JFrame implements ActionListener {
//
//    /**
//     * Array of buttons
//     */
//    private JButton[] buttons;
//    /**
//     * Total number of buttons
//     */
//    private final int NUM_BUTTONS = 6;
//
//    /**
//     * Default constructor
//     */
//    public BorderLayoutExample() {
//        this.setTitle("Border Layout");
//        addElements();
//    }
//
//    /**
//     * Method to add buttons to the frame
//     */
//    private void addElements() {
//        Container contentPane = this.getContentPane();
//        contentPane.setLayout(new BorderLayout());
//        buttons = new JButton[NUM_BUTTONS];
//
//        for (int i = 0; i < NUM_BUTTONS; i++) {
//            buttons[i] = new JButton("Button" + i);
//            buttons[i].addActionListener(this);
//        }
//        contentPane.add(buttons[2], BorderLayout.EAST);
//        contentPane.add(buttons[3], BorderLayout.WEST);
//        contentPane.add(buttons[0], BorderLayout.NORTH);
//        contentPane.add(buttons[1], BorderLayout.SOUTH);
//        contentPane.add(buttons[4], BorderLayout.CENTER);
//        contentPane.add(buttons[5], BorderLayout.CENTER);
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
//    /**
//     * Main  method
//     *
//     * @param args runtime arguments
//     */
//    public static void main(String[] args) {
//        BorderLayoutExample window = new BorderLayoutExample();
//        window.pack();
//        window.setVisible(true);
//    }
//
//}
