import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.*;
import java.awt.event.*;

/**
 * SampleGUIButtons.java
 * An example class that use a variety of buttons including
 * JButton, JRadioButton, JCheckBox, JComboBox, JTextArea, and JScrollPane.
 * The TextArea component displays the status of the various other
 * Buttons when the "OK" button is clicked or when a menu item is clicked.
 * The "Done" button ends the application.
 * The "Clear" button clears the text display.
 *
 * @author Sunil Prabhakar
 *         (sunil@cs.purdue.edu)
 *         October 2009
 */
public class SampleGUIButtons extends JFrame implements ActionListener {

    private static final String[] PETS = {"Dogs", "Cats", "Snakes", "Crabs"};
    private static final String[] COLORS = {"Red", "Green", "Blue", "Purple"};
    private static final String[] STATES = {"Indiana", "Illinois", "Ohio", "Michingan"};
    private JButton okButton, doneButton, selectAllButton, deselectAllButton, clearButton;
    private JCheckBox[] pets;
    private JRadioButton[] colors;
    private boolean havePet[];
    private String favoriteColor;
    private JTextArea output;
    private JScrollPane scrollPane;
    private JLabel label;
    private JComboBox dropDownList;

    /**
     * Default constructor
     */
    public SampleGUIButtons() {
        this.setTitle("Sample GUI");
        addElements();
    }

    /**
     * Method to add the various elements to the window
     */
    private void addElements() {
        JPanel tempPanel, tempPanel2;
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new FlowLayout());

        tempPanel = createButtonPanel();
        tempPanel2 = new JPanel(new BorderLayout());
        okButton = new JButton("OK");
        okButton.addActionListener(this);
        tempPanel2.add(tempPanel, BorderLayout.NORTH);
        tempPanel2.add(okButton, BorderLayout.SOUTH);

        panel.add(tempPanel2);


        //panel.add(createTextPanel());
        contentPane.add(panel, BorderLayout.NORTH);

        JPanel controlPanel = new JPanel(new FlowLayout());
        doneButton = addButtonToPane("Done", controlPanel);
        clearButton = addButtonToPane("Clear", controlPanel);
        contentPane.add(controlPanel, BorderLayout.SOUTH);
    }

    /**
     * Method to create the buttons panel
     *
     * @return the newly created panel
     */
    public JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new GridLayout(0, 1));
        buttonPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        JPanel checkBoxPanel = createCheckBoxPanel();
        buttonPanel.add(checkBoxPanel);
        JPanel radioButtonPanel = createRadioButtonPanel();
        buttonPanel.add(radioButtonPanel);
        JPanel comboBoxPanel = createComboBoxPanel();
        buttonPanel.add(comboBoxPanel);

        return buttonPanel;
    }

    /**
     * Method to create the combo box panel
     *
     * @return the newly created panel
     */
    private JPanel createComboBoxPanel() {
        JPanel tempPanel = new JPanel(new FlowLayout());
        tempPanel.setBorder(BorderFactory.createTitledBorder("State"));
        dropDownList = new JComboBox(STATES);
        dropDownList.addActionListener(this);
        tempPanel.add(dropDownList);
        return tempPanel;
    }

    /**
     * Method to create the check box panel
     *
     * @return the newly create panel
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

    /**
     * Method to create the radio button panel
     *
     * @return the newly created panel
     */
    public JPanel createRadioButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Favorite Color"));
        colors = new JRadioButton[COLORS.length];
        ButtonGroup group = new ButtonGroup();
        for (int i = 0; i < COLORS.length; i++) {
            colors[i] = new JRadioButton(COLORS[i]);
            group.add(colors[i]);
            panel.add(colors[i]);
        }
        return panel;
    }

    /**
     * Helper method to add a new button to a pane
     *
     * @param text the text for the button
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
     * The ActionListener interface method
     */

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button == clearButton) {
            output.setText("");
        } else if (button == doneButton) {
            System.exit(0);
        } else if (button == selectAllButton) {
            for (int i = 0; i < PETS.length; i++)
                pets[i].setSelected(true);
        } else if (button == deselectAllButton) {
            for (int i = 0; i < PETS.length; i++)
                pets[i].setSelected(false);
        } else if (button == okButton) {
            for (int i = 0; i < PETS.length; i++)
                havePet[i] = pets[i].isSelected();
            for (int i = 0; i < COLORS.length; i++)
                if (colors[i].isSelected())
                    favoriteColor = COLORS[i];
            showMessage("Have pets: ");
            for (int i = 0; i < PETS.length; i++)
                if (havePet[i])
                    output.append(PETS[i] + ", ");
            showMessage("\nFavorite color: " + favoriteColor + "\n");
            showMessage("Live in: " + STATES[dropDownList.getSelectedIndex()] + "\n");
        }
    }


    public void showMessage(String msg) {
        output.append(msg);
    }

    /**
     * Method to create the text output panel
     *
     * @return the newly created panel
     */
//    public JPanel createTextPanel() {
//        JPanel panel = new JPanel();
//        panel.setLayout(new GridLayout(0, 1));
//        panel.setBorder(BorderFactory.createTitledBorder("Text"));
//        output = new JTextArea(20, 30);
//        scrollPane = new JScrollPane(output);
//        panel.add(scrollPane);
//        return panel;
//    }

    public static void main(String[] args) {
        SampleGUIButtons window = new SampleGUIButtons();
        window.pack();
        window.setVisible(true);
    }
}