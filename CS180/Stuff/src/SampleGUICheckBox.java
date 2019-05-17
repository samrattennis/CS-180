import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.*;
import java.awt.event.*;

/**
 * SampleGUICheckBox.java
 * An example class that uses JCheckBox buttons.
 *
 * @author Sunil Prabhakar
 *         (sunil@cs.purdue.edu)
 *         October 2009
 */

public class SampleGUICheckBox extends JFrame implements ActionListener {

    static final String[] PETS = {"Dogs", "Cats", "Snakes", "Crabs"};

    private JButton showButton, selectAllButton, deselectAllButton;
    private JCheckBox[] pets;
    private boolean havePet[];
    private JTextField output;

    /**
     * Default constructor
     */
    public SampleGUICheckBox() {
        this.setTitle("Sample JCheckBox GUI");
        //get content pane and set layout manager
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new GridLayout(0, 1));

        // create and add checkbox panel
        contentPane.add(createCheckBoxPanel());

        //creat and add an output field
        output = new JTextField(20);
        output.setEditable(false);
        JPanel tempPanel = new JPanel(new FlowLayout());
        tempPanel.add(output);
        contentPane.add(tempPanel);

        //add a button to show the status of the buttons
        showButton = new JButton("Show");
        showButton.addActionListener(this);
        tempPanel = new JPanel(new FlowLayout());
        tempPanel.add(showButton);
        contentPane.add(tempPanel);
    }

    /**
     * Method to create the checkbox panel
     *
     * @return the newly created panel
     */
    public JPanel createCheckBoxPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 0));
        panel.setBorder(BorderFactory.createTitledBorder("Pets"));
        JPanel topPanel = new JPanel(new FlowLayout());
        pets = new JCheckBox[PETS.length];
        havePet = new boolean[PETS.length];
        for (int i = 0; i < PETS.length; i++) {
            pets[i] = new JCheckBox();
            pets[i].addActionListener(this);
            pets[i].setSelected(havePet[i]);
            topPanel.add(pets[i]);
            topPanel.add(new JLabel(PETS[i]));
        }
        panel.add(topPanel);
        JPanel bottomPanel = new JPanel();
        selectAllButton = addButtonToPane("Select All", bottomPanel);
        deselectAllButton = addButtonToPane("Clear All", bottomPanel);
        panel.add(bottomPanel);
        return panel;
    }


    public JButton addButtonToPane(String text, Container pane) {
        JButton button = new JButton(text);
        pane.add(button);
        button.addActionListener(this);
        return button;
    }

    /**
     * The ActionListener interface method to handle event
     *
     * @param e the action event object
     */
    public void actionPerformed(ActionEvent e) {
        String msg;
        Object source = e.getSource();
        //Handle checkbox events
        if (source instanceof JCheckBox) {
            JCheckBox checked = (JCheckBox) source;
            for (int i = 0; i < PETS.length; i++)
                if (checked == pets[i]) {
                    havePet[i] = pets[i].isSelected();
                    showMessage("Toggled " + PETS[i] + " to " + havePet[i]);
                    return;
                }
        }
        //handle button events
        JButton button = (JButton) e.getSource();
        if (button == showButton) {
            for (int i = 0; i < PETS.length; i++)
                havePet[i] = pets[i].isSelected();
            msg = "";
            for (int i = 0; i < PETS.length; i++)
                if (havePet[i])
                    msg = msg + PETS[i] + ", ";
            if (msg.length() > 0)
                showMessage("Have pets: " + msg);
            else
                showMessage("Have no pets");
        }
    }

    public void showMessage(String msg) {
        output.setText(msg);
    }

    public static void main(String[] args) {
        SampleGUICheckBox window = new SampleGUICheckBox();
        window.pack();
        window.setVisible(true);
    }
}
