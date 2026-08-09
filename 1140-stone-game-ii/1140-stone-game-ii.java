class Solution {
    Integer[][] dp;
    int[] suffix;
    int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;

        suffix = new int[n];
        suffix[n-1] = piles[n-1];

        for(int i=n-2; i>= 0; i--){
            suffix[i] = suffix[i+1] + piles[i];
        }

        dp = new Integer[n][n+1];
        
        return solve(0,1);
    }

    public int solve(int i, int M){
        if(i>=n){
            return 0;
        }

        if(dp[i][M] != null){
            return dp[i][M];
        }

        int ans = 0;

        for(int x=1; x <= Math.min(2*M, n-i); x++){
            ans = Math.max(ans, suffix[i] - solve(i+x, Math.max(M,x)));
        }
        
        return dp[i][M] = ans;
    }

}