//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//
///**
// * GridLayoutExample.java
// * Sample class to show the GridLayout manager that extends JFrame
// *
// * @author Sunil Prabhakar
// *         (sunil@cs.purdue.edu)
// *         October 2009
// */
//public class GridLayoutExample extends JFrame implements ActionListener {
//
//    private JButton[] buttons;
//    /**
//     * array of buttons
//     */
//    final int NUM_BUTTONS = 6; /** number of buttons */
//
//    /**
//     * Default constructor
//     */
//    public GridLayoutExample() {
//        this.setTitle("Flow Layout");
//        addElements();
//    }
//
//    /**
//     * Method to add buttons to frame
//     */
//    private void addElements() {
//        Container contentPane = this.getContentPane();
//        contentPane.setLayout(new GridLayout(2, 0));
//        buttons = new JButton[NUM_BUTTONS];
//
//        for (int i = 0; i < NUM_BUTTONS; i++) {
//            buttons[i] = new JButton("Button" + i);
//            contentPane.add(buttons[i]);
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
//        GridLayoutExample window = new GridLayoutExample();
//        window.pack();
//        window.setVisible(true);
//    }
//
//}
