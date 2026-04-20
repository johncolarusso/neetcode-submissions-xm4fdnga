class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int[] freq = new int[26];
        int result = 0;

        while (r < s.length()) {
            freq[s.charAt(r) - 'A']++;

            int maxFreq = max(freq);
            int windowSize = (r - l + 1);

            if (windowSize - maxFreq > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }
             
            result = Math.max(result, r - l + 1);

            r++;
        }

        return result;
    }

    private int max(int[] freq) {
        int maxFreq = 0;
        for (int i = 0; i < 26; i++) {
            maxFreq = Math.max(freq[i], maxFreq);
        }
        return maxFreq;
    }
}
