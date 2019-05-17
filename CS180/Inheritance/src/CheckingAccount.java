/**
 * CheckingAccount extends Account and provides its own version of accrueInterest (overides the parent's
 * version) and withdraw methods.
 * Two extra fields are defined: the minimum interest required to earn interest, and the interest rate.
 * Created by sunil on 10/11/16.
 */
public class CheckingAccount extends Account{
    protected static final double MIN_INT_BALANCE = 100.0; //Minimum balance required to earn interest
    protected double currentInterestRate = 1.0;   //the current rate of interest as a percentage value

    public CheckingAccount(int ssn) {
        super(ssn);
    }

    CheckingAccount(String name, int ssn, double bal){
        super(name, ssn, bal);
    }

    public void accrueInterest() {
        if (balance > MIN_INT_BALANCE)
            balance *= 1 + currentInterestRate /100.0;
    }

    /**
     * withdraw funds from the account: allowed as long as the balance doesn't become negative
     * @param amount the amount to withdraw.
     */
    public void withdraw(double amount) {
        double temp;
        temp = balance - amount;
        if (temp >= 0)
            balance = temp;
        else
            System.out.println("Insufficient funds");
    }
}
