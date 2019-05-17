import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class SampleGUI extends JFrame {

    // Server
    String serverIP = "localhost";
    int serverPort = 9999;
    Socket socket;
    static String token = "";
    private String[] score = new String[6];
    private String playerUsername;
    private String[] joinUsername = new String[6];
    private String question;
    private String answer;

    /* Main panel */
    JPanel mainPanel = new JPanel();
    CardLayout layout = new CardLayout();

    /* Panel login */
    JPanel loginPanel = new JPanel();
    JPanel loginPanel1 = new JPanel(new GridBagLayout());
    JPanel loginPanel2 = new JPanel(new GridBagLayout());
    JPanel loginPanel3 = new JPanel();
    JLabel foilmaker = new JLabel("FoilMaker!");
    JLabel usernameLabel = new JLabel("Username");
    JLabel passwordLabel = new JLabel("Password");
    JTextField usernameEntry = new JTextField(14);
    JPasswordField passwordEntry = new JPasswordField(14);
    JButton loginButton = new JButton("Login");
    JButton registerButton = new JButton("Register");

    /* Panel start or join game */
    JPanel startNewGamePanel = new JPanel(new GridBagLayout());
    JButton start = new JButton("Start game");
    JButton join = new JButton("Join a game");
    private static String joinCode;

    /* Panel to enter join code */
    JPanel joinGame = new JPanel();
    JPanel joinGame1 = new JPanel();
    JPanel joinGame2 = new JPanel();
    JPanel joinGame3 = new JPanel();
    JTextField codeEntry = new JTextField(5);
    JButton joinGameSession = new JButton("Join Game");

    /* Panel to wait for leader */
    JPanel waitForLeader = new JPanel(new GridBagLayout());
    JLabel waiting = new JLabel("Waiting for leader...");

    /* Panel to host screen */
    JPanel hostScreen = new JPanel();
    JPanel hostScreen1 = new JPanel();
    JPanel hostScreen2 = new JPanel();
    JPanel hostScreen3 = new JPanel();
    JButton hostStartGame = new JButton("Start Game");
    int players = 0;

    /* Panel to suggestion screen */
    JPanel suggestionPanel = new JPanel();
    JPanel suggestionPanel1 = new JPanel();
    JPanel suggestionPanel2 = new JPanel();
    JPanel suggestionPanel3 = new JPanel();
    JPanel suggestionPanel4 = new JPanel();

    public SampleGUI() {
        // Open socket connection with server
        try {
            socket = new Socket(serverIP, serverPort);
        } catch (Exception e) {}
        /* Add properties to login panel */
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0,15,200,60);
        loginPanel.add(foilmaker, gbc);

        gbc.insets = new Insets(145,13,13,59);
        gbc.gridx = 0;
        gbc.gridy = 13;
        loginPanel1.add(usernameLabel, gbc);
        gbc.insets = new Insets(145,13,13,59);
        gbc.gridx = 1;
        gbc.gridy = 13;
        loginPanel1.add(usernameEntry, gbc);

        gbc.insets = new Insets(7,15,15,60);
        gbc.gridx = 0;
        gbc.gridy = 17;
        loginPanel1.add(passwordLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 17;
        loginPanel1.add(passwordEntry, gbc);

        gbc.insets = new Insets(100,1,300,5);
        gbc.gridx = 17;
        gbc.gridy = 50;
        loginPanel2.add(loginButton, gbc);
        gbc.gridx = 27;
        gbc.gridy = 50;
        loginPanel2.add(registerButton, gbc);

        loginPanel3.add(loginPanel, BorderLayout.NORTH);
        loginPanel3.add(loginPanel1, BorderLayout.CENTER);
        loginPanel3.add(loginPanel2, BorderLayout.SOUTH);

        /* Add properties to startGame panel */
        gbc.insets = new Insets(7,15,15,60);
        gbc.gridx = 17;
        gbc.gridy = 25;
        startNewGamePanel.add(start, gbc);
        gbc.gridx = 27;
        gbc.gridy = 25;
        startNewGamePanel.add(join, gbc);

        /* Add properties to enter token panel */
        joinGame1.setBorder(BorderFactory.createTitledBorder("Enter the game key to join the game"));
        joinGame1.add(codeEntry);
        joinGame2.add(joinGameSession);
        joinGame3.setLayout(new BoxLayout(joinGame3, BoxLayout.Y_AXIS));
        joinGame3.add(joinGame);
        joinGame3.add(joinGame1);
        joinGame3.add(joinGame2, BorderLayout.SOUTH);

        /* Add properties to wait for leader panel */
        gbc.insets = new Insets(100,1,300,5);
        waitForLeader.add(waiting, gbc);

        /* Add properties to host screen */
        hostScreen.setBorder(BorderFactory.createTitledBorder("Others should use this key to join your game"));
        JTextArea joinCodeText = new JTextArea(1,5);
        joinCodeText.setEditable(false);
        hostScreen.add(joinCodeText);
        hostScreen1.setBorder(BorderFactory.createTitledBorder("Participants"));
        JTextArea participants = new JTextArea(12,30);
        participants.setEditable(false);
        hostScreen1.add(participants);
        hostScreen2.add(hostStartGame);
        hostScreen3.setLayout(new BoxLayout(hostScreen3, BoxLayout.Y_AXIS));
        hostScreen3.add(hostScreen, BorderLayout.CENTER);
        hostScreen3.add(hostScreen1);
        hostScreen3.add(hostScreen2, BorderLayout.SOUTH);

        /* Add properties to suggestion screen */
        suggestionPanel.setBorder(BorderFactory.createTitledBorder("What is the word for"));
        JTextArea description = new JTextArea(10,25);
        suggestionPanel.add(description);
        suggestionPanel1.setBorder(BorderFactory.createTitledBorder("Your Suggestion"));
        JTextArea suggestionBar = new JTextArea(1,25);
        suggestionPanel1.add(suggestionBar);
        JButton submitSuggestion = new JButton("Submit Suggestion");
        suggestionPanel2.add(submitSuggestion);
        suggestionPanel3.setLayout(new BoxLayout(suggestionPanel3, BoxLayout.Y_AXIS));
        suggestionPanel3.add(suggestionPanel);
        suggestionPanel3.add(suggestionPanel1);
        suggestionPanel3.add(suggestionPanel2, BorderLayout.SOUTH);
        suggestionPanel4.add(suggestionPanel3);

        /* Add panels to main panel */
        mainPanel.setLayout(layout);
        mainPanel.add(loginPanel3, "login");
        mainPanel.add(startNewGamePanel, "startGame");
        mainPanel.add(joinGame3, "joinCode");
        mainPanel.add(waitForLeader, "waiting");
        mainPanel.add(hostScreen3, "hostScreen");
        mainPanel.add(suggestionPanel4, "suggestionScreen");

        /* Add action listener to buttons on panels */
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String username1 = usernameEntry.getText();
                char[] passwordChars = passwordEntry.getPassword();
                String password1 = "";
                for (int i = 0; i < passwordChars.length; i++)
                    password1 += passwordChars[i];
                if (!login(username1, password1)){}
                else {
                    playerUsername = username1;
                    layout.show(mainPanel, "startGame");
                }
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username1 = usernameEntry.getText();
                char[] passwordChars = passwordEntry.getPassword();
                String password1 = "";
                for (int i = 0; i < passwordChars.length; i++)
                    password1 += passwordChars[i];
                createNewUser(username1, password1);
            }
        });

        /* Add action listener to start game and join game buttons */
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                startNewGame(token);
                joinCodeText.setText(joinCode);
                layout.show(mainPanel, "hostScreen");
            }
        });
        join.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                layout.show(mainPanel, "joinCode");
            }
        });

        /* Add action listener to join game button */
        joinGameSession.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                joinCode = codeEntry.getText();
                System.out.println(token);
                if (!JoinAGame(playerUsername, token, joinCode)){}
                else
                    layout.show(mainPanel, "waiting");
            }
        });

        hostStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkForJoiners();
                if (launchGame(token, joinCode)) {
                    description.setText(question);
                    layout.show(mainPanel, "suggestionScreen");
                }
            }
        });

        
        /* Add logout override on window close */
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                logOut();
                super.windowClosing(e);
            }
        });


        /* Set up frame */
        /* Add main panel to GUI frame */
        add(mainPanel);
        /* Set dimensions */
        setLocationRelativeTo(null);
        setPreferredSize(new Dimension(390,590));
        /* Dispose frame when close button is pressed */
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        /* Show panel 1 initially */
        pack();
        layout.show(mainPanel, "login");
        setVisible(true);
    }

    // Method to log in
    public boolean login(String username, String password) {
        try {
            // Create data writer
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Create data reader
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader in = new BufferedReader(isr);
            // Send message to server
            out.println("LOGIN--"+username+"--"+password);

            // Read server response
            String serverMessage = in.readLine();
            String status = serverMessage.split("--")[2];
            token = serverMessage.split("--")[3];
            if (status.equals("INVALIDMESSAGEFORMAT")) {
                JOptionPane.showMessageDialog(null, "Request does not comply with the format given above");
            }
            else if (status.equals("UNKNOWNUSER")) {
                JOptionPane.showMessageDialog(null, "Invalid username");
            }
            else if (status.equals("INVALIDUSERPASSWORD")) {
                JOptionPane.showMessageDialog(null, "Invalid password (User not authenticated");
            }
            else if (status.equals("USERALREADYLOGGEDIN")) {
                JOptionPane.showMessageDialog(null, "User already logged in");
            }
            else {
                JOptionPane.showMessageDialog(null, "Welcome " + username);
                return true;
            }
            System.out.println(serverMessage);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    // Method to create a new user
    public void createNewUser(String username, String password) {
        try {
            // Create data writer
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Create data reader
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader in = new BufferedReader(isr);
            // Send message to server
            out.println("CREATENEWUSER--"+username+"--"+password);

            // Read server response
            String serverMessage = in.readLine();
            String status = serverMessage.split("--")[2];
            if (status.equals("INVALIDMESSAGEFORMAT"))
                JOptionPane.showMessageDialog(null, "Request does not comply with the format given above");
            else if (status.equals("INVALIDUSERNAME"))
                JOptionPane.showMessageDialog(null, "Username empty");
            else if (status.equals("INVALIDUSERPASSWORD"))
                JOptionPane.showMessageDialog(null, "Password empty");
            else if (status.equals("USERALREADYEXISTS"))
                JOptionPane.showMessageDialog(null, "User already exists in the user store");
            else {
                JOptionPane.showMessageDialog(null, "Welcome " + username + ". Your account has been created.");
            }
            System.out.println(serverMessage);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    // Method to start a new game
    public boolean startNewGame(String token) {
        try {
            // Create data writer
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Create data reader
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader in = new BufferedReader(isr);
            // Send message to server
            out.println("STARTNEWGAME--" + token);
            // Read server response
            String serverMessage = in.readLine();
            String status = serverMessage.split("--")[2];
            if (status.equals("USERNOTLOGGEDIN"))
                JOptionPane.showMessageDialog(null, "Invalid user token");
            else if (status.equals("FAILURE"))
                JOptionPane.showMessageDialog(null, "User already playing or server failed to create a new game session due to an internal error");
            else {
                joinCode = serverMessage.split("--")[3];
                JOptionPane.showMessageDialog(null, "New game created. Your login code is: " + joinCode);
                return true;
            }
            System.out.println(serverMessage);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    // Method to join a game
    public boolean JoinAGame(String username, String token, String joinCode) {
        try {
            // Create data writer
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Create data reader
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader in = new BufferedReader(isr);
            // Send message to server
            out.println("JOINGAME--"+token+"--"+joinCode);

            // Read server response
            String serverMessage = in.readLine();
            String status = serverMessage.split("--")[2];
            if (status.equals("USERNOTLOGGEDIN"))
                JOptionPane.showMessageDialog(null, "Invalid user token");
            else if (status.equals("GAMEKEYNOTFOUND"))
                JOptionPane.showMessageDialog(null, "Invalid game token");
            else if (status.equals("FAILURE"))
                JOptionPane.showMessageDialog(null, "User already playing the game");
            else {
                out.println("NEWPARTICIPANT--"+username+"--"+score);
                return true;
            }
            System.out.println(serverMessage);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    public void checkForJoiners() {
        try {
            // Create data reader
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader in = new BufferedReader(isr);

            // Read server response
            String serverMessage = in.readLine();
            String status = serverMessage.split("--")[0];
            if (status.equals("NEWPARTICIPANT")) {
                joinUsername[players] = serverMessage.split("--")[1];
                score[players] = serverMessage.split("--")[2];
                players++;
            }
            System.out.println(serverMessage);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    // Method to launch the game
    public boolean launchGame(String token, String joinCode) {
        try {
            // Create data writer
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Create data reader
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader in = new BufferedReader(isr);
            // Send message to server
            if (players != 0) {
                out.println("ALLPARTICIPANTSHAVEJOINED--" + token + "--" + joinCode);
                String serverMessage = in.readLine();
                question = serverMessage.split("--")[1];
                answer = serverMessage.split("--")[2];
                System.out.println(serverMessage);
                return true;
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    // Method to send player suggestion
    public void sendSuggestion(String token, String joinCode, String suggestion) {
        try {
            // Create data writer
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Create data reader
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader in = new BufferedReader(isr);
            // Send message to server
            out.println("PLAYERSUGGESTION--"+token+"--"+joinCode+"--"+suggestion);

            // Read server response
            String serverMessage = in.readLine();
            String status = serverMessage.split("--")[2];
            if (status.equals("USERNOTLOGGEDIN"))
                JOptionPane.showMessageDialog(null, "Invalid user token");
            else if (status.equals("INVALIDGAMETOKEN"))
                JOptionPane.showMessageDialog(null, "Invalid game token");
            else if (status.equals("UNEXPECTEDMESSAGETYPE"))
                JOptionPane.showMessageDialog(null, "A suggestion was sent when a different message was expected by the server");
            else if (status.equals("INVALIDMESSAGEFORMAT"))
                JOptionPane.showMessageDialog(null, "Message format is not according to the required parameters");
            else {
                // TODO
                // GET AMOUNT OF PLAYERS AND RUN A FOR LOOP + 1
                // TO GET THE AMOUNT OF POSSIBLE ANSWERS
            }
            System.out.println(serverMessage);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    // Method to send player choice
    public void sendPlayerChoice(String token, String joinCode, String choice) {
        try {
            // Create data writer
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Create data reader
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader in = new BufferedReader(isr);
            // Send message to server
            out.println("PLAYERCHOICE--"+token+"--"+joinCode+"--"+choice);

            // Read server response
            String serverMessage = in.readLine();
            String status = serverMessage.split("--")[2];
            if (status.equals("USERNOTLOGGEDIN"))
                JOptionPane.showMessageDialog(null, "Invalid user token");
            else if (status.equals("INVALIDGAMETOKEN"))
                JOptionPane.showMessageDialog(null, "Invalid game token");
            else if (status.equals("UNEXPECTEDMESSAGETYPE"))
                JOptionPane.showMessageDialog(null, "A suggestion was sent when a different message was expected by the server");
            else if (status.equals("INVALIDMESSAGEFORMAT"))
                JOptionPane.showMessageDialog(null, "Message format is not according to the required parameters");
            else {

            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    // Method to receive round results
    public void receiveResults() {
        try {
            // Create data reader
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader in = new BufferedReader(isr);

            // Read server response
            String serverMessage = in.readLine();
            // TODO
            // PRINT RESULTS OF THE ROUND
            // FOR I = 1, I INCREASES BY 5
            // UNTIL THE AMOUNT OF PLAYERS
            // HAS BEEN REACHED
            System.out.println(serverMessage);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    // Method to start next round
    public void nextRound() {
        // TODO
    }

    // Method to log out
    public void logOut() {
        try {
            // Create data writer
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Create data reader
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader in = new BufferedReader(isr);
            // Send message to server
            out.println("LOGOUT--");

            // Read server response
            String serverMessage = in.readLine();
            String status = serverMessage.split("--")[2];
            if (status.equals("USERNOTLOGGEDIN"))
                JOptionPane.showMessageDialog(null, "User not currently logged in");
            else {
                JOptionPane.showMessageDialog(null, "User logged out of the system successfully");
            }
            System.out.println(serverMessage);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SampleGUI(); /* Show GUI */
    }
}