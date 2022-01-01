import java.lang.Math;
class Solution {
    public int minDistance(String word1, String word2) {
        int [][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i = 0; i <= word1.length(); i++){
            for(int j = 0; j <= word2.length(); j++){
                if(i == 0 || j == 0){
                    dp[i][j] = Math.max(i, j);
                    continue;
                }
                else{
                    // general case
                    int d = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
                    // same character case
                    dp[i][j] = (word1.charAt(i-1) == word2.charAt(j-1))? Math.min(dp[i-1][j-1],d):d;
                }
                
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
/*
这道题也挺妙的
定义：
也是一个dp[i][i]代表从word1的0-i的substring转换到word2的substring要多少步

大体思路：
只有以下三种选项可选
dp[i][j-1]代表insert
dp[i-1][j]代表delete
dp[i-1][j-1]代表replace
因为每个op消耗的步数都是1，所以有Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;

特殊情况：
只有在发现两个字母一样的时候，那步数应该和(word1去掉这个字母)转换到(word2去掉这个字母)的步数一样，故Math.min还要带上dp[i-1][j-1]
*/
