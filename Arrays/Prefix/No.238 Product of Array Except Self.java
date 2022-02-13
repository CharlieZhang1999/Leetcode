class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int [] res = new int[n];
        
        // prefix loop
        int prefix = 1;
        for(int i = 0; i < n; i++){
            res[i] = prefix;
            prefix = prefix * nums[i];
            
        }
        
        // suffix loop
        int suffix = 1;
        for(int i = n - 1; i >= 0; i--){
            res[i] = res[i] * suffix;
            suffix = suffix * nums[i];
        }
        
        return res;
    }
}
/*
思路：
(1) 想到不能用division，那么先可以脑补两个array
一个int [] nums为原始array
一个int [] prefix 用来装到nums[i]之前的所有乘积
一个int [] suffix 用来装nums[i]之后的所有乘积

(2)进阶：因为要求constant space
我们可以直接在原array上操作，加入两个变量int prefix and int suffix
两次来回traversal
去的时候更新prefix并存储到int [] res里
prefix = prefix * nums[i]

回的时候更新prefix并存储到int [] res里
suffix = suffix * nums[i]
这样更新
*/