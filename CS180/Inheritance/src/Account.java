/**
 * A class implementing a simple bank Account with the owner's name, ssn, and balance.
 * Objects of this class do not have any action to accrue interest. A deposit method is
 * defined but no withdraw method. This would be defined by descendant classes since the
 * details are dependent on the type of account.
 *
 * Created by sunil on 10/11/16.
 */
public class Account {
    protected String ownerName; //the account owner's names
    protected int socialSecNum; //the account owner's social security number
    protected double balance;  //the acount's current balance;

    public Account(int ssn) {
        this("Unknown", ssn, 0.0);
    }

    public Account(String name, int ssn) {
        this(name, ssn, 0.0);
    }

    public Account(String name, int ssn, double bal) {
        ownerName = name;
        socialSecNum = ssn;
        balance = bal;
    }

    public String getName() {
        return ownerName;
    }

    public int getSsn() {
        return socialSecNum;
    }

    public double getBalance() {
        return balance;
    }

    public void setName(String newName) {
        ownerName = newName;
    }

    public void accrueInterest() {
        System.out.println("No interest");
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public String toString(){
        return ("Account owner: " + ownerName + ", SSN:" + socialSecNum + ", balance:" + balance);
    }
}