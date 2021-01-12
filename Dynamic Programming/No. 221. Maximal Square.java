import java.lang.Math;
class Solution {
    public int maximalSquare(char[][] matrix) {
        int r = matrix.length, c = r >= 0? matrix[0].length:0;
        int max = 0;
       // pad zeros on the left and on the above 
        int [][] dp = new int[r+1][c+1];

        for(int i = 1; i <= r; i++){
            for(int j = 1; j <= c; j++){
                // since i and j start from 1, [i-1][j-1] starts from [0][0]
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + 1;
                    max = Math.max(dp[i][j], max);
                }
                            
            }
        }
        return max*max;
    }
}
/* 
epiphany: 大意就是dp[i][j]代表以i,j为右下角的最大的含1 sauare的边长，比如在exapmle 1中，[2][3]的位置应该是2.因为以它结束的最大正方形边长是2
这点我想到了，但dp之间的关系没想出来，比如dp[i-1][j-1]是1， dp[i][j-1]和dp[i-1][j]为2的情况下，dp[i][j]就是2
dp间的关系： min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1。因为即使有两个2但有一个1，说明3x3有几格是缺了1了，但既然这三格起码都是1，那1+1 = 2.以此类推



step 1/构造一个m+1 x n+1 的dp matrix， 这样0,0 第一格就变成了1,1 让[i-1][j-1]更好取值一点
step 2/两个for loop循环每个格子，dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1， 并记住它是否为max
step 3/ 现在的max只是边长。不要忘了平方才是area哦～
*/ 