class Solution {
    public int minPatches(int[] nums, int n) {
        int i = 0;
        long miss = 1, res = 0;
        
        while(miss <= n){
            if(i < nums.length && nums[i] <= miss){
                miss += nums[i++];
            }
            else{
                // System.out.println("add miss "+miss);
                miss += miss;
                res++;
            }
        }
        
        return (int)res;
        
    }
}
/*
思路：
这个题很有意思
https://leetcode.com/problems/patching-array/discuss/78488/Solution-%2B-explanation
我们定义通过目前的数字可以达到的范围是[0,miss) miss是开区间
1、那么如果nums[i] <= miss, 我们就可以快乐的引入nums[i]。eg：[1,2,4,8]的时候1,2,4能覆盖的区间是[0,8) miss是8，而nums[i]正好也是8，所以可以引入，miss += nums[i] 引入之后覆盖的范围就就是[0,16)

2、但如果nums[i] > miss, 比如[1,2,4,10] i=3的时候，miss=8, nums[i] = 10这时候我们就要把miss=8 patch进这个array 从而array变成[1,2,4,8,10]，miss += miss这样范围变成了[0,16)下次就可以引入10了！
*/