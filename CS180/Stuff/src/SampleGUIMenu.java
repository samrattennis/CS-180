import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.*;
import java.awt.event.*;

/**
 * SampleGUIMenu.java
 * An example class that demonstrates the use of menus. Menu
 * events lead to output in the textarea. The class demonstrates
 * the use of inner classes to respond to events in addition to using
 * the window object as a listener
 *
 * @author Sunil Prabhakar
 *         (sunil@cs.purdue.edu)
 *         October 2009
 */
public class SampleGUIMenu extends JFrame implements ActionListener {

    JButton doneButton, clearButton;
    JTextArea output;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu fileMenu, editMenu, submenu, otherMenu;
    JMenuItem menuItem, openFile, closeFile;
    JMenuItem copyItem, pasteItem, cutItem;
    JRadioButtonMenuItem rbMenuItem;
    JCheckBoxMenuItem autoSaveItem, matchCaseItem;

    /**
     * The default constructor
     */

    public SampleGUIMenu() {
        this.setTitle("Sample Menu GUI");
        //create and add menubar
        this.setJMenuBar(createMenuBar());
        //add other elements
        addElements();
    }

    /**
     * Method to add elements to the content pane
     */
    private void addElements() {
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new FlowLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Text Area"));
        output = new JTextArea(20, 30);
        JScrollPane scrollPane = new JScrollPane(output);
        panel.add(scrollPane);

        contentPane.add(panel, BorderLayout.NORTH);

        JPanel controlPanel = new JPanel(new FlowLayout());
        controlPanel.setBorder(BorderFactory.createTitledBorder("Control Pane"));
        doneButton = addButtonToPane("Done", controlPanel);
        clearButton = addButtonToPane("Clear", controlPanel);
        contentPane.add(controlPanel, BorderLayout.SOUTH);
    }

    private JButton addButtonToPane(String text, Container pane) {
        JButton button = new JButton(text);
        pane.add(button);
        button.addActionListener(this);
        return button;
    }

    private void handleButtonAction(ActionEvent e) {
        String msg;
        JButton button = (JButton) e.getSource();
        if (button == clearButton) {
            output.setText("");
        } else if (button == doneButton) {
            System.exit(0);
        }
    }

    private void handleMenuAction(ActionEvent e) {
        JMenuItem item = (JMenuItem) e.getSource();
        if (item == openFile) {
            showMessage("Opening File\n");
        } else if (item == closeFile) {
            showMessage("Closing File\n");
        } else if (item == copyItem) {
            showMessage("Copying\n");
        } else if (item == pasteItem) {
            showMessage("Pasting\n");
        } else if (item == cutItem) {
            showMessage("Cutting\n");
        }
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JMenuItem) {
            handleMenuAction(e);
        } else if (source instanceof JButton) {
            handleButtonAction(e);
        }
    }

    public JMenuBar createMenuBar() {
        menuBar = new JMenuBar();
        menuBar.add(createFileMenu());
        menuBar.add(createEditMenu());
        menuBar.add(createOtherMenu());
        return menuBar;
    }

    private JMenu createFileMenu() {
        JMenu menu = new JMenu("File");
        openFile = new JMenuItem("Open");
        openFile.addActionListener(this);
        menu.add(openFile);

        closeFile = new JMenuItem("Close");
        closeFile.addActionListener(this);
        menu.add(closeFile);
        menu.addSeparator();

        ButtonGroup group = new ButtonGroup();
        rbMenuItem = new JRadioButtonMenuItem("ASCII");
        rbMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showMessage("Choosing ASCII Encoding\n");
            }
        });
        rbMenuItem.setSelected(true);
        group.add(rbMenuItem);
        menu.add(rbMenuItem);

        rbMenuItem = new JRadioButtonMenuItem("UNICODE");
        rbMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showMessage("Choosing UNICODE Encoding \n");
            }
        });
        group.add(rbMenuItem);
        menu.add(rbMenuItem);

        menu.addSeparator();

        matchCaseItem = new JCheckBoxMenuItem("Match Case");
        matchCaseItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String status = matchCaseItem.isSelected() ? "on" : "off";
                showMessage("Toggling match case to: " + status + "\n");
            }
        });
        menu.add(matchCaseItem);

        autoSaveItem = new JCheckBoxMenuItem("Auto Save");
        autoSaveItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String status = autoSaveItem.isSelected() ? "on" : "off";
                showMessage("Toggling auto save to: " + status + "\n");
            }
        });
        menu.add(autoSaveItem);

        menu.addSeparator();


        menu.add(createSubMenu());

        return menu;
    }

    public JMenu createSubMenu() {
        submenu = new JMenu("Send to...");

        menuItem = new JMenuItem("Mail");
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showMessage("Send to Mail\n");
            }
        });
        submenu.add(menuItem);

        menuItem = new JMenuItem("iTunes");
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showMessage("Send to iTunes\n");
            }
        });
        submenu.add(menuItem);

        menuItem = new JMenuItem("iMovie");
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showMessage("Send to iMovie");
            }
        });
        submenu.add(menuItem);

        menuItem = new JMenuItem("Fax");
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showMessage("Send to Fax");
            }
        });
        submenu.add(menuItem);
        return submenu;
    }

    public JMenu createEditMenu() {
        JMenu menu = new JMenu("Edit");

        copyItem = new JMenuItem("Copy");
        copyItem.addActionListener(this);
        menu.add(copyItem);

        pasteItem = new JMenuItem("Paste");
        pasteItem.addActionListener(this);
        menu.add(pasteItem);

        cutItem = new JMenuItem("Cut");
        cutItem.addActionListener(this);
        menu.add(cutItem);

        return menu;

    }

    public JMenu createOtherMenu() {
        JMenu menu = new JMenu("Other");
        JMenuItem menuItem;
        menuItem = new JMenuItem("Item A");
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showMessage("Item A chosen\n");
            }
        });
        menu.add(menuItem);

        menuItem = new JMenuItem("Item B");
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showMessage("Item B chosen\n");
            }
        });
        menu.add(menuItem);

        menuItem = new JMenuItem("Item C");
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showMessage("Item C chosen\n");
            }
        });
        menu.add(menuItem);

        return menu;

    }

    public void showMessage(String msg) {
        output.append(msg);
    }

    public JPanel createTextPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));
        panel.setBorder(BorderFactory.createTitledBorder("Text"));
        output = new JTextArea(20, 30);
        scrollPane = new JScrollPane(output);
        panel.add(scrollPane);
        return panel;
    }

    public static void main(String[] args) {
        SampleGUIMenu window = new SampleGUIMenu();
        window.pack();
        window.setVisible(true);
    }
}