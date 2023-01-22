class Solution {
    public int countVowelPermutation(int n) {
        long [][] dp = new long[n+1][5];
        int m = 1000000007;
        long ans = 0;
        for(int j = 0; j < 5; j++){
            dp[1][j] = 1;
        }
        
        for(int i = 2; i <= n; i++){
            dp[i][0] = (dp[i-1][1] + dp[i-1][2] + dp[i-1][4]) % m;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % m;
            dp[i][2] = (dp[i-1][1] + dp[i-1][3]) % m;
            dp[i][3] = dp[i-1][2] % m;
            dp[i][4] = (dp[i-1][2] + dp[i-1][3]) % m;
        }
        
        for(int j = 0; j < 5; j++){
            ans = (ans + dp[n][j]) % m;
        }
        
        return (int)ans;
    }
 }

/*
之前想的太复杂了
其实就是很简单的加法关系
【1】定义：dp[n][j]为以char j结尾的length n的个数
【2】关系：
以a结尾的话，有ea,ia,ua 所以以a结尾的length n的个数 = 以e结尾的length n-1的个数 + 以i结尾的length n-1的个数 + 以u结尾的length n-1的个数
dp[n][0] = (dp[n-1][1] + dp[n-1][2] + dp[n-1][4]) % m;

【3】返回：
return (dp[n][0] + dp[n][1] + dp[n][2] + dp[n][3] + dp[n][4]) % m
*/