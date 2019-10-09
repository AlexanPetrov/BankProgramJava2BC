import java.util.Scanner;

public class Account {
    private String name;
    private double balance;
    Account() {}
    Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getBalance() {
        return this.balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public String getAccount() {
        return "Name: " + getName() + "\t" + "Balance: " + getBalance();
    }
    public void setAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }
    public Account[] populateAccounts() {
        Scanner sc = new Scanner(System.in);
        Account[] accounts = new Account[3];
        System.out.println("1. Enter name & click 'Enter'");
        System.out.println("2. Enter balance & click 'Enter'");
        for (int i = 0; i < accounts.length; i++) {
            String name = sc.next();
            double balance = sc.nextDouble();
            accounts[i] = new Account(name, balance);
        }
        return accounts;
    }
    public static void displayAccounts(Account[] accounts) {
        for (int i = 0; i < accounts.length; i++) {
            System.out.println(accounts[i].getAccount());
        }
    }
    public static double totalAccountsBalance(Account[] accounts) {
        double sum = 0;
        for (int i = 0; i < accounts.length; i++) {
            sum += accounts[i].getBalance();
        }
        return sum;
    }
}
