public class UpSave implements BankAccountDecorator {
    private final BankAccount bankAccount;
    private final SavingsAccount account;

    public UpSave(SavingsAccount account) {
        this.account = account;
        this.bankAccount = account;
    }

    @Override
    public void setBankAccount() { }

    @Override
    public String showAccountType() {
        return "UpSave";
    }

    @Override
    public Double getInterestRate() {
        return .04;
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
        return this.bankAccount.getBalance() + this.bankAccount.getBalance() * getInterestRate();
    }

    @Override
    public String showInfo() {
        return "Account Number: " + this.account.getAccountNumber() + "\n" +
                "Account Name: " + this.account.getAccountName() + "\n" +
                "Balance: " + this.account.getBalance();
    }
}
