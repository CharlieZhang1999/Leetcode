class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // HashSet<Integer> ret = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(nums, result, 0);
        return result;
    }
    public void backtrack(int[] nums, List<List<Integer>> result, int start){
        if(start == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int i: nums){
                temp.add(i);
            }
            result.add(temp);
            return;
        }
        HashSet<Integer> appeared = new HashSet<>();
        for(int i = start; i < nums.length; i++){
            if(appeared.add(nums[i])){
                swap(nums, start, i);
                backtrack(nums,  result, start+1);
                swap(nums, start, i);
            }
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
/*
跟permutation 1的原理基本一样的
就是对于每个位置，所有数都要过来看看（疯狂swap）
但是要注意的是如果有数值一样的数在本位置待过了，就跳过
比如在0位置已经有过1之后，如果后面再出现1，就不用swap过来了，因为已经考虑过1开头的所有可能性了，swap过来必是重复
cr to: https://leetcode.com/problems/permutations-ii/discuss/18648/Share-my-Java-code-with-detailed-explanantion
*/