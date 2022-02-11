package dynamicprogramming;


public class NthFibNumber {


    public static int fibUsingRecursion(int n) {
        if (n < 2) {
            return n;
        }

        int smallOutput1 = fibUsingRecursion(n - 1);
        int smallOutput2 = fibUsingRecursion(n - 2);

        return smallOutput1 + smallOutput2;
    }

    public static double topDownFib(int n, double[] dpMemory) {

        if (n == 0 || n == 1) {
            dpMemory[n] = n;
            return n;
        }
        //Asking my past
        if (dpMemory[n] != -1) {
            return dpMemory[n];
        }

        double smallOutput1 = topDownFib(n - 1, dpMemory);
        double smallOutput2 = topDownFib(n - 2, dpMemory);

        dpMemory[n] = smallOutput1 + smallOutput2;
        return dpMemory[n];

    }

    public static double bottomUp(int n) {

        double[] dp = new double[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];

    }


    public static void main(String[] args) {

        double[] dp = new double[101];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }

        System.out.println(bottomUp(6));
    }
}
