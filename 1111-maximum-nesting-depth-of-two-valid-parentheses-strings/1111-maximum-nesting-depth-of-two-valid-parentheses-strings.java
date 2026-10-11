class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = (seq.charAt(i) == '(') ? i % 2 : (i + 1) % 2;
        }

        return ans;
    }
}