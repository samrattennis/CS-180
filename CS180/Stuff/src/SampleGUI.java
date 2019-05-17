import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.*;
import java.awt.event.*;

/**
 * SampleGUI.java
 * An example class that use a variety of Swing GUI elements including
 * JButton, JRadioButton, JCheckBox, JComboBox, JTextArea, JScrollPane,
 * and a variety of menu items including radio button and check items.
 * The TextArea component displays the status of the various other
 * Buttons when the "OK" button is clicked or when a menu item is clicked.
 * The "Done" button ends the application.
 * The "Clear" button clears the text display.
 *
 * @author Sunil Prabhakar
 *         (sunil@cs.purdue.edu)
 */

public class SampleGUI extends JFrame implements ActionListener {

    private static final String[] PETS = {"Dogs", "Cats", "Snakes", "Crabs"};
    private static final String[] COLORS = {"Red", "Green", "Blue", "Purple"};
    private static final String[] STATES = {"Indiana", "Illinois", "Ohio", "Michingan"};

    private JButton okButton, doneButton, selectAllButton, deselectAllButton, clearButton;
    private JCheckBox[] pets;
    private JRadioButton[] colors;
    private boolean havePet[];
    private int favoriteColor;
    private JTextArea output;
    private JScrollPane scrollPane;
    private JLabel label;
    private JComboBox dropDownList;
    private JMenuBar menuBar;
    private JMenu fileMenu, editMenu, submenu, otherMenu;
    private JMenuItem menuItem, openFile, closeFile;
    private JMenuItem copyItem, pasteItem, cutItem;
    private JRadioButtonMenuItem rbMenuItem;
    private JCheckBoxMenuItem autoSaveItem, matchCaseItem;

    /**
     * Default constructor
     */

    public SampleGUI() {
        this.setTitle("Sample GUI");

        // create and attach Menu Bar to Window
//        this.setJMenuBar(createMenuBar());

        //Add GUI elements to the frame
        addElements();
    }

    /**
     * This method add buttons etc. to the main window
     */
    private void addElements() {

        JPanel buttonPanel, topPanel, leftPanel, controlPanel;

        // get content pane and set the layout manager
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());

        topPanel = new JPanel(new GridLayout(1, 0));
        //topPanel.setBorder(BorderFactory.createTitledBorder("topPanel"));

        buttonPanel = createButtonPanel();
        buttonPanel.setBorder(BorderFactory.createTitledBorder("buttonPanel"));
        leftPanel = new JPanel(new BorderLayout());
        //leftPanel.setBorder(BorderFactory.createTitledBorder("leftPanel"));
//        okButton = new JButton("OK");
//        okButton.addActionListener(this);
        leftPanel.add(buttonPanel, BorderLayout.NORTH);
        //leftPanel.add(okButton, BorderLayout.SOUTH);

        topPanel.add(leftPanel);
        topPanel.add(createTextPanel());


        // setup and add the bottom buttons (Done and Clear) to the contentPane
        controlPanel = new JPanel(new FlowLayout());
//        controlPanel.setBorder(BorderFactory.createTitledBorder("controlPanel"));
        doneButton = addButtonToPane("Done", controlPanel);
//        clearButton = addButtonToPane("Clear", controlPanel);

        contentPane.add(topPanel, BorderLayout.NORTH);
        contentPane.add(controlPanel, BorderLayout.SOUTH);
    }

    /**
     * Method to create the button panel
     *
     * @return the newly created button panel
     */
    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new GridLayout(0, 1));
        JPanel radioButtonPanel = createRadioButtonPanel();
        buttonPanel.add(radioButtonPanel);
        JPanel checkBoxPanel = createCheckBoxPanel();
        buttonPanel.add(checkBoxPanel);

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
     * @return the newly created panel
     */
    private JPanel createCheckBoxPanel() {
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
//        JPanel bottomPanel = new JPanel();
//        selectAllButton = addButtonToPane("Select All", bottomPanel);
//        deselectAllButton = addButtonToPane("Clear All", bottomPanel);
//        panel.add(bottomPanel);
        return panel;
    }

    /**
     * Method to create the radio button panel
     *
     * @return the newly created panel
     */
    private JPanel createRadioButtonPanel() {
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
     * Method to create the output panel
     *
     * @return the newly created panel
     */
    public JPanel createTextPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));
        panel.setBorder(BorderFactory.createTitledBorder("Output"));
        output = new JTextArea(10, 10);
        scrollPane = new JScrollPane(output);
        panel.add(scrollPane);
        return panel;
    }

    /**
     * Helper method for adding new buttons to panes and adding
     * the window as an actionListener.
     *
     * @param text Text for the button
     * @param pane Pane to which the button should be added
     * @return the newly created button
     */
    private JButton addButtonToPane(String text, Container pane) {
        JButton button = new JButton(text);
        pane.add(button);
        button.addActionListener(this);
        return button;
    }

    /**
     * Button event handler method
     *
     * @param e the action event
     */
    private void handleButtonAction(ActionEvent e) {
        String msg;
        JButton button = (JButton) e.getSource();
//        if (button == clearButton) {
//                output.setText("");
//            } else if (button == doneButton) {
//                System.exit(0);
//            } else if (button == selectAllButton) {
//                for (int i = 0; i < PETS.length; i++)
//                    pets[i].setSelected(true);
//            } else if (button == deselectAllButton) {
//                for (int i = 0; i < PETS.length; i++)
//                    pets[i].setSelected(false);
//            } else
                if (button == doneButton) {
                for (int i = 0; i < PETS.length; i++)
                    havePet[i] = pets[i].isSelected();
                for (int i = 0; i < COLORS.length; i++)
                    if (colors[i].isSelected())
                        favoriteColor = i;
            msg = "";
            for (int i = 0; i < PETS.length; i++)
                if (havePet[i])
                    msg = msg + (PETS[i] + ", ");
            if (msg.length() > 0)
                showMessage("Have pets: " + msg);
            else
                showMessage("Have no pets");
            showMessage("\nFavorite color: " + COLORS[favoriteColor] + "\n");
            showMessage("Live in: " + STATES[dropDownList.getSelectedIndex()] + "\n");
        }
    }

    /**
     * Menu event handler
     *
     * @param e the action event
     */
//    private void handleMenuAction(ActionEvent e) {
//        JMenuItem item = (JMenuItem) e.getSource();
//        if (item == openFile) {
//            showMessage("Opening File\n");
//        } else if (item == closeFile) {
//            showMessage("Closing File\n");
//        } else if (item == copyItem) {
//            showMessage("Copying\n");
//        } else if (item == pasteItem) {
//            showMessage("Pasting\n");
//        } else if (item == cutItem) {
//            showMessage("Cutting\n");
//        }
//    }

    /**
     * ActionListener interface method: actionPerformed
     *
     * @param e the action event
     */
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JMenuItem) {
            //handleMenuAction(e);
        } else if (source instanceof JButton) {
            handleButtonAction(e);
        }
    }

    /**
     * Method to create the entire menu bar
     *
     * @return the newly created menu bar
     */
//    public JMenuBar createMenuBar() {
//        menuBar = new JMenuBar();
//        menuBar.add(createFileMenu());
//
//        menuBar.add(createOtherMenu());
//        menuBar.add(createEditMenu());
//        return menuBar;
//    }

    /**
     * Method to create the File menu
     *
     * @return the newly created File menu object
     */
//    private JMenu createFileMenu() {
//        JMenu menu = new JMenu("File");
//
//        openFile = new JMenuItem("Open"); //the open item
//        openFile.addActionListener(this);
//        menu.add(openFile);
//
//        closeFile = new JMenuItem("Close"); // the close item
//        closeFile.addActionListener(this);
//        menu.add(closeFile);
//
//        menu.addSeparator(); // separator
//
//        ButtonGroup group = new ButtonGroup(); //example radio button menu itmes
//        rbMenuItem = new JRadioButtonMenuItem("ASCII");
//        rbMenuItem.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                showMessage("Choosing ASCII Encoding\n");
//            }
//        });
//        rbMenuItem.setSelected(true);
//        group.add(rbMenuItem); //add to button group
//        menu.add(rbMenuItem);
//
//        rbMenuItem = new JRadioButtonMenuItem("UNICODE");
//        rbMenuItem.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                showMessage("Choosing UNICODE Encoding \n");
//            }
//        });
//        group.add(rbMenuItem); //add to same button group
//        menu.add(rbMenuItem);
//
//        menu.addSeparator();
//
//        // add sample checkbox items
//        matchCaseItem = new JCheckBoxMenuItem("Match Case");
//        matchCaseItem.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                String status = matchCaseItem.isSelected() ? "on" : "off";
//                showMessage("Toggling match case to: " + status + "\n");
//            }
//        });
//        menu.add(matchCaseItem);
//
//        autoSaveItem = new JCheckBoxMenuItem("Auto Save");
//        autoSaveItem.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                String status = autoSaveItem.isSelected() ? "on" : "off";
//                showMessage("Toggling auto save to: " + status + "\n");
//            }
//        });
//        menu.add(autoSaveItem);
//
//        menu.addSeparator();
//
//        // create and add sub menu
//        menu.add(createSubMenu());
//
//        return menu;
//    }

    /**
     * Method to create a sub menu
     *
     * @return the newly created sub-menu object
     */
//    public JMenu createSubMenu() {
//        submenu = new JMenu("Send to...");
//
//        // create and add items to sub menu like any other menu
//        //In this example, inner classes are used as listeners
//
//        menuItem = new JMenuItem("Mail");
//        menuItem.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                showMessage("Send to Mail\n");
//            }
//        });
//        submenu.add(menuItem);
//
//        menuItem = new JMenuItem("iTunes");
//        menuItem.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                showMessage("Send to iTunes\n");
//            }
//        });
//        submenu.add(menuItem);
//
//        menuItem = new JMenuItem("iMovie");
//        menuItem.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                showMessage("Send to iMovie");
//            }
//        });
//        submenu.add(menuItem);
//
//        menuItem = new JMenuItem("Fax");
//        menuItem.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                showMessage("Send to Fax");
//            }
//        });
//        submenu.add(menuItem);
//        return submenu;
//    }
//
//    /**
//     * Method to create the Edit menu
//     *
//     * @return the newly create
//     */
//    public JMenu createEditMenu() {
//        JMenu menu = new JMenu("Edit");
//
//        copyItem = new JMenuItem("Copy");
//        copyItem.addActionListener(this);
//        menu.add(copyItem);
//
//        pasteItem = new JMenuItem("Paste");
//        pasteItem.addActionListener(this);
//        menu.add(pasteItem);
//
//        cutItem = new JMenuItem("Cut");
//        cutItem.addActionListener(this);
//        menu.add(cutItem);
//
//        return menu;
//
//    }
//
//    /**
//     * Method to create the third menu
//     *
//     * @return the newly created menu
//     */
//    public JMenu createOtherMenu() {
//        JMenu menu = new JMenu("Other");
//        JMenuItem menuItem;
//        menuItem = new JMenuItem("Item A");
//        menuItem.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                showMessage("Item A chosen\n");
//            }
//        });
//        menu.add(menuItem);
//
//        menuItem = new JMenuItem("Item B");
//        menuItem.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                showMessage("Item B chosen\n");
//            }
//        });
//        menu.add(menuItem);
//
//        menuItem = new JMenuItem("Item C");
//        menuItem.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                showMessage("Item C chosen\n");
//            }
//        });
//        menu.add(menuItem);
//
//        return menu;
//
//    }

    /**
     * Common method for output of messages to the text area.
     *
     * @param msg the message to output
     */
    public void showMessage(String msg) {
        output.append(msg);
    }


    public static void main(String[] args) {
        SampleGUI window = new SampleGUI();
        window.pack();
        window.setVisible(true);
    }
}
