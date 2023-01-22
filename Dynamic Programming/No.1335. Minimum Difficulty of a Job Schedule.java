class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(n < d) return -1;
        int [][] dp = new int[d+1][n+1];
        int [][] getMax = new int[n][n];
        
        for(int i = 0; i < n; i++){
            getMax[i][i] = jobDifficulty[i];
            for(int j = i-1; j >= 0; j--){
                getMax[i][j] = Math.max(getMax[i-1][j], getMax[i][j+1]);
            }
        }
        
        for(int [] dp_r: dp){
            Arrays.fill(dp_r, Integer.MAX_VALUE);
        }
        
        
        
        
        dp[1][0] = 0;
        for(int j = 1; j <= n; j++){
            dp[1][j] = Math.max(dp[1][j-1], jobDifficulty[j-1]);
        }
        
        for(int i = 2; i <= d; i++){
            for(int j = i; j <= n; j++){
                for(int k = i - 1; k < j; k++){
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + getMax[j-1][k]);
                }
            }
        }
        
        return dp[d][n];
    }
}

/*
思路
1、先建立个getMax matrix. getMax[i][j] 代表从Math.max(jobDifficulty[j],...,jobDifficulty[i]);
2、定义：dp[i][j] 代表 在i天 schedule jobDifficulty[0..i-1]的minimum difficulty
3、关系：dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + getMax[j-1][k]);
比如对于dp[2][3]， 那我们就比较到底是6 + max(5,4)小还是 6+max(4) 比较小。此时的max（5，4）可以在getMax[2][1]找到
4、返回： dp[d][n]
*/