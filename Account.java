import java.util.Scanner;

public class Account implements Comparable {
    private String name;
    private double balance;
    private static int numberOfAccounts = 0;
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
        System.out.println("Account Regestery (3 accounts per session)");
        System.out.println("1. Enter name & click 'Enter'");
        System.out.println("2. Enter balance & click 'Enter'");
        for (int i = 0; i < accounts.length; i++) {
            String name = sc.next();
            double balance = sc.nextDouble();
            accounts[i] = new Account(name, balance);
            numberOfAccounts++;
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
    public static int numberOfAccounts() {
        return numberOfAccounts;
    }
    @Override
    public int compareTo(Object o) {
        return (((Account) o).getName()).compareTo(this.getName());
    }
    public void sortAccounts(Account[] accounts) {
        for (int i = 0; i < accounts.length; i++) {
            for (int j = 0; j < accounts.length; j++) {
                int compared = accounts[i].getName().compareTo(accounts[j].getName());
                if (compared < 0) {
                    Account account = accounts[i];
                    accounts[i] = accounts[j];
                    accounts[j] = account;
                }
            }
        }
    }
    public String accountSearch(Account[] accounts) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name to view account: ");
        String name = sc.next();
        int lo = 0, hi = accounts.length-1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            for (int i = 0; i < accounts.length; i++) {
                int compared = name.compareTo(accounts[i].getName());
                if (compared == 0) {
                    return accounts[i].getAccount().toString();
                }
                else {
                    if (compared > 0) {
                        lo = mid + 1;
                    }
                    else {
                        hi = mid - 1;
                    }
                }
            }
        }
        return new String("No such name");
    }
}
