class Solution {
    public int integerBreak(int n) {
        int [] dp = new int [n+1];
        dp[1] = 1;
        for(int i=2;i<n+1;i++){
            if(i!=n){
                dp[i] = i;
            }
            for(int j=1;j<=i/2;j++){
                dp[i] = Math.max(dp[i], dp[j]*dp[i-j]);                
            }
        }
        return dp[n];
    }
}
/*
对于1～n-1的每个数，他们的dp[i]对应的是他们的maximum product和他们这个数本身较大的那一个
所以才有第7行先给dp[i]赋他们本身的值
然后再把这个值和所有的product combination 对比（Math.max(dp[i], dp[j]*dp[i-j])）
*/