class Solution {
    public int coinChange(int[] coins, int amount) {
        var dp = buildTable(coins, amount);
        return dp[amount] > amount ? -1 : dp[amount];
    }

    int[] buildTable(int[] coins, int amount) {
        var result = new int[amount + 1];
        Arrays.fill(result, amount+1);
        result[0] = 0;
        for (int i = 1; i <= amount; i++) {
            var best = bestCoinChoice(coins, result, i);
            result[i] = best;
        }
        return result;
    }

    int bestCoinChoice(int[] coins, int[] dp, int i) {
        var result = dp[i];
        for (var coin : coins) {
            if (i - coin >= 0)
            result = Math.min(result, dp[i-coin] + 1);
        }
        return result;
    }
}
