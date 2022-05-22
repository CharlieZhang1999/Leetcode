class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for(int a:nums1){
            for(int b:nums2){
                hashmap.put(a+b, hashmap.getOrDefault(a+b, 0)+1);
            }
        }
        
        for(int c:nums3){
            for(int d:nums4){
                res += hashmap.getOrDefault(-(c+d), 0);
            }
        }
        
        return res;
    }
}