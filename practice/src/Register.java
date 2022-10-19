import java.io.IOException;
import java.util.Scanner;

public class Register {
    public static void register() throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter pin: ");
        String pin = sc.nextLine();

        System.out.print("Enter account number: ");
        String actNo = sc.nextLine();

        if (actNo.length() < 5) {
            System.out.println("Account number must have 5 or more digits");

            System.out.print("Enter account number: ");
            actNo = sc.nextLine();
        }

        System.out.print("Enter account name: ");
        String actName = sc.nextLine();

        System.out.print("Enter birth date: ");
        String birthday = sc.nextLine();

        System.out.print("Enter contact number: ");
        String contactNumber = sc.nextLine();

        System.out.print("Enter initial deposit: ");
        int initialDeposit = sc.nextInt();

        if (initialDeposit < 5000) {
            System.out.println("Initial deposit must be greater than 5000");

            System.out.print("Enter initial deposit: ");
            initialDeposit = sc.nextInt();
        }

        new AtmAccount(pin, actNo, actName, birthday, contactNumber, initialDeposit);
    }
}
