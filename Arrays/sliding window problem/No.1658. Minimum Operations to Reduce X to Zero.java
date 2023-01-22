class Solution {
    public int minOperations(int[] nums, int x) {
        int res = -1, sum = 0, n = nums.length;
        for(int num: nums){
            sum += num;
        }
        
        if(sum < x) return -1;
        int target = sum - x;
        int i = 0, j = 0;
        sum = 0;
        while(j < n){
            sum += nums[j++];
            while(sum > target){
                sum -= nums[i];
                i++;
            }
            if(sum == target){
                res = Math.max(res, j-i);
            }
        }
        
        return res == -1? res: n-res;
    }
}

/*
这不就完事了吗
sliding window: 这把高端局 oh my oh my god

思路：
跟209非常类似
要找最短的连续subarray的和为x，相当于要找最长的subarray和为sum-x, days不day？
那就用一个sliding window，i和j，每个iteration j++, 如果sum A[i..j] > target, i++; 如果sum A[i..j] == target，用Math.max更新最大长度res
最后用n-res就是 最短的连续subarray的和为x 的长度
*/