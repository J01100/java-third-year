// Concrete Decorator
public class UpSave implements BankAccountDecorator{
     BankAccount bankAccount;
    SavingsAccount savingsAccount;

    public UpSave(SavingsAccount account) {
        this.bankAccount = account;
        this.savingsAccount = account;
    }

    @Override
    public String showAccountType() {
        return "UpSave";
    }

    @Override
    public Double getInterestRate() {
        return 0.04;
    }

    @Override
    public Double getBalance() {
        return this.bankAccount.getBalance();
    }

    @Override
    public String showBenefits() {
        return this.bankAccount.showBenefits() + ", With Insurance";
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
            """, this.savingsAccount.getAccountNumber(), this.savingsAccount.getAccountName(), this.getBalance());
    }

    @Override
    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
}
