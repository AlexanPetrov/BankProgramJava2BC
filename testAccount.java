public class testAccount {
    public static void main(String[] args) {
        Account account = new Account();
        Account[] accounts = account.populateAccounts();
        account.displayAccounts(accounts);
        System.out.println(account.totalAccountsBalance(accounts));
    }
}
