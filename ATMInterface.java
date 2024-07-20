import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double InitialBalance) {
        this.balance = InitialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Depossit of $" + amount + "successful.Current balance:$" + balance);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawl of $" + amount + "successful.Current balance: $" + balance);
        } else {
            System.out.println("Invalid withdrawl amount or insufficient balance.");
        }
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayMenu() {
        System.out.println("ATM Menu");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void processMenuSelection(int selection, Scanner scanner) {
        switch (selection) {
            case 1:
                System.out.println("Balance: $" + bankAccount.getBalance());
                break;
            case 2:
                System.out.println("Enter amount to deposit: $");
                double amount = Double.parseDouble(scanner.nextLine());
                bankAccount.deposit(amount);
                break;
            case 3:
                System.out.println("Enter amount to withdraw: $");
                amount = Double.parseDouble(scanner.nextLine());
                bankAccount.withdraw(amount);
                break;
            case 4:
                System.out.println("Thank you for using the ATM.");
                scanner.close();
                System.exit(0);
            default:
                System.out.println("Invalid selection.");
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double initialBalance = scanner.nextDouble();
        BankAccount bankAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(bankAccount);
        while (true) {
            atm.displayMenu();
            System.out.println("Select option:");
            int selection = scanner.nextInt();
            atm.processMenuSelection(selection, scanner);
        }
    }
}