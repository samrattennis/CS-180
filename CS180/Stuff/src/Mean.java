/**
 * Created by Samrat on 11/10/16.
 */
public class Mean {
    public static int mean(int[] num) {
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum+= num[i];

        }
        return sum/num.length;
    }

    public static void main(String[] args) {
        Mean m = new Mean();
        int[] num = {4,2,3};
        double a = m.mean(num);
        System.out.println(a);
    }
}
