class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0;
        int sum = 0, res = Integer.MAX_VALUE, n = nums.length;
        while(j < n){
            sum += nums[j++];
            while(sum >= target){
                res = Math.min(res, j-i);
                sum -= nums[i];
                i++;
            }            
        }
        
        return res <= n? res: 0;
    }
}
/*思路：
跟76同理
two pointer + sliding window
1. Use two pointers: start and end to represent a window.
2. Move end to find a valid window.
3. When a valid window is found, move start to find a smaller window.
*/