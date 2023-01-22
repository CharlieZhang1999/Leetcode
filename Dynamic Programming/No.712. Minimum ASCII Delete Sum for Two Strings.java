class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int [][] dp = new int[m+1][n+1];
        char [] arr1 = s1.toCharArray();
        char [] arr2 = s2.toCharArray();
        for(int j = 1; j <= n; j++){
            dp[0][j] = dp[0][j-1] + arr2[j-1];
        }
        
        for(int i = 1; i <= m; i++){
            dp[i][0] = dp[i-1][0] + arr1[i-1];
        }
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(arr1[i-1] == arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.min(dp[i][j-1] + arr2[j-1], dp[i-1][j] + arr1[i-1]);
                }
            }
        }
        
        return dp[m][n];
    }
}

/*
类似583
这种calculate minimum distance between two string的题目其实都属于edit distance类型，都要用2d dp
都可以参考lcs的做法

dp[i][j] 的定义是，从s1[:i]到s2[:j]的距离
dp[i][j] 的关系是，如果s1.charAt(i-1) == s2.charAt(j-1) 那么dp[i][j] = dp[i-1][j-1], else则取(dp[i][j-1]+当前字符)和(dp[i-1][j] + 当前字符)的最小值
*/