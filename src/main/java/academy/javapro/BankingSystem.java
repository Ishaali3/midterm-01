package academy.javapro;

/**
 * Main class demonstrating the banking system functionality.
 * Creates and operates on different types of accounts using polymorphism.
 */
public class BankingSystem {

    public static void main(String[] args) {
        System.out.println("======= Banking System Demonstration =======\n");

        // Create different types of accounts
        // Create a new SavingsAccount object with account number "SA001", account holder name "John Doe", initial balance 1000.0, and interest rate 2.5
        SavingsAccount savingsAccount = new SavingsAccount("SA001", "John Doe", 1000.0, 2.5);

        // Create a new CheckingAccount object with account number "CA001", account holder name "Jane Smith", initial balance 2000.0, and overdraft limit 500.0
        CheckingAccount checkingAccount = new CheckingAccount("CA001", "Jane Smith", 2000.0, 500.0);

        // Store accounts in an array to demonstrate polymorphism
        Account[] accounts = new Account[2];
        accounts[0] = savingsAccount;
        accounts[1] = checkingAccount;

        // Display initial information for all accounts
        System.out.println("--- Initial Account Information ---");

        // Loop through the accounts array and call the displayInfo method for each account
        for (Account account : accounts) {
            account.displayInfo();
            System.out.println(); // Print newline for separation
        }

        // Demonstrate account operations
        System.out.println("--- Performing Account Operations ---");

        // Test deposit operations
        System.out.println("\n1. Testing deposits:");

        // Deposit 500.0 into the savings account
        savingsAccount.deposit(500.0);

        // Deposit 300.0 into the checking account
        checkingAccount.deposit(300.0);

        // Test withdrawal operations
        System.out.println("\n2. Testing withdrawals:");

        // Withdraw 1300.0 from the savings account (should fail due to minimum balance requirement)
        savingsAccount.withdraw(1300.0);

        // Withdraw 200.0 from the savings account (should succeed)
        savingsAccount.withdraw(200.0);

        // Withdraw 2500.0 from the checking account (should go into overdraft)
        checkingAccount.withdraw(2500.0);

        // Test account-specific operations
        System.out.println("\n3. Testing account-specific operations:");

        // Savings account - apply interest
        System.out.println("\nSavings Account - Applying interest:");
        savingsAccount.applyInterest();

        // Checking account - modify overdraft limit
        System.out.println("\nChecking Account - Modifying overdraft limit:");
        checkingAccount.setOverdraftLimit(1000.0);

        // Display updated information for all accounts
        System.out.println("\n--- Updated Account Information ---");

        // Loop through the accounts array and call the displayInfo method for each account
        for (Account account : accounts) {
            account.displayInfo();
            System.out.println(); // Print newline for separation
        }

        // Display transaction history
        System.out.println("--- Transaction History ---");

        System.out.println("\nSavings Account Transactions:");
        for (String transaction : savingsAccount.getTransactionHistory()) {
            System.out.println(transaction);
        }

        System.out.println("\nChecking Account Transactions:");
        for (String transaction : checkingAccount.getTransactionHistory()) {
            System.out.println(transaction);
        }

        System.out.println("\n======= End of Banking System Demonstration =======");
    }
}
