class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[][] dp = new int[coins.length][amount+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        int ans = minCoinRequire(coins, amount, coins.length - 1, dp);

        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

    public int minCoinRequire(int[] coins, int amount, int n, int[][] dp) {

        if(amount == 0){
            return 0;
        }
        // System.out.println("I am at: " + n + "th index with amount remaining as: " + amount);
        if (n == 0) {
            if (amount % coins[0] == 0) {
                return amount / coins[0];
            } else {
                return Integer.MAX_VALUE;
            }
        }

        if(dp[n][amount]!=-1){
            return dp[n][amount];
        }

        // Pick the coin
        int countPick = Integer.MAX_VALUE;
        if (coins[n] <= amount) {
            int subResult = minCoinRequire(coins, amount - coins[n], n, dp);
            if (subResult != Integer.MAX_VALUE) {
                countPick = 1 + subResult;
            }
        }

        // Not pick the coin
        int countNotPick = minCoinRequire(coins, amount, n - 1, dp);
        // System.out.println("Returning: " + Math.min(countPick, countNotPick));
        dp[n][amount] = Math.min(countPick, countNotPick);
        return dp[n][amount];
    }
}