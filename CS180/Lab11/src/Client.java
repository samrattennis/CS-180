import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Samrat on 11/9/16.
 */
public class Client {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Filename: ");
        String filename = s.nextLine();
        System.out.println("Enter Username: ");
        String username = s.nextLine();
        Socket socket = null;
        PrintWriter pw = null;
        BufferedReader br = null;

        try {
            socket = new Socket("localhost", 10000);
            pw = new PrintWriter(socket.getOutputStream(), true);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            pw.println(filename);
            pw.println(username);

            String result = br.readLine();

            if (result.equals("Not found")) {
                System.err.println("User not found");
            } else {
                System.err.println("File doesn't exist");
            }


        } catch (Exception e) {

        } finally {
            //socket.close();
            pw.close();
            //br.close();
        }


    }
}
