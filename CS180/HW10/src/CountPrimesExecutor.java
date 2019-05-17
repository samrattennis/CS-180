
/**
 * Created by Samrat on 11/15/16.
 */
public class CountPrimesExecutor extends Thread {
    private long lower;
    private long upper;
    private int numThreads;
    private CountPrimes[] countPrimeThreads;

    public CountPrimesExecutor(int numThreads, long lower, long upper) {
        this.lower = lower;
        this.upper = upper;
        this.numThreads = numThreads;
        this.countPrimeThreads = new CountPrimes[numThreads];
        int low = (int) lower;
        int up;
        for (int i = 0; i < numThreads ; i++) {
            if (!(i == numThreads - 1)) {
                up = (int) (((upper - lower + 1) / numThreads) * (i + 1));
                countPrimeThreads[i] = new CountPrimes(low, up);
                low = (up + 1);
            } else {
                countPrimeThreads[i] = new CountPrimes(low, upper);
            }

        }
    }

    public void executeThreads() {
        for (int i = 0; i < numThreads ; i++) {
            countPrimeThreads[i].start();
        }
        for (int i = 0; i < numThreads ; i++) {
            try {
                countPrimeThreads[i].join();
            } catch (Exception e) {
                System.out.println("Exception!");
            }
        }
    }

}
