class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length < 1) return 0;
        int dp [] = new int[nums.length];
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            if(dp[i] > max) max = dp[i];
        }
        return max;
    }
}
/*
normal dp solution
every dp[i] is the longest increasing subsequence asscociated with that number
eg: for [10,9,2,5,3,7,101,18]
    dp[2] = 1
    dp[3] = 2 (2, 5)  
    dp[4] = 2 (2, 3)
*/