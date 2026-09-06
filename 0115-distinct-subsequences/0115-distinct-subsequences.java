class Solution {

    Integer[][] dp;

    public int numDistinct(String s, String t) {
        dp = new Integer[s.length()][t.length()];
        return solve(s, t, 0, 0);
    }

    public int solve(String s, String t, int i, int j) {

        if (j == t.length())
            return 1;

        if (i == s.length())
            return 0;

        if (dp[i][j] != null)
            return dp[i][j];

        if (s.charAt(i) == t.charAt(j)) {

            int pick = solve(s, t, i + 1, j + 1);
            int skip = solve(s, t, i + 1, j);

            return dp[i][j] = pick + skip;
        }

        return dp[i][j] = solve(s, t, i + 1, j);
    }
}