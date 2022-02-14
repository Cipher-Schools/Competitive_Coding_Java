package projects.atm;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author amgarg
 */
public class BankDatabase {


    private HashMap<String, Integer> cardsInfo;

    BankDatabase() {
        cardsInfo = new HashMap<>();
    }

    public void addCardInDataBase() {
        //Take Input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter your Card Number to save in Data");
        String cardNo = scanner.nextLine();

        if(cardsInfo.containsKey(cardNo)) {
            System.out.println("Card number is already in system");
            return;
        }
        System.out.println("Please Enter the pin");
        Integer pin = scanner.nextInt();

        cardsInfo.put(cardNo, pin);
        System.out.println("Details Saved in Bank DataBase successfully");
    }

    public boolean verifyCard(String cardNo, int pin) {
        if(cardsInfo.containsKey(cardNo) && cardsInfo.get(cardNo).equals(pin)) {
            return true;
        }
        return false;
    }
}
