import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Samrat on 11/15/16.
 */
public class Divider implements Runnable {
    private static AtomicInteger counter = new AtomicInteger(0);
    private int start;
    private int end;

    public Divider(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    public synchronized void run() {
        for (int i = start; i < end ; i++) {
            if (i % 7 == 0) {
                counter.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        try {
            Runnable r1 = new Divider(1, 1000);
            Thread t1 = new Thread(r1);
            t1.start();

            Runnable r2 = new Divider(1001, 2000);
            Thread t2 = new Thread(r2);
            t2.start();

            Runnable r3 = new Divider(2001, 3000);
            Thread t3 = new Thread(r3);
            t3.start();

            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println("Big Problem");
        }

        System.out.println(counter);
    }
}
