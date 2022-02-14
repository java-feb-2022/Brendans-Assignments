public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    public static int numberOfAccounts = 0;
    public static double totalMoneyInAccounts = 0;

    // Constructor
    public BankAccount() {
        this.checkingBalance = 0;
        this.savingsBalance = 0;
        numberOfAccounts++;
    }

    public static int accountCount() {
        return numberOfAccounts;
    }

    // Getters
    public double getChecking() {
        return this.checkingBalance;
    }
    public double getSavings() {
        return this.savingsBalance;
    }
    // Methods
    public void despositMoney(double amount,String account) {
        if(account.equals("checking")) {
            this.checkingBalance += amount;
        } else if(account.equals("savings")) {
            this.savingsBalance += amount;
        }
        totalMoneyInAccounts += amount;
    }
    public void withdrawMoney(double amount,String account) {
        boolean success = false;
        if(account.equals("checking")) {
            if(this.checkingBalance >= amount) {
                success = true;
                this.checkingBalance -= amount;
            }
        } else if(account.equals("savings")) {
            if(this.savingsBalance >= amount) {
                success = true;
                this.savingsBalance -= amount;
            }
        } if(success) {
            totalMoneyInAccounts -= amount;
        } else {
            System.out.println("Insufficent Funds.");
        }
    }
    public void displayAccountBalance() {
        System.out.printf("Checking: %.2f, Savings: %.2f \n",this.checkingBalance,this.savingsBalance);
    }


}
