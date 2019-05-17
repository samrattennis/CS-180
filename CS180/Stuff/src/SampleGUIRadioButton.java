//import javax.swing.*;
//import javax.swing.border.BevelBorder;
//
//import java.awt.*;
//import java.awt.event.*;
//
///**
// * SampleGUIRadioButton.java
// * An example class that demonstrates the use of radio buttons.
// *
// * @author Sunil Prabhakar
// *         (sunil@cs.purdue.edu)
// *         October 2009
// */
//public class SampleGUIRadioButton extends JFrame implements ActionListener {
//
//    static final String[] COLORS = {"Red", "Green", "Blue", "Purple"};
//
//    JButton showButton, selectAllButton, deselectAllButton;
//    JRadioButton[] colors;
//    int favoriteColor = -1;
//    JTextField output;
//
//    /**
//     * Default constructor
//     */
//    public SampleGUIRadioButton() {
//        this.setTitle("Sample JRadioButton GUI");
//        Container contentPane = this.getContentPane();
//        contentPane.setLayout(new GridLayout(0, 1));
//
//        contentPane.add(createRadioButtonPanel());
//
//        output = new JTextField(20);
//        output.setEditable(false);
//        JPanel tempPanel = new JPanel(new FlowLayout());
//        tempPanel.add(output);
//        contentPane.add(tempPanel);
//
//        showButton = new JButton("Show");
//        showButton.addActionListener(this);
//        tempPanel = new JPanel(new FlowLayout());
//        tempPanel.add(showButton);
//        contentPane.add(tempPanel);
//    }
//
//    /**
//     * Method to create the panel with radio buttons
//     *
//     * @return the newly created panel
//     */
//    private JPanel createRadioButtonPanel() {
//        JPanel panel = new JPanel(new FlowLayout());
//        panel.setBorder(BorderFactory.createTitledBorder("Favorite Color"));
//        colors = new JRadioButton[COLORS.length];
//        ButtonGroup group = new ButtonGroup();
//        for (int i = 0; i < COLORS.length; i++) {
//            colors[i] = new JRadioButton(COLORS[i]);
//            colors[i].addActionListener(this);
//            group.add(colors[i]);
//            panel.add(colors[i]);
//        }
//        return panel;
//    }
//
//    /**
//     * Helper method to add a new button to an existing pane
//     *
//     * @return the newly created button
//     * @arg text the text for the new button
//     * @arg pane the pane to which to add the button
//     */
//    private JButton addButtonToPane(String text, Container pane) {
//        JButton button = new JButton(text);
//        pane.add(button);
//        button.addActionListener(this);
//        return button;
//    }
//
//    /**
//     * The ActionListener interface method
//     */
//    public void actionPerformed(ActionEvent e) {
//        String msg;
//        Object source = e.getSource();
//        if (source instanceof JRadioButton) {
//            JRadioButton checked = (JRadioButton) source;
//            for (int i = 0; i < COLORS.length; i++)
//                if (checked == colors[i]) {
//                    favoriteColor = i;
//                    showMessage("Favorite color switched to: " + COLORS[i]);
//                    return;
//                }
//        }
//        JButton button = (JButton) e.getSource();
//        if (button == showButton) {
//            for (int i = 0; i < COLORS.length; i++)
//                if (colors[i].isSelected())
//                    favoriteColor = i;
//            if (favoriteColor < 0)
//                showMessage("No favorite color");
//            else
//                showMessage("Favorite color: " + COLORS[favoriteColor]);
//        }
//    }
//
//    private void showMessage(String msg) {
//        output.setText(msg);
//    }
//
//    public static void main(String[] args) {
//        SampleGUIRadioButton window = new SampleGUIRadioButton();
//        window.pack();
//        window.setVisible(true);
//    }
//}