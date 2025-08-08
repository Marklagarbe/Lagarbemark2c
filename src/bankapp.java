import java.util.Scanner;

public class bankapp {
    private final String accountNumber;
    private final String accountHolder;
    private double balance;


    public bankapp(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
    }

    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Deposited: ₱" + amount);
        } else {
            System.out.println("❌ Invalid deposit amount.");
        }
    }


    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("✅ Withdrew: ₱" + amount);
        } else {
            System.out.println("❌ Insufficient funds or invalid amount.");
        }
    }


    public void displayInfo() {
        System.out.println("\n📄 Account Info:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: ₱" + balance);
    }


    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("🏦 Welcome to the Bank App");
            System.out.print("Enter Account Number: ");
            String accNumber = scanner.nextLine();
            
            System.out.print("Enter Account Holder Name: ");
            String accHolder = scanner.nextLine();
            
            bankapp account = new bankapp(accNumber, accHolder);
            
            int option;
            do {
                System.out.println("\n📋 Menu:");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. View Account Info");
                System.out.println("0. Exit");
                System.out.print("Choose an option: ");
                option = scanner.nextInt();
                
                switch (option) {
                    case 1:
                        System.out.print("Enter deposit amount: ₱");
                        double deposit = scanner.nextDouble();
                        account.deposit(deposit);
                        break;
                    case 2:
                        System.out.print("Enter withdrawal amount: ₱");
                        double withdraw = scanner.nextDouble();
                        account.withdraw(withdraw);
                        break;
                    case 3:
                        account.displayInfo();
                        break;
                    case 0:
                        System.out.println("👋 Thank you for using the Bank App!");
                        break;
                    default:
                        System.out.println("❌ Invalid option. Please try again.");
                }
            } while (option != 0);
        }
    }
}
