class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double [][] dp = new double[k+1][n+1];
        double [] sum = new double[n+1];
        
        for(int i = 1; i <= n; i++){
            sum[i] = sum[i-1] + nums[i-1];
            dp[1][i] = sum[i] / i;
        }
        
        for(int k_i = 2; k_i <= k; k_i++){
            for(int i = k_i; i <= n; i++){
                for(int j = k_i-1; j < i; j++){
                    dp[k_i][i] = Math.max(dp[k_i][i],  dp[k_i-1][j] + (sum[i] - sum[j]) / (i-j));
                }
            }
        }
        
        return dp[k][n];
    }
}

/*
思路：
定义：dp[k][i] 为对A[0]..A[i-1] partition k个subarray 求出的largest sum of averages
关系：dp[k][i] = maximum of ( dp[k-1][j] + avg(A[j+1], A[i-1]) ) for j in k-1 ... i-1
https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-813-largest-sum-of-averages/
*/