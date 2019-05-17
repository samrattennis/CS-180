/**
 * Created by Samrat on 11/10/16.
 */
public class Median {
    public static double median(double[] num) {
        int middle = num.length/2;

            if (num.length % 2 == 1) {
                return num[middle];
            } else {
                return (num[middle] + num[middle - 1])/2.0;
            }
    }

    public static void main(String[] args) {
        Median m = new Median();
        double[] mea = {2.0, 3.0, 1.0, 4.0};
        double d =  m.median(mea);
        System.out.println(d);
    }
}
