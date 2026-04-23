class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> seen = new HashMap<>();
        Set<Character> mapped = new HashSet<>();

        if (s.length() != t.length()) {
            return false;
        }
        // badc
        // baba
        // b -> b, a -> a, d -> b
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (seen.containsKey(sc)) {
                if (!seen.get(sc).equals(tc)) {
                    return false;
                }
            } else {
                if (mapped.contains(tc)) {
                    return false;
                }
                seen.put(sc, tc);
                mapped.add(tc);
            }
        }
        return true;
    }
}