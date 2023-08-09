class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0, freq = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i] != nums[i-1]){
                freq = 0;
            }
            else if(freq > 1){
                continue;
            }
            
            nums[count] = nums[i];
            freq++;
            count++;
        }
        return count;
    }
}
/*
思路：
1、保持一个有意义的数count，这个代表着我们真正要存的有几个数（k）
2、只有在符合条件的时候才count++，比如 目前这个数和前一个数不同，或者，目前这个数出现的次数小于twice。
*/