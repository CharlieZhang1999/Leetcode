class Solution {
    public int numDistinct(String s, String t) {
        int m = t.length();
        int n = s.length();
        int [][] dp = new int[m+1][n+1];
        
        for(int j = 0; j <= n; j++){
            dp[0][j] = 1;
        }
        
//         for(int i = 1; i < m; i++){
//             dp[i][0] = 0;
//         }
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(t.charAt(i-1) == s.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }
                else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        
        return dp[m][n];
        
    }
}

/*
tag：dp

https://www.youtube.com/watch?v=mPqqXh8XvWY

思路：
1\若char相同：
    （1）用，则dp[i][j] = dp[i-1][j-1]
     (2) 不用，skip掉，则dp[i][j] = dp[i][j-1]
2\若char不同：
    则相当于无视现在j这个char，直接用s的前面j-1覆盖t的前i个char，即dp[i][j] = dp[i][j-1]
*/
