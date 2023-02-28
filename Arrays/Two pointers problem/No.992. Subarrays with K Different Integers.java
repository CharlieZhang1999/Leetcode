class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return findSubarray(nums, k) - findSubarray(nums, k-1);
    }
    
    public int findSubarray(int[] nums, int k){
        int [] count = new int [nums.length + 1];
        int i = 0;
        int ans = 0;
        
        for(int j = 0; j < nums.length; j++){
            if(count[nums[j]]++ == 0){
                k--;
            }
            while(k < 0){
                if(--count[nums[i++]] == 0){
                    k++;
                }
            }
            ans += j - i + 1;
        }
        return ans;
    }
}