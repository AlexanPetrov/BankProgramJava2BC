public class testAccount {
    public static void main(String[] args) {
        Account account = new Account();
        Account[] accounts = account.populateAccounts();
        
        System.out.println("Original Order Accounts: ");
        account.displayAccounts(accounts);
        System.out.println();

        account.sortAccounts(accounts);

        System.out.println("Sorted Accounts: ");
        account.displayAccounts(accounts);
        System.out.println();

        System.out.println("Total Number of Accounts: " + Account.numberOfAccounts());

        System.out.println("Total Accounts' Balance: " + Account.totalAccountsBalance(accounts));

        System.out.println(account.accountSearch(accounts));
    }
}
