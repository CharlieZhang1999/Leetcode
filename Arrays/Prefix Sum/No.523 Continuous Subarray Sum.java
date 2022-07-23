class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int sum = 0, remainder;
        Integer idx;
        HashMap<Integer, Integer> map = new HashMap<>(){{put(0,-1);}};
        
        for(int i = 0; i < n; i++){
            sum += nums[i];
            sum = sum % k;
            idx = map.get(sum);
            if(idx != null){
                if(i-idx != 1){
                    return true;
                }
            }
            else{
                map.put(sum, i);
            }
        }
        return false;
    }
}
/*
#tag: Array, prefix sum
这道题又是一道典型的subarray sum的问题
subarray sum的典型思路就是利用cumsum和前面的cumsum的差作对比来判断

思路：
这道题跟k的multiple有关。我们利用同余定理，即如果两个数mod k相同，则这两个数的差必是k的倍数
比如23 mod 6 = 5;
35 mod 6 = 5;
则必有 （35-23）mod 6 = 0
所以我们每次hashmap里只要放余数就好了，如果detect到相同的余数且距离为1以上，直接return true

*/