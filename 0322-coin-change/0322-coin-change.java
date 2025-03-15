class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];

        Arrays.sort(coins);
        Arrays.fill(dp, 10001);
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < dp.length; j++) {
                if (j == coins[i]) {
                    dp[j] = 1;
                } else {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }

        return (dp[amount] == 10001) ? -1 : dp[amount];
    }
}