class Solution {
    // 1D DP
    public int longestCommonSubsequence(String text1, String text2) {
        var dp = new int[text2.length() + 1];
        fillTable(text1, text2, dp);
        return dp[text2.length()];
    }

    void fillTable(String text1, String text2, int[] dp) {
        dp[0] = 0;
        for (int i = 1; i <= text1.length(); i++) {
            int diag = 0;
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    int temp = dp[j];
                    dp[j] = 1 + diag;
                    diag = temp;
                } else {
                    diag = dp[j];
                    dp[j] = Math.max(dp[j], dp[j-1]);
                }
            }
        }
    }
}
