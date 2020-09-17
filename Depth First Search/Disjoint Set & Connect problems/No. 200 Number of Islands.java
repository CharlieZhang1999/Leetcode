class Solution {
    public int numIslands(char[][] grid) {
        int num_rows = grid.length;
        if(num_rows <= 0) return 0;
        int num_cols = grid[0].length;
        int count = 0;
        int [][] nodes = new int[num_rows][num_cols];
        for(int i = 0; i < num_rows; i++){
            for(int j = 0; j < num_cols; j++){
                if(grid[i][j] == '0' || nodes[i][j] != 0) continue;
                else{
                    count++;
                    connect(i, j, grid, nodes, count);
                }
            }
        }
        return count;
    }
    
    public void connect(int row, int col, char[][] grid, int[][] nodes, int flag){
        if(row > 0 && grid[row-1][col] == '1' && nodes[row-1][col] == 0){
            nodes[row-1][col] = flag;
            connect(row-1, col, grid, nodes, flag);
        }
        if(row < grid.length - 1 && grid[row+1][col] == '1' &&  nodes[row+1][col] == 0){
            nodes[row+1][col] = flag;
            connect(row+1, col, grid, nodes, flag);
        }
        if(col > 0 && grid[row][col-1] == '1' && nodes[row][col-1] == 0){
            nodes[row][col-1] = flag;
            connect(row, col-1, grid, nodes, flag);
        }
        if(col < grid[0].length-1 && grid[row][col+1] == '1' && nodes[row][col+1] == 0){
            nodes[row][col+1] = flag;
            connect(row, col+1, grid, nodes, flag);
        }
        return;
        
    }
}
/*
Should circle back to this problem bc there are other good solutions available.
*/
