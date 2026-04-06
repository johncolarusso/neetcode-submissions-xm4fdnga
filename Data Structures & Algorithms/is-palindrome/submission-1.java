class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            while (!Character.isLetterOrDigit(s.charAt(l)) && l < r) {
                l++;
            }

            while (!Character.isLetterOrDigit(s.charAt(r)) && l < r) {
                r--;
            }

            char lc = Character.toLowerCase(s.charAt(l));
            char rc = Character.toLowerCase(s.charAt(r));
            if (lc != rc) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
