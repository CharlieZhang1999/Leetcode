class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right;
        int maxOnes = 0, longest = 0, res = 0;
        for(right = 0; right < nums.length; right++){
            if(nums[right] == 1){
                maxOnes++;
            }
            
            longest = Math.max(maxOnes, longest);
            while((right - left + 1) - maxOnes > k){
                if(nums[left] == 1) maxOnes--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}