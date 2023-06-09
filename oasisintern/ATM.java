
import java.util.Scanner;

//USERID = Srikar
//PIN = 2003

class Transaction 

   {
    private String type;
    private double amount;

    public Transaction(String type, double amount) 
    {
        this.type = type;
        this.amount = amount;
    }

   
    public String toString() 
    {
        return "Transaction" +"type='" + type + '\'' +", amount=" + amount;
    }
}

class Account
    {
    private String accountNumber;
    private double balance;
    private Transaction[] transactions;
    private int transactionCount;

    public Account(String accountNumber) 
    {
        this.accountNumber = accountNumber;
        this.balance = 0.0  ;
        this.transactions = new Transaction[10];
        this.transactionCount = 0;
    }

    public void deposit(double amount)
    {
        balance += amount;
        transactions[transactionCount] = new Transaction("Deposit", amount);
        transactionCount++;
        System.out.println("Deposit of " + amount + " successful.");
    }

    public void withdraw(double amount) 
        {
        if (balance >= amount) 
        {
            balance -= amount;
            transactions[transactionCount] = new Transaction("Withdrawal", amount);
            transactionCount++;
            System.out.println("Withdrawal of " + amount + " successful.");
        } else 
        {
            System.out.println("Insufficient funds.");
        }
    }

    public void transfer(Account destination, double amount)
       {
        if (balance >= amount) 
        {
            balance -= amount;
            transactions[transactionCount] = new Transaction("Transfer to " + destination.accountNumber, amount);
            transactionCount++;
            destination.balance += amount;
            destination.transactions[destination.transactionCount] = new Transaction("Transfer from " + accountNumber, amount);
            destination.transactionCount++;
            System.out.println("Transfer of " + amount + " to account " + destination.accountNumber + " successful.");
        } else 
        {
            System.out.println("Insufficient funds.");
        }
    }

    public double getBalance() 
   {
        return balance;
    }

    public Transaction[] getTransactions() 
   {
        return transactions;
    }

    public int getTransactionCount() 
   {
        return transactionCount;
    }
}

public class ATM
     {
    public static void main(String[] args) 
     {
        Scanner scanner = new Scanner(System.in);

        // User ID and PIN verification
        //USERID = Srikar
        //PIN = 2003
        System.out.print("Enter user ID: ");
        String userID = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        if (verifyUser(userID, pin)) 
        {
            System.out.println("\nUser verified");

            System.out.print("Enter account number: ");
            String accountNumber = scanner.nextLine();

            Account account = new Account(accountNumber);

            boolean quit = false;
            while (!quit)
          {
                System.out.println("\nATM Menu:");
                System.out.println("1. View Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Transfer");
                System.out.println("5. Transaction History");
                System.out.println("6. Quit");

                System.out.print("Enter option (1-6): ");
                int option = scanner.nextInt();

                switch (option)
          {
                    case 1:
                        System.out.println("Current Balance: " + account.getBalance());
                        break;

                    case 2:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        break;

                    case 3:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawalAmount = scanner.nextDouble();
                        account.withdraw(withdrawalAmount);
                        break;

                    case 4:
                        System.out.print("Enter recipient's account number: ");
                        String recipientAccountNumber = scanner.next();
                        System.out.print("Enter transfer amount: ");
                        double transferAmount = scanner.nextDouble();
                        Account recipientAccount = new Account(recipientAccountNumber);
                        account.transfer(recipientAccount, transferAmount);
                        break;

                    case 5:
                        System.out.println("\nTransaction History:");
                        Transaction[] transactions = account.getTransactions();
                        int transactionCount = account.getTransactionCount();
                        for (int i = 0; i < transactionCount; i++) 
                        {
                            System.out.println(transactions[i]);
                        }
                        break;

                    case 6:
                        quit = true;
                        break;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }

            System.out.println("\nYour operations are successfull!!,please visit again :)");
        } 
            else
        {
            System.out.println("Invalid user ID or PIN. Exiting...");
        }
    }

    private static boolean verifyUser(String userID, String pin)
   {
        return userID.equals("Srikar") && pin.equals("2003");
    }
}