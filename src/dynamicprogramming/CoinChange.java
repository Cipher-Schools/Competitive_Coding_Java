package dynamicprogramming;

import java.util.Arrays;

/**
 * @author amgarg
 */
public class CoinChange {

    public static int minCoinsUsingRecursion(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        }
        int finalAns = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int currentCoinValue = coins[i];

            //Let's use this coin
            int remainingAmount = amount - currentCoinValue;

            if (remainingAmount >= 0) {
                int smallAmountAns = minCoinsUsingRecursion(coins, remainingAmount);

                finalAns = Math.min(smallAmountAns + 1, finalAns);
            }
        }
        return finalAns;
    }

    static int[] dpMemory;
    public static int minCoinsUsingMemo(int[] coins, int amount, int[] dpMemory) {

        if (amount == 0) {
            return dpMemory[amount];
        }

        //Asking my past
        if (dpMemory[amount] != -1) {
            return dpMemory[amount];
        }
        int finalAns = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int currentCoinValue = coins[i];

            //Let's use this coin
            int remainingAmount = amount - currentCoinValue;

            if (remainingAmount >= 0) {
                int smallAmountAns = minCoinsUsingMemo(coins, remainingAmount, dpMemory);

                finalAns = Math.min(smallAmountAns + 1, finalAns);
            }
        }
        dpMemory[amount] = finalAns;
        return  dpMemory[amount];
    }

    public static void main(String[] args) {

        int[] coins = {1, 15, 25};
        int amount = 10;

        dpMemory = new int[amount + 1];
        Arrays.fill(dpMemory, -1);

        System.out.println(minCoinsUsingMemo(coins, amount, dpMemory));

    }
}
