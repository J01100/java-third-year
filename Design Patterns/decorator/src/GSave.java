public class GSave implements BankAccountDecorator {
    private final SavingsAccount account;
    private BankAccount bankAccount;

    public GSave(SavingsAccount account) {
        this.account = account;
    }

    @Override
    public void setBankAccount() {
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
        return this.account.getBalance();
    }

    @Override
    public String showBenefits() {
        return this.account.showBenefits() + ", GSave transfer";
    }

    @Override
    public Double computeBalanceWithInterest() {
        return this.account.getBalance() + this.account.getBalance() * getInterestRate();
    }

    @Override
    public String showInfo() {
        return "Account Number: " + this.account.getAccountNumber() + "\n" +
                "Account Name: " + this.account.getAccountName() + "\n" +
                "Balance: " + this.account.getBalance();
    }
}
