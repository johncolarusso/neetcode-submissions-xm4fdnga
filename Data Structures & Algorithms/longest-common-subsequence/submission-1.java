class Solution {
    // 2D DP Bottom right -> top left
    public int longestCommonSubsequence(String text1, String text2) {
        var dp = new int[text1.length() + 1][text2.length() + 1];
        fillTable(text1, text2, dp);
        return dp[0][0];
    }

    void fillTable(String text1, String text2, int[][] dp) {
        for (int i = text1.length() - 1; i >= 0; i--) {
            for (int j = text2.length() - 1; j >= 0; j--) {
                dp[i][j] = computeCell(text1, text2, dp, i, j);
            }
        }
    }

    int computeCell(String s1, String s2, int[][] dp, int i, int j) {
        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i+1][j+1] + 1;
        }
        return Math.max(dp[i+1][j], dp[i][j+1]);
    }
}
