class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        int [] dp = new int[n];
        int max = 0, index = 0;
        int [] prev = new int[n];
        prev[0] = -1;
        for(int i = 0; i < n; i++){
            prev[i] = -1;
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0 && dp[i] < dp[j]+1){
                    dp[i] = dp[j]+1;
                    prev[i] = j;
                }
            }
            
            if(dp[i] > max){
                index = i;
                max = dp[i];
            }
        }
        
        while(index >= 0){
            res.add(nums[index]);
            index = prev[index];
        }
        
        return res;   
    }
}
/* 
狠straightforward的dp
比较有意思的地方在于怎么记录longest pair
那我这个解法的做法就是记录上一个pair数最大的除数，也就是记录j有i%j == 0并且dp[j]最大
prev[i] = j
这样就可以通过prev这个array i->j->k->l这样串起来
*/