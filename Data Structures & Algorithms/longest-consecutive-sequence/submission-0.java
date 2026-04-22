class Solution {

    public int longestConsecutive(int[] nums) {
        // 2, 20, 4, 10, 3, 4, 5
        // 
        // s: 2, 4, 3, 5, 10, 20
        int result = 0;
        Set<Integer> s = new HashSet<>();

        for (int n : nums) {
            s.add(n);
        }

        for (int n : nums) {
            if (!s.contains(n-1)) {
                int l = 1;
                while (s.contains(n+1)) {
                    l++;
                    n++;
                }
                result = Math.max(result, l);
            }
        }
        return result;
    }
    // public int longestConsecutive(int[] nums) {
    //     // 2, 20, 4, 10, 3, 4, 5


    //     Map<Integer, Integer> uf = new HashMap<>();
    //     Integer result = 0;
    //     for (int n : nums) {
    //         if(uf.containsKey(n-1)) {
    //             Integer cur = uf.get(n-1) + 1;
    //             Integer dup = uf.getOrDefault(n, 1);
    //             Integer max = Math.max(cur, dup);
    //             uf.put(n, max);
    //             result = Math.max(result, max);
    //         } else {
    //             uf.put(n, 1);
    //         }
    //     }
    //     return result;
    // }
}
