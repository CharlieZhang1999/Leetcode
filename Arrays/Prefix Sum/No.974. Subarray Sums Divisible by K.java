class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, res = 0;
        for(int num: nums){
            sum += num;
            sum = (sum % k + k) % k;
            if(map.get(sum) != null){
                int val = map.get(sum);
                res += val;
                map.put(sum, val+1);
            }
            else{
                map.put(sum, 1);
            }
        }
        // System.out.println(map);
        return res;
    }
}

/*
思路：
类似523 prefix sum + hashtable
subarray sum可以表示成sum - sum的形式
然后利用同余定理
4 % 5 = 4
（4+5） % 5 = 4
所以num of subarray += 1
以此类推
*/