class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int [] dp = new int[n];
        dp[0] = nums[0];
        int res = dp[0];
        for(int i = 1; i < n; i++){
            dp[i] = dp[i-1] > 0?dp[i-1]+nums[i]:nums[i];
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
/*

https://leetcode.com/problems/maximum-subarray/discuss/20193/DP-solution-and-some-thoughts

*/