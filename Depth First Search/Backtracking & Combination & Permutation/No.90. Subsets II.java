class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, ret, temp, false);
        return ret;
    }
    
    public void backtrack(int[] nums, int start, List<List<Integer>> ret, List<Integer> temp, boolean choosePre){
        if(start >= nums.length){
            ret.add(new ArrayList<>(temp));
            return;
        }
        
        
        backtrack(nums, start+1, ret, temp, false);
        
        if(start > 0 && nums[start] == nums[start-1] && !choosePre){
            return;
        }
        temp.add(nums[start]);
        backtrack(nums, start+1, ret, temp, true);
        temp.remove(temp.size()-1); 
    }
}

/*
思路：
https://leetcode.com/problems/subsets-ii/discuss/169226/Java-Two-Way-of-Recursive-thinking

刚开始用hashset做，只beat了百分之五十，毕竟有很多的compare复杂度高一点
而后来看了discussion受到了启发
既然已经sort了
那对于[1,2,2,2]这种nums来说
如果index 1的那个2没被choose，那后面的2都不许被choose，不准搭空中楼阁。
所有的1个2，2个2，3个2的combination都是优先choose最前面的，譬如2个2的组合必是index=1和index=2的2个2组合起来，跟最后那个2无关
最后那个2 只有在3个2（所有2都用上）的combination里才会出现
*/