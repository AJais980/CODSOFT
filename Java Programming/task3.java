import java.util.*;

class ATM extends userBank {
    double balance;

    ATM(double balance) {
        super(balance);
        this.balance = balance;
    }

    void checkBalance() {
        System.out.println("Available Balance: " + this.balance);
    }

    void withdraw(double amount) {
        if (amount > this.balance)
            System.out.println("Withdraw balance can't be more than available balance.");
        else {
            this.balance -= amount;
            super.setBalance(this.balance);
            System.out.println("Successfully Withdrew Rs. " + amount);
            checkBalance();
        }
    }

    void deposit(double amount) {
        this.balance += amount;
        super.setBalance(this.balance);
        System.out.println("Successfully Deposited Rs. " + amount);
        checkBalance();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("<===================================>");
        System.out.println("\t  Welcome To ATM");
        System.out.println("<===================================>");
        System.out.println("\tAvailable Options:");
        System.out.println("\t  1 -> Withdraw.\n\t  2 -> Deposit.\n\t  3 -> Check Balance.\n\t  0 -> Exit.");
        System.out.println("<===================================>");
        System.out.print("Enter initial balance: Rs. ");
        double amount = sc.nextDouble();
        ATM ob = new ATM(amount);
        boolean flag = true;
        while (flag) {
            System.out.print("Enter Choice: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter amount to withdraw: Rs. ");
                    amount = sc.nextDouble();
                    ob.withdraw(amount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: Rs. ");
                    amount = sc.nextDouble();
                    ob.deposit(amount);
                    break;
                case 3:
                    ob.checkBalance();
                    break;
                case 0:
                    System.out.println("Exiting the ATM.\nThank You.");
                    flag = false;
                    break;
                default:
                    System.out.println("No Matching Option Found.\nTry Again.");
                    break;
            }
            System.out.println("<===================================>");
        }
        sc.close();
    }
}

class userBank {
    double balance;

    userBank(double balance) {
        this.balance = balance;
    }

    double getBalance() {
        return this.balance;
    }

    void setBalance(double balance) {
        this.balance = balance;
    }
}