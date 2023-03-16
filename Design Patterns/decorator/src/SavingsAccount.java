// Concrete Component
public class SavingsAccount implements BankAccount{
    int accountNumber;
    double balance;
    String accountName;

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String showAccountType() {
       return "Savings Account";
    }

    @Override
    public Double getInterestRate() {
        return 0.01;
    }

    @Override
    public Double getBalance() {
        return this.balance;
    }

    @Override
    public String showBenefits() {
        return "Standard Savings Account";
    }

    @Override
    public Double computeBalanceWithInterest() {
        return this.getBalance()+this.getBalance()*this.getInterestRate();
    }

    @Override
    public String showInfo() {
        return String.format("""
                Account Number: %s 
                Account Name: %s 
                Account Balance: %s 
                """, this.getAccountNumber(), this.getAccountName(), this.getBalance());
    }
}
