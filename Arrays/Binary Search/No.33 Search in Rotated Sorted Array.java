class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low < high){
            int mid = low + (high - low) / 2;
            if(nums[mid] > nums[high]) low = mid + 1;
            else high = mid;
        }

        int lo_offset = low;
        low = 0; high = n-1;

        while(low <= high){
            // 0 based
            int mi = low + (high - low) / 2;
            // offset based(only used when comparing)
            int realmid = (lo_offset + mi) % n;
            if(nums[realmid] == target) return realmid;
            else if(nums[realmid] > target) high = mi - 1;
            else low = mi + 1;
        }
        return -1;
    }
    
}
/*
epiphany: 这道题的思路在于先用二分法figure out offset，再用一个本质的二分法（只有在比大小的时候加上offset，其他时候还可以继续0-based）
面试哭唧唧
*/