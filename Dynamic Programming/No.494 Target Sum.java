class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        int n = nums.length;
        for(int num: nums){
            total += num;
        }
        if(target < -1 * total || target > total){
            return 0;
        }
        
        int[][] dp = new int[n][2*total+1];
        dp[0][total+nums[0]] = 1;
        // don't write dp[0][total-nums[0]] = 1 cuz there is condition when total+num[0] = total-num[0]
        dp[0][total-nums[0]] += 1;
        for(int i = 1;  i < n; i++){
            for(int j = 0; j < 2 * total + 1; j++){
                if(dp[i-1][j] > 0){
                    dp[i][j-nums[i]] += dp[i-1][j];
                    dp[i][j+nums[i]] += dp[i-1][j];
                }
            }
        }
        
        return dp[n-1][total+target];
        
    }
}