public class Account extends Bank {
    private String name;
    private double balance;
    Account() { // constructor to init. instance variables
        this(" ", 0.0);
    }
    Account(String name, double balance) { // constructor to update instance variables
        this.name = name;
        this.balance = balance;
    }
    public String getName() { // name getter
        return this.name;
    }
    public void setName(String name) { // name setter
        this.name = name;
    }
    public double getBalance() { // balance getter
        return this.balance;
    }
    public void setBalance(double balance) { // balance setter
        this.balance = balance;
    }
    public String accountToString() { // account toString converter
        return "Name: " + getName() + "\t" + "Balance: " + getBalance();
    }
    public void displayAccount(Account account) { // account printer
        System.out.println(account.accountToString());
    }
    public void withdraw(Bank bank, String name, double amount) { // withdrawal method
        int n = 0;
        double total = 0.0;
        Account[] accounts = bank.getAccounts();
        for (int i = 0; i < bank.getNumberOfAccounts(); i++) {
            if (accounts[i].getName().equals(name)) {
                n = i;
            }
        }
        if (amount > accounts[n].getBalance()) {
            System.err.println("Not enough funds");
            System.exit(1);
        }
        total = accounts[n].getBalance() - amount;
        Account account = new Account(name, total);
        accounts[n] = account;
    }
    public void deposit(Bank bank, String name, double amount) { // deposit method
        int n = 0;
        double total = 0.0;
        Account[] accounts = bank.getAccounts();
        for (int i = 0; i < bank.getNumberOfAccounts(); i++) {
            if (accounts[i].getName().equals(name)) {
                n = i;
            }
        }
        total = accounts[n].getBalance() + amount;
        Account account = new Account(name, total);
        accounts[n] = account;
    }
}
