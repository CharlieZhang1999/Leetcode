class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int [] dp = new int[nums.length];
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(i < 2){
                continue;
            }
            if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2]){
                dp[i] = dp[i-1] + 1;
                sum += dp[i];
            }
        }
        return sum;
    }
}