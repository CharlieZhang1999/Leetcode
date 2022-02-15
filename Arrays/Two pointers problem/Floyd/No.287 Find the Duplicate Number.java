class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        //  reset fast pointer to 0
        fast = 0;
        
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
/*
#two pointer #Floyd's algorithm
不用怀疑，就是floyd
跟142相似

https://www.youtube.com/watch?v=wjYnzkAhcNk
*/