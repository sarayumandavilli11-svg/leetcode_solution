class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        java.util.HashSet<String> prefixes = new java.util.HashSet<>();

        for (int num : arr1) {
            String s = String.valueOf(num);
            for (int i = 1; i <= s.length(); i++) {
                prefixes.add(s.substring(0, i));
            }
        }

        int maxLen = 0;

        for (int num : arr2) {
            String s = String.valueOf(num);
            for (int i = 1; i <= s.length(); i++) {
                if (prefixes.contains(s.substring(0, i))) {
                    maxLen = Math.max(maxLen, i);
                }
            }
        }

        return maxLen;
    }
}