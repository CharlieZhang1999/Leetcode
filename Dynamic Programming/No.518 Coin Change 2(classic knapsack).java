class Solution {
    public int change(int amount, int[] coins) {
        int [] dp = new int[amount+1];
        dp[0] = 1;
        for(int coin: coins){
            for(int i = coin; i <= amount; i++){
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}
/*
有一个空间复杂度慢一点但是好理解一点的solution 贴在下面
class Solution {
    public int change(int amount, int[] coins) {
        int [][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;
        for(int i = 1; i <= coins.length; i++){
            for(int j = 0; j <= amount; j++){
                dp[i][j] = dp[i-1][j] + (j>=coins[i-1]? dp[i][j-coins[i-1]]:0);
            }
        }
        return dp[coins.length][amount];
    }
}

这个题！划重点！好神奇 经典knapsack
dp[i][j] : the number of combinations to make up amount j by using the first i types of coins

dp[i - 1][j]: means the number of combinations if we compeletly don't use the ith coin
dp[i][j - coins[i - 1]]: we must use at least one of the ith coin, so we expell the ith coin from j (Exclusive, opposite to the upper condition)
这两个正好相当于A和A complement, 并在一起就是dp[i][j]!
弹幕给我抠6！
*/