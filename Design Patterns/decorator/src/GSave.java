public class GSave implements BankAccountDecorator{
    private final SavingsAccount account;
    private final BankAccount bankAccount;

    public GSave(SavingsAccount account) {
        this.account = account;
        this.bankAccount = account;
    }

    @Override
    public String showAccountType() {
        return "GSave Transfer";
    }

    @Override
    public Double getInterestRate() {
        return 0.025;
    }

    @Override
    public Double getBalance() {
        return this.bankAccount.getBalance();
    }

    @Override
    public String showBenefits() {
        return this.bankAccount.showBenefits() + ", GSave transfer";
    }

    @Override
    public Double computeBalanceWithInterest() {
        return this.bankAccount.getBalance() + this.bankAccount.getBalance() * getInterestRate();
    }

    @Override
    public String showInfo() {
        return "Account Number: " + this.account.getAccountNumber() + "\n" +
                "Account Name: " + this.account.getAccountName() + "\n" +
                "Balance: " + this.bankAccount.getBalance();
    }

    @Override
    public void setBankAccount() { }
}
