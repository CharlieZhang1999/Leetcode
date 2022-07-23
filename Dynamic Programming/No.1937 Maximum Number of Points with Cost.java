class Solution {
    public long maxPoints(int[][] points) {
        
        int rows = points.length;
        int cols = points[0].length;
        long maxPoints = 0;
        
        long[] dp = new long[cols];
        for(int i = 0; i < rows; i++){
            
            for(int j = 0; j < cols; j++){
                dp[j] += points[i][j];
            }
            
            for(int j = 1; j < cols; j++){
                dp[j] = Math.max(dp[j], dp[j-1]-1);
            }
            
            for(int j = cols - 2; j >= 0; j--){
                dp[j] = Math.max(dp[j], dp[j+1]-1);
            }
        }
        
        for (int j = 0; j < cols; j++) {
            maxPoints = Math.max(maxPoints, dp[j]);
        }
        return maxPoints;
    }
}
/*
#tag: dp

dp减distance的类型，同类题目1014
因为是双向（可以同时考虑左边更佳的选择和右边更加的选择），所以有两个traversal
一次是比较Math.max(dp[j], dp[j-1]-1), 另一次是比较Math.max(dp[j], dp[j+1]-1);

对于此类dp减distance的题目，核心公式就是dp[i] = Math.max(dp[i], dp[i-1]-1);
*/