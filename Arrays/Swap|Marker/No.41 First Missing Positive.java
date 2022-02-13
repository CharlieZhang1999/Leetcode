class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] < 1 || nums[i] > n){
                nums[i] = n+1;
            }
        }

        int absindex;
        for(int i = 0; i < n;  i++){
            absindex = Math.abs(nums[i]);
            if(absindex > n){
                continue;
            }
            
            if(nums[absindex-1] > 0){
                nums[absindex-1] *= -1;
            }
        }
        
        for(int i = 0; i < n;  i++){
            if(nums[i] > 0){
                return i+1;
            }
        }
        
        
        return n+1;
    }
}
/*
inspiration: https://www.youtube.com/watch?v=9SnkdYXNIzM

思路：这题好妙，大概就是多traverse几次以减少空间使用，3N也是O(N)

做法：
(1)在nums的数字应该属于1～n之间，而答案的range就是1～n+1之间（不排除[1,2,3]所以答案是4这种情况）
(2)从i=0开始，把nums[i]这个数该在的位置用 *-1 mark一下(当然也有别的做法是直接swap一下）。比如看见3，它所在的index应该是3-1=2，所以就把nums[2]变成negative以表示见过3了。
(3)最后再traverse一遍看看哪个数没negative。如果nums[i] > 0就说明没看见该在这个位置的数，也就是没看见i+1。 所以return i+1
*/