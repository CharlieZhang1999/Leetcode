class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int length = nums1.length;
        
        Integer [] num1 = new Integer[length];
        PriorityQueue<int []> num2 = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        
        int [] ans = new int[length];
        for(int i = 0; i < nums1.length; i++){
            num1[i] = nums1[i];
            num2.add(new int[]{nums2[i], i});
        }
        
        Arrays.sort(num1);
        int lo = 0, hi = nums1.length-1;
        while(!num2.isEmpty()){
            int [] cur = num2.poll();
            if(cur[0] < num1[hi]){
                ans[cur[1]] = num1[hi];
                hi--;
            }
            else{
                ans[cur[1]] = num1[lo];
                lo++;
            }
        }
        return ans;
        
    }
}
/*
思路：
A和B都sort，如果B这边最大的能被A那边最大的cover掉，那就正好对位;
如果B这边最大的>A那边最大的，那就拿A那边最小的来对位B最大的


这道题的确我也想到了用sorting，只是我用的是arraylist和collection.sort，然后不可避免的需要append和remove元素，就非常麻烦
反而用两个pointer 一个lo 一个hi 就不用remove元素，非常简单
*/