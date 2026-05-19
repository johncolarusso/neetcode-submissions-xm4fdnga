class Solution {
    // top down memoization
    public int coinChange(int[] coins, int amount) {
        var memo = new HashMap<Integer, Integer>();
        var result =  dfs(coins, amount, memo, amount+1);
        return result > amount ? -1 : result;
    }

    int dfs(int[] coins, int target, Map<Integer,Integer> memo, int noResult) {
        if (target < 0) {
            return noResult;
        }
        if (target == 0) {
            return 0;
        }
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        var bestResult = noResult;
        for (var coin : coins) {
            var result = dfs(coins, target - coin, memo, noResult);
            bestResult = Math.min(bestResult, result + 1);
        }
        memo.put(target, bestResult);
        return bestResult;
    }
}
