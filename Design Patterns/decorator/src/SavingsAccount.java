public class SavingsAccount implements BankAccount{
    String accountNumber, accountName;
    Double balance;

    @Override
    public String showAccountType() {
        return "Savings Account";
    }

    @Override
    public Double getInterestRate() {
        return .01;
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
        return this.balance+this.balance * getInterestRate();
    }

    @Override
    public String showInfo() {
        return "Account Number: " + this.accountNumber + "\n" +
                "Account Name: " + this.accountName + "\n" +
                "Balance: " + this.balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
