class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] cache = new int[amount+1];
        cache[0] = 0;
        for (int i = 1; i <= amount; i++) {
            List<Integer> choices = new ArrayList<>();
            int localTarget = i;
            for (int coin : coins) {
                int difference = localTarget - coin;
                if (difference >= 0 && cache[difference] != -1) {
                    choices.add(1 + cache[difference]);
                }
            }

            if (choices.isEmpty()) {
                cache[i] = -1;
                continue;
            }

            int dpResult = choices.stream()
                .mapToInt(v -> v)
                .min()
                .orElseThrow();

            cache[i] = dpResult;
        }

        return amount > 0 ? cache[amount] : 0;
    }
}
