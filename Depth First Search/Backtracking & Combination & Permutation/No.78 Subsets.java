/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(ans, temp, nums, 0);
        return ans;
    }
    public static void backtrack(List<List<Integer>> ans, List<Integer> temp, int[] nums, int start){
        if(temp.size() >= 0){
            ans.add(new ArrayList(temp));
        }
        for(int i = start; i < nums.length; i++){
            temp.add(nums[i]);
            backtrack(ans, temp, nums, i + 1);
            temp.remove(temp.size()-1);
        }
        return;
    }
}