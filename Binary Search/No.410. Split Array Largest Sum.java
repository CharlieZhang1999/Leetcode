class Solution {
    public int splitArray(int[] nums, int k) {
        int max = 0, sum = 0;
        for(int num: nums){
            if(num > max){
                max = num;
            }
            sum += num;
        }
        
        int left = max, right = sum;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(valid(nums, k, mid)){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }
    
    public boolean valid(int[] nums, int k, int mid){
        int total = 0, count = 0;
        for(int num: nums){
            total += num;
            if(total > mid){
                total = num;
                count++;
                if(count >= k){
                    return false;
                }
            }
        }
        return true;
        
    }
}
/*
思路：
1/这个数，他高低最小是整个array的最大值，最大是整个array的sum，我们可以在这个range进行binary search
2/search的依据是什么呢，如果given mid作为这个minimized sum of the split，如果按照mid来split大于k，说明mid小了，要look into比mid大的。如果按照mid来split小于等于k，说明mid可以考虑，并且look into mid以及比mid更小的。
3/这个判断依据就是valid function。 valid负责判断given 一个mid，能不能把nums split到k个及以下个subarray
*/