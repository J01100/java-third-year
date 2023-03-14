public class UpSave implements BankAccountDecorator {
    private BankAccount bankAccount;
    private SavingsAccount account;

    public UpSave(SavingsAccount account) {
        this.account = account;
    }

    @Override
    public void setBankAccount() {
        System.out.println("set upsave acc");
    }

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
        return this.account.getBalance();
    }

    @Override
    public String showBenefits() {
        return this.account.showBenefits() + ", With Insurance";
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
