class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(nums);
        kSum(nums, target, 4, 0, ans, cur);
        return ans;
    }
    
    public void kSum(int[] nums, int target, int k, int start, List<List<Integer>> ans, List<Integer> cur){
        if(k == 2){
            twoSum(start, nums, target, ans, cur);
            return;
        }
       
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]){
                continue;
            }
            cur.add(nums[i]);
            kSum(nums, target - nums[i], k-1, i+1, ans, cur);
            cur.remove(cur.size()-1);
        }
    }
    
    public void twoSum(int idx, int[] nums, int target, List<List<Integer>> ans, List<Integer> cur){
        int lo = idx;
        int hi = nums.length - 1;
        int sum = 0;
        while(lo < hi){
            sum = nums[lo] + nums[hi];
            // case 1:
            if(sum < target || (lo > idx && nums[lo] == nums[lo-1])){
                lo++;
            }
            // case 2:
            else if(sum > target || (hi < nums.length - 1 && nums[hi] == nums[hi+1])){
                hi--;
            }
            // case 3: two sum found
            else{
                List<Integer> copy = new ArrayList<>(cur);
                copy.add(nums[lo++]);
                copy.add(nums[hi--]);
                ans.add(copy);
            }
            
        }
        return;
    }
    
}