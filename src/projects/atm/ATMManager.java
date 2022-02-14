package projects.atm;


import java.util.Scanner;

public class ATMManager {


    BankDatabase bankDatabase;

    private int [] denominations = {1, 200, 500, 2000};

    public boolean verifyCard(String cardNo, int pin) {
        if(bankDatabase.verifyCard(cardNo, pin)) {
            System.out.println("Details Verified");
            //take Amount from user
            int amount = takeAmountFromUser();

            MinNotes.minNotes(denominations, amount);
            return true;
        }
        System.out.println("Details not verified");
        return false;
    }

    private int takeAmountFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the amount you want to withdraw");

        int amount = scanner.nextInt();
        return amount;
    }

    public void setBankDatabase(BankDatabase bankDatabase) {
        this.bankDatabase = bankDatabase;
    }




}
