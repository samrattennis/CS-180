/**
 * Created by sunil on 10/11/16.
 */
public class SavingsAccount extends Account {
    protected static final double OVERDRAW_LIMIT = -1000.0;
    protected static double currentInterestRate = 5.0;

    public SavingsAccount(int ssn) {
        super(ssn);
    }

    public SavingsAccount(String name, int ssn, double bal){
        super(name, ssn, bal);
    }

    public void accrueInterest() {
        balance *= 1 + currentInterestRate / 100.0;
    }

    public void withdraw(double amount) {
        double temp;
        temp = balance - amount;

        if (temp >= OVERDRAW_LIMIT)
            balance = temp;
        else
            System.out.println("Insufficient funds");
    }
}