class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(mid > 0 && nums[mid] == nums[mid-1]){
                if((mid-1) % 2 != 0){
                    right = mid-1-1;
                }
                else{
                    left = mid+1;
                }
            }
            else if(mid < nums.length-1 && nums[mid] == nums[mid+1]){
                if(mid % 2 != 0){
                    right = mid-1;
                }
                else{
                    left = mid+1+1;
                }
            }
            else return nums[mid];
            
        }
        return nums[left];
    }
}