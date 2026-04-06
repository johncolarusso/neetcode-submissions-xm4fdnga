class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();

        int l = 0;
        int r = 0;
        int result = 0;

        while (l < s.length() && r < s.length()) {

            while (seen.contains(s.charAt(r)) && l < r) {
                seen.remove(s.charAt(l));
                l++;
            }

            result = Math.max(result, r - l + 1);
            seen.add(s.charAt(r));
            r++;
        }
        return result;
    }
}
