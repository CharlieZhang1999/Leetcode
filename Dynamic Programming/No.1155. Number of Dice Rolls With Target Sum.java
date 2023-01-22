class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        // 真的太久没做dp了 这都看不出来是dp嘛我的宝
        int [][] dp = new int[n][target+1];
        int mod =  (int)Math.pow(10, 9)+7;
        for(int i = 0; i < n; i++){
            dp[i][0] = 0;
        }

        int KorTarget = Math.min(k, target);
        for(int j = 1; j <= KorTarget; j++){
            dp[0][j] = 1;
        }

        for(int i = 1; i < n; i++){
            int maxcol = Math.min(target, (i+1)*k);
            for(int j = 1; j <= maxcol; j++){
                for(int d = 1; d <= k && j-d >= 0; d++){
                    dp[i][j] = (dp[i][j] + dp[i-1][j-d]) % mod;
                }
            }
        }

        return dp[n-1][target];
    }


}
/*
tag: DP
这道题和coin change如出一辙，纯属我自己脑瘫
思路：
1\dp[i][j] 代表用i-1个coin组成target=j的方式
2\所以dp[i][j] = dp[i-1][j-1] + dp[i-1][j-2] + ......dp[i-1][j-k]
*/