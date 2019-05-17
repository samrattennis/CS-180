/**
 * ShowWindow2 -- demonstrates the use of a subclass of JFrame to create a customized
 * JFrame object.
 *
 * @author Sunil Prabhakar
 */

public class ShowWindow2 {
    public static void main(String[] args) {
        MyWindow myWindow = new MyWindow("My Window");
        MyWindow window = new MyWindow("Another Window");
    }
}