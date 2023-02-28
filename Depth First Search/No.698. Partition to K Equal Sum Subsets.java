class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        boolean [] visited = new boolean[nums.length];
        // sort可以优化时间
        Arrays.sort(nums);
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        
        // 增加edge case判断，优化时间
        if(sum % k != 0) return false;
        int sumTarget = sum / k;
        return backtrack(nums, 0, 0, sumTarget, k, visited);
    }
    
    public boolean backtrack(int[] nums, int start, int curSum, int sumTarget, int k, boolean [] visited){
        if(k == 0){
            return true;
        }
        if(curSum == sumTarget){
            return backtrack(nums, 0, 0, sumTarget, k-1, visited);
        }
        
        for(int i = start; i < nums.length; i++){
            // 不能用已经用过的元素
            if(visited[i]){
                continue;
            }
            
            // 形如[1,2,2,3,3] 如果走到index=2时发现index=1的那个2就没用过，说明2不行，直接跳过不验证。
            if(i > 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
            
            // 因为是sorted的，所以可以不用看后面的了，直接return false
            if(curSum + nums[i] > sumTarget){
                return false;
            }
            
            visited[i] = true;
            if(backtrack(nums, i+1, curSum+nums[i], sumTarget, k, visited)){
                return true;
            }
            
            // restore
            visited[i] = false;
        }
        
        return false;
    }
}
/*
https://www.youtube.com/watch?v=mBk4I0X46oI
谢谢neetcode哥

*/