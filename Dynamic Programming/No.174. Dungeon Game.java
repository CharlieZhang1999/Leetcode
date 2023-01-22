class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int [][] dp = new int[m][n];
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                solve(dungeon, dp, i, j, m, n);
            }
        }
        
        return dp[0][0];
    }
    
    public void solve(int[][] dungeon, int[][] dp, int i, int j, int m, int n){
        boolean positive = dungeon[i][j] > 0;
        int atLeast = positive?1:-1*dungeon[i][j];
        
        if(i == m-1 && j == n-1){
            dp[i][j] = Math.max(1-dungeon[i][j], atLeast);
            return;
        }
        else if(i == m-1){
            dp[i][j] = Math.max(dp[i][j+1]-dungeon[i][j], atLeast);
            return;
        }
        else if(j == n-1){
            dp[i][j] = Math.max(dp[i+1][j]-dungeon[i][j], atLeast);
            return;
        }
        else{
            dp[i][j] = Math.max(Math.min(dp[i+1][j], dp[i][j+1])-dungeon[i][j], atLeast);
            return;
        }
        
    }
}
/* 
思路：
1、对于正数的格子，只要满足在到达这个格子[i,j]之前至少有1滴血即可，所以postive, atLeast = 1;
2、对于负数的格子，只要满足在到达这个格子[i,j]之前至少有-dungeon[i,j]滴血即可, 所以negative， atLeast = -dungeon[i,j];
3、依次累加，从bottom right格子加到top left, 最后输出dp[0][0]就是答案
*/