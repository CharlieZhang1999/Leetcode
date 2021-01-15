/* O(n) space solution */
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        if(sum % 2 != 0) return false;
        sum /= 2;
        
        boolean [] dp = new boolean[sum+1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for(int num : nums){
            for(int j = sum; j > 0; j--){
                if(j >= num){
                    dp[j] = dp[j] | dp[j-num];
                }
            }
        }
        return dp[sum];
    }
}
/* 
epiphany: compress 2-d dp array in the solution below into 1-d dp array
2d怎么到1d详见帅地的解析，大概就是反正每一行只需要前面一行的数据，所以就可以压缩成1d
不过记得双重for loop里列的那个loop要倒序(j--)， 因为一行内后面的内容depend on前面的内容，所以要从后面开始modify
*/




/*
O(n*SUM) space solution


class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        if(sum % 2 != 0) return false;
        sum /= 2;
        
        int n = nums.length;
        boolean [][] dp = new boolean[n+1][sum+1];
        // dp[0][0] to dp[n][0] are all true
        for(int i = 0; i <= n; i++){
            dp[i][0] = true;
        }
        
        //dp[0][1] to dp[0][sum] are all false
        for(int i = 1; i <= sum; i++){
            dp[0][i] = false;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= sum; j++){
                dp[i][j] = dp[i-1][j];
                if(j >= nums[i-1]){
                    dp[i][j] = dp[i][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        
        return dp[n][sum]; 
    }
}


epiphany: This question can be transformed into whether there are several numbers in a set which are able to sum to a specific value (in this problem, the value is sum/2).

defintion: dp[i][j] means if j can be sumed by the first i elements in the array. So dp[n][sum] is whether "sum" in question can be summed up by all the elements in the array

relationship: dp[i][j] is true if dp[i-1][j] is true (I can use even fewer elements than provided to get the sum j, not to mention if I have one more elements)
              or
              dp[i][j] is true if dp[i-1][j-nums[i-1]] is true(I can achieve (j-last element) without using the last element, so I can achieve j with the last element)
              
             
*/