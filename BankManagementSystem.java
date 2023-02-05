import java.util.Scanner;

class Bank {
    private String name;
    private long accountNumber;
    private double balance;

    public Bank(String name, long accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. Your updated balance is: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Your updated balance is: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public double checkBalance() {
        return balance;
    }
}

class BankManagementSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scan.nextLine();
        System.out.print("Enter your account number: ");
        long accountNumber = scan.nextLong();
        System.out.print("Enter your initial balance: ");
        double balance = scan.nextDouble();

        Bank b = new Bank(name, accountNumber, balance);

        int choice;
        do {
            System.out.println("1. Check balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your balance is: " + b.checkBalance());
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    b.deposit(scan.nextDouble());
                    break;
                case 3:
                    System.out.print("Enter the amount to withdraw: ");
                    b.withdraw(scan.nextDouble());
                    break;
                case 4:
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);
    }
}
