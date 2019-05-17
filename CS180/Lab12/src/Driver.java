/**
 * Created by Samrat on 11/15/16.
 */
public class Driver {
    public static void main(String[] args) {
        Thread t1 = new A();
        t1.start();
        Runnable r = new B();
        Thread t = new Thread(r);
        t.start();
    }
}
