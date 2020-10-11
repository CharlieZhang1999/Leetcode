class Solution {
    public int numSquares(int n) {
        int [] dp = new int [n+1];
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 1; j*j <=i; j++){
                min = Math.min(min, dp[i - j*j] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
/*
This is a very typical dynamic programming solution. 
epiphany: 
    1\找清楚关系是关键。比如，dp[n] = min{foreach(j) dp[n - j*j] + 1}
    2\complexity: O(n) * sqrt(n)
    3\intution:
        dp[0] = 0 
        dp[1] = dp[0]+1 = 1
        dp[2] = dp[1]+1 = 2
        dp[3] = dp[2]+1 = 3
        dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1 } 
              = Min{ dp[3]+1, dp[0]+1 } 
              = 1				
        dp[5] = Min{ dp[5-1*1]+1, dp[5-2*2]+1 } 
              = Min{ dp[4]+1, dp[1]+1 } 
              = 2
                                .
                                .
                                .
        dp[13] = Min{ dp[13-1*1]+1, dp[13-2*2]+1, dp[13-3*3]+1 } 
               = Min{ dp[12]+1, dp[9]+1, dp[4]+1 } 
               = 2
                                .
                                .
                                .
        dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1
*/