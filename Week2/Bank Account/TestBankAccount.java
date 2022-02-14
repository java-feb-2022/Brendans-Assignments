public class TestBankAccount {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount();

        acc.despositMoney(400.99, "checking");
        acc.despositMoney(16500.99, "savings");
        acc.displayAccountBalance();

        System.out.println(BankAccount.totalMoneyInAccounts);

        acc.withdrawMoney(400,"checking");
        acc.withdrawMoney(5000,"savings");
        acc.displayAccountBalance();

        System.out.println(BankAccount.totalMoneyInAccounts);

        BankAccount acc2 = new BankAccount();

        acc2.despositMoney(500.50,"checking");
        acc2.despositMoney(1000,"savings");
        acc2.displayAccountBalance();

        System.out.println(BankAccount.totalMoneyInAccounts);
        System.out.println(BankAccount.numberOfAccounts);
    }
}
