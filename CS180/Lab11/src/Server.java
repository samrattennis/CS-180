import java.io.*;
import java.net.DatagramPacket;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Samrat on 11/9/16.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        String firstname = "";
        String lastname = "";
        String marks = "";

        ServerSocket s = null;
        Socket s1 = null;

        PrintWriter pw = null;
        BufferedReader br = null;

        String host = "localhost";
        String userName = "";
        String fileName = "";

        PrintWriter pw1 = null;
        FileOutputStream stream = null;

        try {
            System.out.println("Creating Server Socket");
            s = new ServerSocket(10000);
        } catch (Exception e) {
            System.out.println("Error with IO: " + "\n" + e.getMessage());
        }

        while (true) {
            try {
                System.out.println("Server waiting for connection");
                s1 = s.accept();
                System.out.println("Connection Successful and waiting for commands");
                break;
            } catch (Exception e) {
                System.err.println("Error with IO: " + "\n" + e.getMessage());
            }
        }

        try {
            pw = new PrintWriter(s1.getOutputStream(), true);
            br = new BufferedReader(new InputStreamReader(s1.getInputStream()));
        } catch (NullPointerException e) {
            System.err.println("Null Pointer Exception");
        } catch (Exception e) {
            System.err.println("Error with IO:");
        }
            fileName = br.readLine();
            System.out.println("Filename: " + fileName);
            userName = br.readLine();
            System.out.println("Username: " + userName);

        BufferedReader fileRead = null;
        FileInputStream read = null;

        try {
            File files = new File("/Users/Samrat/Desktop/CS180/Lab11/Server/" + fileName);
            read = new FileInputStream(files);
            fileRead = new BufferedReader(new InputStreamReader(read));
        } catch (Exception e) {
            pw.println("File doesn't exist");
        }

        while (true) {
            String sline = fileRead.readLine();
            if (sline == null) {
                break;
            }

            String linenumber = sline.substring(0, sline.indexOf(';'));
            sline = sline.substring(sline.indexOf(';') + 1);
            String UserName = sline.substring(0, sline.indexOf(';'));
            sline = sline.substring(sline.indexOf(';') + 1);

            if (!(userName.equalsIgnoreCase(UserName))) {
                continue;
            } else {
                lastname = sline.substring(0, sline.indexOf(';'));
                sline = sline.substring(sline.indexOf(';') + 1);
                firstname = sline.substring(0, sline.indexOf(';'));
                sline = sline.substring(sline.indexOf(';') + 1);
                marks = sline;
                break;
            }
        }

        if (firstname.equals("")) {
            pw.println("Not found");
        }



        String print = "Last Name: " + lastname + "\nFirst Name: " + firstname + "\nMarks: " + marks;

        File out = new File("/Users/Samrat/Desktop/CS180/Lab11/Client/info.txt");
        FileOutputStream outStream = new FileOutputStream(out);
        DataOutputStream outputStream = new DataOutputStream(outStream);

        outputStream.writeBytes(print);

        pw.close();
        br.close();
        s.close();
        s1.close();
        read.close();
        fileRead.close();
        outStream.close();
        outputStream.close();


    }
}
