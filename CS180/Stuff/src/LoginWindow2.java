//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//
///**
// * LoginWindow2.java
// * A simple class to shows the use  of a subclass of JFrame to create windows.
// * A simple action handler is also defined.
// *
// * @author Sunil Prabhakar
// *         (sunil@cs.purdue.edu)
// *         October 2009
// */
//
//public class LoginWindow2 extends JFrame implements ActionListener {
//    private JButton loginButton, cancelButton;
//    private JTextField nameInput;
//
//    /**
//     * Default constructor
//     *
//     * @param title the title for this window.
//     */
//    public LoginWindow2(String title) {
//        //set title and size
//        this.setTitle(title);
//        this.setSize(200, 100);
//
//        //create buttons and text fields
//        loginButton = new JButton("Login");
//        cancelButton = new JButton("Cancel");
//        JLabel label = new JLabel("Name");
//        nameInput = new JTextField("<Enter name>");
//
//        //get container and set layout
//        Container contentPane = this.getContentPane();
//        contentPane.setLayout(new FlowLayout());
//
//        //add buttons and text field to container
//        contentPane.add(label);
//        contentPane.add(nameInput);
//        contentPane.add(loginButton);
//        contentPane.add(cancelButton);
//
//        //register the window to listen to the login button's events
//        loginButton.addActionListener(this);
//        this.pack();
//        this.setVisible(true);
//    }
//
//    /**
//     * ActionListener interface method: actionPerformed  -- this method is called whenever an
//     * action event takes place on an object being listened to by this LoginWindow2 object.
//     *
//     * @param e -- the Action Event
//     */
//    public void actionPerformed(ActionEvent e) {
//        String name = nameInput.getText();
//        System.out.println(name + " is logging in");
//    }
//}
