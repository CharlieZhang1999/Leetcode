class Solution {
    public int countSquares(int[][] matrix) {
        int row =  matrix.length, col = matrix[0].length;
        int[][] dp = new int[row][col];
        int sum  = 0;
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(matrix[r][c] == 0){
                    continue;
                }
                else{
                    if(r == 0 || c == 0){
                        dp[r][c] = 1;
                    }
                    else{
                        dp[r][c] = Math.min(Math.min(dp[r-1][c], dp[r][c-1]), dp[r-1][c-1])+1;
                    }
                    sum += dp[r][c];
                }
            }
        }
        
        return sum;
        
    }
}