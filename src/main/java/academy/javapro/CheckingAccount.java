package academy.javapro;


public class CheckingAccount extends Account {
    private double overdraftLimit;
    private static final double TRANSACTION_FEE = 1.5; // Fee per withdrawal

    
    public CheckingAccount(String accountNumber, String customerName, double initialBalance, double overdraftLimit) {
        super(accountNumber, customerName, initialBalance); // Call to the parent constructor
        this.overdraftLimit = overdraftLimit;
    }

   
    public double getOverdraftLimit() {
        return overdraftLimit;
    }

   
    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

   
    @Override
    public void withdraw(double amount) {
        double newBalance = getBalance() - amount - TRANSACTION_FEE;
        
        if (newBalance >= overdraftLimit) {
            setBalance(newBalance); // Apply withdrawal and transaction fee
            System.out.println("Withdrawal successful. New balance: $" + String.format("%.2f", getBalance()));
        } else {
            System.out.println("Insufficient funds. Overdraft limit reached.");
        }
    }

   
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call to the parent method
        System.out.println("Account Type: Checking Account");
        System.out.println("Overdraft Limit: $" + String.format("%.2f", overdraftLimit));
        System.out.println("Transaction Fee: $" + String.format("%.2f", TRANSACTION_FEE));
    }
}
