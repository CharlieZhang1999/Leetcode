class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[nums.length-1];
        int min_diff = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            int low = i + 1;
            int high = nums.length - 1;
            while(low < high){
                int sum = nums[i] + nums[low] + nums[high];
                if(sum == target){
                    return target;
                }
                else if(sum > target){
                    high--;
                }
                else{
                    low++;
                }
                
                if(Math.abs(sum - target) < min_diff){
                    min_diff = Math.abs(sum - target);
                    closest = sum;
                } 
            }
        }
        return closest;
    }
}
/*
epiphany:
    基本和前面那道3Sum一样，就是第一个pointer遍历i in 0..n-1; 第二个pointer是low pointer，从i+1开始，与第三个pointer high pointer从n-1开始做相遇问题。
    三种情况：
    1\sum == target: return target
    2\sum < target, 说明整体小，需要把低的门槛往上调，low++
    3\sum > target, 需要把高的门槛往下降，high--
    然后比较，满足条件时update min_diff和closest
    
难点：
    在于提升时间。之前我只设了一个variable closest，每次update的时候都是if (Math.abs(sum - target) < Math.abs(closest - target)) 很费时间
    所以不如新加一个变量min_diff,这样就省下了做后一个Math.abs()的时间*/