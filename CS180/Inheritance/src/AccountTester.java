/**
 * Created by sunil on 10/11/16.
 */
public class AccountTester {
    public static void main(String[] args) {
        Account acct;
        SavingsAccount savings;
        CheckingAccount checking;


        acct = new Account("JJ", 123, 20.00);
        savings = new SavingsAccount("JJ", 123, 20.00);
        checking = new CheckingAccount("JJ", 123, 20.00);


        acct.accrueInterest();
        System.out.println("Account  after accruing interest: " + acct);

        savings.accrueInterest();
        System.out.println("Savings  after accruing interest: " + savings);

        checking.accrueInterest();
        System.out.println("Checking  after accruing interest: " + checking);


        //acct.withdraw(20);  No withdraw method defined for Account objects
        savings.withdraw(100.00);
        System.out.println("Savings  after withdrawing 100: " + savings);

        checking.withdraw(100);
        System.out.println("Checking  after withdrawing 100: " + checking);

    }
}
