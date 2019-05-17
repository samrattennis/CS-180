//import javax.swing.*;
//import javax.swing.border.BevelBorder;
//
//import java.awt.*;
//import java.awt.event.*;
//
///**
// * SampleGUIComboBox.java
// * An example class that uses a JComboBox.
// *
// * @author Sunil Prabhakar
// *         (sunil@cs.purdue.edu)
// *         October 2009
// */
//public class SampleGUIComboBox extends JFrame implements ActionListener {
//
//    static final String[] STATES = {"Indiana", "Illinois", "Ohio", "Michingan"};
//
//    JButton showButton, selectAllButton, deselectAllButton;
//    JComboBox dropDownList;
//    JTextField output;
//
//
//    public SampleGUIComboBox() {
//        this.setTitle("Sample JComboBox GUI");
//        Container contentPane = this.getContentPane();
//        contentPane.setLayout(new GridLayout(0, 1));
//
//        contentPane.add(createComboBoxPanel());
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
//    private JPanel createComboBoxPanel() {
//        JPanel tempPanel = new JPanel(new FlowLayout());
//        tempPanel.setBorder(BorderFactory.createTitledBorder("State"));
//        dropDownList = new JComboBox(STATES);
//        dropDownList.addActionListener(this);
//        tempPanel.add(dropDownList);
//        return tempPanel;
//    }
//
//
//    public JButton addButtonToPane(String text, Container pane) {
//        JButton button = new JButton(text);
//        pane.add(button);
//        button.addActionListener(this);
//        return button;
//    }
//
//    public void actionPerformed(ActionEvent e) {
//        String msg;
//        Object source = e.getSource();
//        if (source instanceof JComboBox) {
//            JComboBox checked = (JComboBox) source;
//            showMessage("State chosen: " + STATES[dropDownList.getSelectedIndex()]);
//            return;
//        }
//        JButton button = (JButton) e.getSource();
//        if (button == showButton) {
//            showMessage("State chosen: " + STATES[dropDownList.getSelectedIndex()]);
//        }
//    }
//
//    public void showMessage(String msg) {
//        output.setText(msg);
//    }
//
//    public static void main(String[] args) {
//        SampleGUIComboBox window = new SampleGUIComboBox();
//        window.pack();
//        window.setVisible(true);
//    }
//}