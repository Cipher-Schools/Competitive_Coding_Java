package projects.atm;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author amgarg
 */
public class Customer {


    public static void main(String[] args) {
        ATMManager atm =
                createBank();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Type 1 if  you are customer");
            System.out.println("Type 3 to exit");
            int choice = sc.nextInt();
            if (choice == 1) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please Enter your Card Number ");
                String cardNo = scanner.nextLine();
                System.out.println("Please Enter your Pin Number ");
                int pin = scanner.nextInt();
                atm.verifyCard(cardNo, pin);
            } else  {
                break;
            }
        }
    }

    private static ATMManager createBank() {
        BankManger bankManger = new BankManger();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Type 1 to add card");
            System.out.println("Type 2 to exit");
            int choice = sc.nextInt();
            if (choice == 2) {
                break;
            }
            bankManger.createCard();

        }

        return bankManger.atmManager;

    }
}
