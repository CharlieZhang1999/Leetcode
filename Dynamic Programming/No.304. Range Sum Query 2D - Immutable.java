class NumMatrix {
    public int [][] sum;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        sum = new int[m+1][n+1];
        for(int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                sum[i][j] = sum[i-1][j] + sum[i][j-1] + matrix[i-1][j-1] - sum[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2+1][col2+1] - sum[row2+1][col1] - sum[row1][col2+1] + sum[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */


/*
dp最重要的是1、找到dp[i][j]定义以及2、和附近格子的关系
比如这题，sum[i][j] 的定义是从[0,0]到[i,j]的sum
而它的关系就是sum[i][j] = sum[i][j-1] + sum[i-1][j] + matrix[i-1][j-1] - sum[i-1][j-1]
（因为比如到[2,2]的sum = 到[1,2]的sum + 到[2,1]的sum + [2,2]的val - 到[1,1]的sum（因为这个重复加了）

https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-304-range-sum-query-2d-immutable/
*/