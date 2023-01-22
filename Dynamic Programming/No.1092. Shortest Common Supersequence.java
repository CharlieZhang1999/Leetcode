    class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int [][] dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0){
                    // The length of SCS of a empty string with str2 is str2 itself's length
                    dp[i][j] = j; 
                }
                else if(j == 0){
                    // The length of SCS of a empty string with str1 is str1 itself's length
                    dp[i][j] = i;
                }
                else{
                    if(str1.charAt(i-1) == str2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                    else{
                        dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+1;
                    }
                }
            }
        }
        
        // l will be the length of the SCS of str1 and str2
        int l = dp[m][n];
        char [] res = new char[l];
        int i = m, j = n;
        while(i > 0 && j > 0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                res[--l] = str1.charAt(i-1);
                i--;j--;
            }
            else if(dp[i-1][j] < dp[i][j-1]){
                res[--l] = str1.charAt(i-1);
                i--;
            }
            else{
                res[--l] = str2.charAt(j-1);
                j--;
            }
        }
        
        while(i>0){
            res[--l] = str1.charAt(i-1);
            i--;
        }
        
        while(j>0){
            res[--l] = str2.charAt(j-1);
            j--;
        }
        
        return new String(res);
        
    }
}
/*
思路：
1\用lcs来推出str1 and str2的shotest common supersequence(scs)的长度
定义：dp[i][j] 为 str1[:i]和str2[:j]的scs的长度
关系：if charAt(i-1) == charAt(j-1), dp[i][j] = dp[i-1][j-1] + 1; else dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
edge case：dp[i][0] = i, dp[0][j] = j

2\推完之后，trace back。
【1】从i = m, j = n开始，对于[i,j]， 如果char(i-1) == char(j-1), 说明这是common sequence， append这个char并且[i,j]移动到[i-1, j-1]
【2】如果char(i-1) != char(j-1), 则取dp[i][j-1] 和 dp[i-1][j]的较小值。比如如果dp[i-1][j] < dp[i][j-1], 则currently append str[i-1], 然后i--。 这样才是最短的路线最短的supersequence。
【3】如果先把一个str append完了（比如i == 0 or j == 0. 那append另外一个str。
*/