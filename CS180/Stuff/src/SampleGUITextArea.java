import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;

/**
 * SampleGUITextArea.java
 * An example class that demonstrates the use of a JTextArea and
 * JScrollBar classes.
 *
 * @author Sunil Prabhakar
 *         (sunil@cs.purdue.edu)
 *         October 2009
 */

public class SampleGUITextArea extends JFrame implements ActionListener {
    JButton okButton, doneButton, clearButton;
    JTextArea output;
    JLabel label;


    /**
     * Default constructor
     */
    public SampleGUITextArea() {
        this.setTitle("Sample Text Area GUI");
        // get container pane and set layout
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());

        //create panel for TextArea and scroll bars
        JPanel textPanel = new JPanel(new FlowLayout());
        textPanel.setBorder(BorderFactory.createTitledBorder("Text Area"));
        output = new JTextArea(20, 30);
        JScrollPane scrollPane = new JScrollPane(output);
        textPanel.add(scrollPane);

        contentPane.add(textPanel, BorderLayout.NORTH);

        JPanel controlPanel = new JPanel(new FlowLayout());
        controlPanel.setBorder(BorderFactory.createTitledBorder("Control Pane"));
        doneButton = addButtonToPane("Done", controlPanel);
        clearButton = addButtonToPane("Clear", controlPanel);
        contentPane.add(controlPanel, BorderLayout.SOUTH);
    }


    /**
     * Helper method to add a new button to an existing pane
     *
     * @param text the text for the new button
     * @param pane the pane to which to add the button
     * @return the newly created button
     */
    public JButton addButtonToPane(String text, Container pane) {
        JButton button = new JButton(text);
        pane.add(button);
        button.addActionListener(this);
        return button;
    }

    /**
     * ActionListener inteface method
     */
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button == clearButton) {
            output.setText("");
        } else if (button == doneButton) {
            System.exit(0);
        }
    }


    public static void main(String[] args) {
        SampleGUITextArea window = new SampleGUITextArea();
        window.pack();
        window.setVisible(true);
    }
}
