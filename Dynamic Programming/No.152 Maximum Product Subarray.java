class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 1) return nums[0];
        int r = nums[0], imax = nums[0], imin = nums[0];
        for(int i = 1; i < nums.length; i++){
            //Something negative will come, please be prepare and switch to the best pattern
            if(nums[i] < 0){
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(nums[i], imax*nums[i]);//这里为什么不是imax = Max(imax, imax * A[i])呢？因为如果这个A[i]不可取的话，那么就中断了，不连续了，没有必要再留着这个imax继续了。所以我们这里二选一的option是只保留当前A[i]还是保留整个连续的imax和A[i]。你可以把imax看成一个流动的window，只装载连续的subarray的maxproduct。我们不需要担心之前最大的max product有没有保存，肯定保存啦，往下看就知道了～
            imin = Math.min(nums[i], imin*nums[i]);//同样，imin也是一个流动的保安，它不需要有任何关于之前的记忆，它只活在当下。所以当当下已经比之前要小时，毅然决然的抛弃之前的记忆imin，而给imin赋上新值。
            r = Math.max(imax, r);
        }
        return r;
    }
}