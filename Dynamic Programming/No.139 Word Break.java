class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean [] dp = new boolean[n+1];
        dp[0] = true;
        for(int i = 1; i <= n; i++){
            for(int j = i - 1; j >= 0; j--){
                if(dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
/*
难点：
1、很难想到要用DP，因为这个关系太难联想到了。
2、定义：dp[i] = true if substring(0, i) can break down to words in dictionary
3、初始条件：dp[0] = true;（因为substring(0, 0)是空，默认是可以被dictionary分解的
4、关系式：dp[i] == true if dp[j] is true and dict contains s.substring(j, i);
*/