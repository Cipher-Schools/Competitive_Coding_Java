package dynamicprogramming;


import java.util.HashMap;

public class KnapsackProblem {


    public static int maxRunsUsingTabulation(int[] balls, int[] runs, int givenBalls, int n) {

        int dpMemory[][] = new int[n + 1][givenBalls + 1];

        for (int i = 1; i < dpMemory.length; i++) {
            for (int j = 1; j < dpMemory[0].length; j++) {

                //
                if (j >= balls[i - 1]) {
                    int pickPlayer = 0;
                    int don_t_PickPlayer = 0;

                    int remainingBalls = j - balls[i - 1];

                    pickPlayer = runs[i - 1] + dpMemory[i - 1][remainingBalls];
                    don_t_PickPlayer = dpMemory[i - 1][j];

                    dpMemory[i][j] = Math.max(pickPlayer, don_t_PickPlayer);

                } else {
                    //don't pick the player
                    int don_t_PickPlayer = dpMemory[i - 1][j];

                    dpMemory[i][j] = don_t_PickPlayer;
                }
            }
        }

        for (int i = 0; i < dpMemory.length; i++) {
            for (int j = 0; j < dpMemory[i].length; j++) {
                System.out.print(dpMemory[i][j] + "  ");
            }
            System.out.println();
        }

        return dpMemory[n][givenBalls];
    }


    public static int maxRuns(int[] balls, int[] runs, int givenBalls, int n,
                              HashMap<String, Integer> dpMemory) {

        if (givenBalls <= 0) {
            return Integer.MIN_VALUE;
        }
        if (n == 0 || givenBalls == 0) {
            return 0;
        }

        String key = n + "_" + givenBalls;

        if (!dpMemory.containsKey(key)) {

            //pick player
            int option1 = runs[n] + maxRuns(balls, runs, givenBalls - balls[n], n - 1, dpMemory);

            //Don't pick player
            int option2 = maxRuns(balls, runs, givenBalls, n - 1, dpMemory);
            int ans = Math.max(option1, option2);
            dpMemory.put(key, ans);


        }


        return dpMemory.get(key);


    }

    public static void main(String[] args) {

        int balls[] = {2, 6, 1, 3, 4};
        int runs[] = {16, 18, 6, 45, 24};

        int totalBalls = 6;
        HashMap<String, Integer> dpMemory = new HashMap<>();

        System.out.println(maxRunsUsingTabulation(balls, runs, totalBalls, balls.length));
    }
}
