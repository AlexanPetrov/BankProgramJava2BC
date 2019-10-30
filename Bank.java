public class Bank extends Object {
    private int numberOfAccounts;
    private Account[] accounts;
    public Bank() { // constructor to init. instance variables
        numberOfAccounts = 0; 
        accounts = new Account[3];
    }
    public Account[] getAccounts() { // accounts getter
        return accounts;
    }
    public void displayAccounts(Account[] accounts) { // accounts printer
        for (int i = 0; i < numberOfAccounts; i++) {
            System.out.println(accounts[i].accountToString());
        }
    }
    public int getNumberOfAccounts() { // number of accounts getter 
        return numberOfAccounts;
    }
    public void addAccount(String name, double amount) { // account adder
        if (numberOfAccounts == accounts.length) {
            Account[] tmp = new Account[accounts.length*2];
            for (int i = 0; i < numberOfAccounts; i++) {
                tmp[i] = accounts[i];
            }
            accounts = tmp;
        }
        accounts[numberOfAccounts++] = new Account(name, amount);
    }
    public void deleteAccount(String name, double amount) { // account remover
        int check = 0;
        for (int i = 0; i < numberOfAccounts; i++) {
            if (accounts[i].getName().equals(name) && (accounts[i].getBalance() == (amount))) {
                check = i;
            }
        }
        int j;
        for (j = check+1; j < numberOfAccounts; j++) {
            accounts[j-1] = accounts[j];
        }
        accounts[--j] = new Account("Deleted", 0.0);
    }
    public Account findAccount(String name) { // account finder
        int left = 0, right = numberOfAccounts-1, compared = 0;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            for (int i = 0; i < numberOfAccounts; i++) {
                compared = name.compareTo(accounts[i].getName());
                if (compared == 0) {
                    return accounts[i];
                }
                else {
                    if (compared > 0) {
                        left = middle + 1;
                    }
                    else {
                        right = middle - 1;
                    }
                }
            }
        }
        System.err.println("No such account");
        return null;
    }
    public void sortAccounts(Account[] accounts) { // accounts sorter
        for (int i = 0; i < numberOfAccounts; i++) {
            for (int j = 0; j < numberOfAccounts; j++) {
                int compared = accounts[i].getName().compareTo(accounts[j].getName());
                if (compared < 0) {
                    Account account = accounts[i];
                    accounts[i] = accounts[j];
                    accounts[j] = account;
                }
            }
        }
    }
    public double getTotalAccountsBalance(Account[] accounts) { // total accounts balance getter
        double sum = 0;
        for (int i = 0; i < numberOfAccounts; i++) {
            sum += accounts[i].getBalance();
        }
        return sum;
    }
}
