class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        Map<String, List<String>> g = new HashMap<>();
        for (String s : strs) {
            char[] sorted = s.toCharArray();
            Arrays.sort(sorted);
            g.computeIfAbsent(new String(sorted), k -> new ArrayList<>()).add(s);
        }

        result = new ArrayList<>(g.values());

        return result;
    }
}
