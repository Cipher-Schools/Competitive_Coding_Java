package dynamicprogramming;


public class BurstBalloons {



    public int maxCoins(int[] nums) {

        if(nums.length == 0) {
            return 0;
        }
        Integer [][] dp = new Integer[nums.length][nums.length];
        return helper(nums, 0, nums.length - 1, dp);
    }


    public static int helper(int[] nums, int start, int end, Integer[][] dp) {

        if(start > end) {
            return 0;
        }

        if(dp[start][end] != null) {
            return dp[start][end];
        }
        int maxCollection = 0;

        for(int i =  start; i <= end; i++) {
            int left = helper(nums, start, i -1, dp);
            int right = helper(nums, i + 1, end, dp);

            int profit = (start - 1 < 0 ? 1 : nums[start - 1]) * nums[i] * (end + 1 >= nums.length ? 1 : nums[end + 1])
                    + left + right;

            maxCollection = Math.max(maxCollection, profit);
        }
        dp[start][end] = maxCollection;
        return maxCollection;
    }
}
