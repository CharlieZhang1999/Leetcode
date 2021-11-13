class Solution {
    public int rob(int[] nums) {
        if(nums.length < 2) return nums[0];
        int a = houseRobber(nums, 0, nums.length-2);
        int b = houseRobber(nums, 1, nums.length-1);
        return a>=b?a:b;
    }
    public int houseRobber(int[] nums, int start, int end){
        int length = end-start+1;
        if(length <= 1) return nums[start];
        int [] dp = new int[end-start+1];
        dp[0] = nums[start];
        dp[1] = Math.max(dp[0], nums[start+1]);
        for(int i = 2; i < length; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[start+i]);
        }
        return dp[length-1];
    }
}