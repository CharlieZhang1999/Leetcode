class Solution {
    public int ret = 0;
    public int longestLine(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int [][][] res = new int[m][n][4];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp(mat, i, j, res);
            }
        }
        return ret;
    }
    
    public void dp(int[][] mat, int row, int col, int [][][] res){
        if(mat[row][col] == 1){
            res[row][col][0] = 1;
            res[row][col][1] = 1;
            res[row][col][2] = 1;
            res[row][col][3] = 1;
            ret = Math.max(ret, 1);
            if(col >= 1){
                res[row][col][0] =  res[row][col-1][0]+1;
                ret = Math.max(ret, res[row][col][0]);
                
                if(row >= 1){
                    res[row][col][2] = res[row-1][col-1][2] + 1;
                    ret = Math.max(ret, res[row][col][2]);
                }
            }
            if(row >= 1){
                res[row][col][1] =  res[row-1][col][1]+1;
                ret = Math.max(ret, res[row][col][1]);
                if(col < mat[0].length - 1){
                    res[row][col][3] = res[row-1][col+1][3] + 1;
                    ret = Math.max(ret, res[row][col][3]);
                }
            }
        }
        
        
    }
}