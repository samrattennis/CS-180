import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Samrat on 11/15/16.
 */
public class CountPrimes extends Thread {
    private long lower;
    private long upper;
    private static int numPrimes;
    static AtomicInteger atomicInteger = new AtomicInteger(numPrimes);

    public CountPrimes(long lower, long upper) {
        this.lower = lower;
        this.upper = upper;
        this.numPrimes = 0;
    }

    public synchronized void run() {
        for (int i = (int) lower; i <= upper ; i++) {
            if (isPrime(i)) {
                atomicInteger.incrementAndGet();
                System.out.println(i);
            }
        }
        //atomicInteger.incrementAndGet();
    }

    public static int getNumPrimes() {
        return atomicInteger.get();
    }

    public static void resetNumPrimes() {
        atomicInteger.set(0);
    }

    public boolean isPrime(long num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if ((num % i) == 0) {
                return false;
            }
        }
        return true;
    }

//    public static void main(String[] args) {
//        CountPrimes countPrimes = new CountPrimes(1, 2);
//        System.out.println(countPrimes.isPrime(32416189777L));
//    }
}
