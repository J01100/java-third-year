import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class AtmAccount {

    public static List<AtmAccount> listAccounts = new ArrayList<>();
    String actNumber, actName, birthday, contactNumber;
    Integer bal, initialDeposit, pinHash;

    public AtmAccount(String pinHash, String actNumber, String actName, String birthday,
                      String contactNumber, Integer initialDeposit) {
        this.pinHash = pinHash.hashCode();
        this.actNumber = actNumber;
        this.actName = actName;
        this.birthday = birthday;
        this.contactNumber = contactNumber;
        this.initialDeposit = initialDeposit;
        this.bal = initialDeposit;

        try {
            FileWriter f = new FileWriter("/run/media/axojolotl/3A75-1714/pin.code");
            f.write(this.pinHash.toString());
            f.flush();
        } catch (Exception e) {
            System.out.print("");
        }

        listAccounts.add(this);
    }

    public void balanceInquiry() {
        System.out.println("Your balance is " + bal);
    }

    public void withdraw(Integer amount) {
        if (amount <= this.bal) {
            this.bal -= amount;
            System.out.println("You withdrew " + amount);
            System.out.println("Your new balance is " + this.bal);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void deposit(Integer amount) {
        this.bal += amount;
        System.out.println("Your new balance is " + this.bal);
    }

    public void transferFunds(String actNumber, Integer amount){

        if (amount <= this.bal) {
            for (AtmAccount atmAccount : AtmAccount.listAccounts){
                if (actNumber.equals(atmAccount.actNumber)){
                    atmAccount.bal += amount;
                    System.out.println("Fund transfer successful. Amount: " + amount);
                    return;
                } else {
                    System.out.println("Account number does not exist.");
                }
            }
        } else {
            System.out.println("Insufficient balance");
        }

    }

    public void changePin(String newPin) {
        this.pinHash = newPin.hashCode();
    }

}
