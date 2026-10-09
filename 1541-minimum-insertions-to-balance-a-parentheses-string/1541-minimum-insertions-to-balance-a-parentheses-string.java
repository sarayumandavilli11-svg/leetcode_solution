
class Solution {
    public int minInsertions(String s) {
        int open = 0;
        int insertions = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                open++;
            } else {
                // If the next character is also ')',
                // they form one closing pair.
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    // Insert one ')' to complete the pair.
                    insertions++;
                }

                if (open > 0) {
                    open--;
                } else {
                    // Insert '(' to match this closing pair.
                    insertions++;
                }
            }
        }

        // Each remaining '(' needs two ')'.
        return insertions + open * 2;
    }
}
