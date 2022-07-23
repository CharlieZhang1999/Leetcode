class Solution {
    public int minSteps(int n) {
        int [] dp = new int[n+1];
        // base case:
        dp[1] = 0;
        
        for(int i = 2; i <= n; i++){
            for(int j = i-1; j >0; j--){
                if(i % j == 0){
                    dp[i] = dp[j] + (i/j);
                    break;
                }
            }
        }
        
        
        return dp[n];
        
    }
}
/*
思路：
dp[10] = dp[5]+2
dp[9] = dp[3]+3
为什么呢
因为(1)得到5(2)c(3)p
同理(1)得到3(2)c(3)pp
你会发现dp[i]需要的move正好是dp[j]+1+(i/j)-1,也就是dp[j]+(i/j)
所以只需要从i-1到0逆序找到i最大的factor即可
*/
ßß