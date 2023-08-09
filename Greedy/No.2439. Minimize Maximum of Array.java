class Solution {
    public int minimizeArrayValue(int[] nums) {
        long prefixsum = 0;
        long ans = 0;
        for(int i = 0; i < nums.length; i++){
            prefixsum += nums[i];
            ans = Math.max(ans, (prefixsum + i) / (i+1));
        }
        
        return (int) ans;
    }
}
/*
思路：https://www.youtube.com/watch?v=AeHMvcKuR0Y
这道题很有意思的一行是(prefixsum + i) / (i+1)，这一行其实相当于(int) Math.ceil(prefixsum / (i+1))
但是简化了许多不是吗！
他好帅啊
*/