package projects.atm;


public class MinNotes {

    public static void minNotes(int[] denominations, int amount) {

        if (amount == 0) {
            return;
        }

        int dpMemory[][] = new int[amount + 1][denominations.length + 1];

        for (int i = 0; i <= amount; i++) {

            dpMemory[i][0] = i;
        }


        for (int i = 1; i <= amount; i++) {
            for (int j = 1; j <= denominations.length; j++) {

                if (denominations[j - 1] <= i) {
                    int remainingAmount = i - denominations[j - 1]; //0
                    int pastNotes = dpMemory[remainingAmount][j];

                    int considerCurrentCoin = 1 + pastNotes;
                    int notConsideringCurrentCoin = dpMemory[i][j - 1];

                    int minNotes = Math.min(considerCurrentCoin, notConsideringCurrentCoin);

                    dpMemory[i][j] = minNotes;
                } else {
                    dpMemory[i][j] = dpMemory[i][j - 1];
                }
            }
        }



        System.out.println("Show Notes");
        showNotesUsed(dpMemory, denominations);

    }


    private static void showNotesUsed(int[][] dpMemory, int[] denominations) {

        int i = dpMemory.length - 1;
        int j = dpMemory[0].length - 1;
        while (j > 0 && i > 0) {
            if (dpMemory[i][j] == dpMemory[i][j - 1]) {
                j = j - 1;
            }
            else{
                System.out.println("Picked Note  : " + denominations[j - 1]);
                i = i - denominations[j - 1]; //remainingAmount
            }
        }

        while (i > 0) {
            System.out.println("Picked Note  :"  + denominations[0]);
            i = i - 1;
        }
    }
}
