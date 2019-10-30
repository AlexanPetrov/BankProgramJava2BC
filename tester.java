public class tester {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Account account = new Account();
        
        bank.addAccount("Tom", 100);
        bank.addAccount("Jim", 200); 
        bank.addAccount("Alex", 500);   
        bank.addAccount("Bill", 800); 

        System.out.println("Number of bank accounts: " + bank.getNumberOfAccounts()); 
        System.out.println("Total bank balance: " + bank.getTotalAccountsBalance(
                                                    bank.getAccounts())); 
        System.out.println("Accounts in original order: ");
        bank.displayAccounts(bank.getAccounts()); 
                        
        System.out.println("Sorted accounts: ");
        bank.sortAccounts(bank.getAccounts()); 
        bank.displayAccounts(bank.getAccounts());
        
        System.out.println("Find function: ");
        account.displayAccount(bank.findAccount("Jim")); 
        
        account.withdraw(bank, "Jim", 100);
        System.out.println("Updated accounts after withdrawal: ");
        bank.displayAccounts(bank.getAccounts()); 

        account.deposit(bank, "Jim", 900);
        System.out.println("Updated accounts after deposit: ");
        bank.displayAccounts(bank.getAccounts()); 

        bank.deleteAccount("Jim", 1000);
        System.out.println("Updated accounts after delition: ");
        bank.displayAccounts(bank.getAccounts());

        System.out.println("Sorted accounts: ");
        bank.sortAccounts(bank.getAccounts()); 
        bank.displayAccounts(bank.getAccounts());
    }
}
