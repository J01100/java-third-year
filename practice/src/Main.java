import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        boolean running = true;

        try {
            while (running) {
                FileReader fr = new FileReader("/run/media/axojolotl/3A75-1714/pin.code");
                BufferedReader br = new BufferedReader(fr);
                String pinHash = br.readLine();
                Scanner input = new Scanner(System.in);

                System.out.print("ATM Card is inserted.\nPlease enter pin: ");

                String pin = input.nextLine();
                pin = String.valueOf(pin.hashCode());

                if (pinHash != null && pinHash.equals(pin)){
                    for (AtmAccount acc: AtmAccount.listAccounts) {
                        if (acc.pinHash.toString().equals(pin)){
                            System.out.println("\n\nWelcome! " + acc.actName );
                            boolean loggedIn = true;
                            while (loggedIn) {
                                System.out.println("""
                                        \n-----MENU-----
                                        1. Balance Inquiry
                                        2. Withdraw
                                        3. Deposit
                                        4. Fund Transfer
                                        5. Change PIN Code
                                        6. Exit""");
                                System.out.print("Choose option: ");
                                String choice = input.nextLine();

                                switch (choice) {
                                    case "1" -> acc.balanceInquiry();
                                    case "2" -> {
                                        System.out.print("Enter amount to withdraw: ");
                                        acc.withdraw(Integer.parseInt(input.nextLine()));
                                    }
                                    case "3" -> {
                                        System.out.print("Enter amount to deposit: ");
                                        acc.deposit(Integer.parseInt(input.nextLine()));
                                    }
                                    case "4" -> {
                                        System.out.print("Enter account number: ");
                                        String actNo = input.nextLine();
                                        System.out.print("Enter amount to transfer: ");
                                        Integer amount = Integer.parseInt(input.nextLine());
                                        acc.transferFunds(actNo, amount);
                                    }
                                    case "5" -> {
                                        System.out.print("Enter new pin: ");
                                        acc.changePin(input.nextLine());
                                    }
                                    default -> loggedIn = false;
                                }
                            }
                        }
                    }
                } else {
                    System.out.println("Incorrect pin!");

                    System.out.print("Would you like to register [y/n]? ");

                    if (input.nextLine().equalsIgnoreCase("y")){
                        Register.register();
                    } else {
                        continue;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Please insert card");
        }
    }
}