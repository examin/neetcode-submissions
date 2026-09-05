class Solution {

    Boolean[][] memo;

    public boolean checkValidString(String s) {
        memo = new Boolean[s.length() + 1][s.length() + 1];
        return dfs(s, 0, 0);
    }

    private boolean dfs(String s, int i, int openCount) {

        if (openCount < 0) {
            return false;
        }

        if (i == s.length()) {
            return openCount == 0;
        }

        if (memo[i][openCount] != null) {
            return memo[i][openCount];
        }

        char c = s.charAt(i);

        boolean result;

        if (c == '(') {
            result = dfs(s, i + 1, openCount + 1);

        } else if (c == ')') {
            result = dfs(s, i + 1, openCount - 1);

        } else {
            // '*'

            result =
                dfs(s, i + 1, openCount + 1) ||
                dfs(s, i + 1, openCount - 1) ||
                dfs(s, i + 1, openCount);
        }

        return memo[i][openCount] = result;
    }
}