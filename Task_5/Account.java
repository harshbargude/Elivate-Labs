import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountHolder;

    private double balance;
    private List<String> transactionHistory;

    public Account(String accountHolder) {
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created for: " + accountHolder);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");

            return;

        }
        balance += amount;
        transactionHistory.add("Deposited: ₹" + amount + " | New Balance: ₹" + balance);
        System.out.println("Successfully deposited ₹" + amount);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdraw amount must be positive.");
            return;
        }

        if (amount >balance) {
            System.out.println("Insufficient funds.");
            return;

        }
        balance -= amount;
        transactionHistory.add("Withdrew: ₹" + amount + " | New Balance: ₹" + balance);
        System.out.println("Successfully withdrew ₹" + amount);

    }

    public double  getBalance() {
        return balance;

    }


    public void printTransactionHistory() {
        System.out.println("\nTransaction History for " + accountHolder + ":");
        for (String record : transactionHistory) {
            
            System.out.println(record);
        }
    }
}
