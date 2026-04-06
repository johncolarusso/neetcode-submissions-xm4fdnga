class Solution {
    public String minWindow(String s, String t) {
        int l = 0;
        int r = 0;

        Map<Character, Integer> have = new HashMap<>();
        int haveCount = 0;
        Map<Character, Integer> need = new HashMap<>();
        int needCount = 0;

        int resultL = 0;
        int resultR = 0;
        int resultSize = Integer.MAX_VALUE;

        for (char charT : t.toCharArray()) {
            if (need.containsKey(charT)) {
                need.put(charT, need.get(charT) + 1);    
            } else {
                need.put(charT, 1);
                needCount++;
            }
        }

        while (r < s.length()) {
            char rChar = s.charAt(r);

            have.put(rChar, have.getOrDefault(rChar, 0) + 1);
            if (need.containsKey(rChar) && need.get(rChar).equals(have.get(rChar))) {
                haveCount++;
            }

            while (haveCount == needCount) {
                if ((r - l + 1) < resultSize) {
                    resultL = l;
                    resultR = r;
                    resultSize = r - l + 1;
                }
                
                char lChar = s.charAt(l);

                have.put(lChar, have.get(lChar) - 1);
                if (need.containsKey(lChar) && have.get(lChar) < need.get(lChar)) {
                    haveCount--;
                }
                l++;
            }
            
            r++;
        }

        return resultSize == Integer.MAX_VALUE ? "" : s.substring(resultL, resultR + 1);
    }
}
