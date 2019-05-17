import java.io.File;
import java.util.*;
import java.io.IOException;

/**
 * Created by Samrat on 11/5/16.
 */
public class Parser {
    private String userName;
    private int numQueries;

    public void parse(String filePath) throws WrongFileFormatException, WrongNumberOfQueriesException, InvalidInputException,
            MalformedQueryException, IOException {

        File file = new File(filePath);
        Scanner scan = new Scanner(file);
        String s = scan.nextLine();

        if (!s.equals("C")) {
        throw new WrongFileFormatException("Wrong File Format");
        }
        userName = scan.nextLine();

        String s1 = scan.nextLine();
        if (!s1.equals("c")) {
            throw new WrongFileFormatException("Wrong File Format");
        }

        String s2 = scan.nextLine();
        if (!s2.equals("N")) {
            throw new WrongFileFormatException("Wrong File Format");
        }

        numQueries= scan.nextInt();
        if (!(numQueries > 0)) {
            throw new InvalidInputException("Wrong Number of Queries Exception");
        }
        scan.nextLine();

        String s3 = scan.nextLine();
        if (!s3.equals("n")) {
            throw new WrongFileFormatException("Wrong File Format");
        }

        String s4 = scan.nextLine();
        if (!s4.equals("Q")) {
            throw new WrongFileFormatException("Wrong File Format");
        }

        int counter = 0;
        while (counter < numQueries) {
            String s5 = scan.nextLine();
            if (!s5.contains("SELECT") && !s5.contains("UPDATE") && !s5.contains("INSERT") && !s5.contains("DELETE") && !s5.equals("q")) {
                throw new MalformedQueryException("Malformed Query Exception");
            } else if (s5.equals("q")) {
                throw new WrongNumberOfQueriesException("Wrong Number of Queries Exception");
            }
            counter++;
        }
        String s6 =scan.nextLine();
        if (s6.contains("SELECT") || s6.contains("UPDATE") || s6.contains("INSERT")
                || s6.contains("DELETE") && !s6.equals("q")) {
            throw new WrongNumberOfQueriesException("Wrong Number of Queries Exception");
        }
        if (!s6.equals("q")) {
            throw new WrongFileFormatException("Wrong File Format");
        }
    }
    public String getUserName() {
        return userName;
    }
    public int getNumQueries() {
        return numQueries;
    }

    public static void main(String[] args) {
        Parser p = new Parser();
        try {
            //p.parse("HW9/file1.sql");
            p.parse("HW9/file11.sql");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
