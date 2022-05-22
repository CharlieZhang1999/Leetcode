class Solution {
    public int rotten;
    public int orangesRotting(int[][] grid) {
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    rotdfs(grid, i, j, 2);
                }
            }
        }
        
        // 2 now is 2 but should be 0 minute. So by the end minute should subtract 2.
        int minutes = 2;
        for(int[] row: grid){
            for(int cell: row){
                if(cell == 1) return -1;
                minutes = Math.max(minutes, cell);
            }
        }
        return minutes-2;
        
    }
    
    public void rotdfs(int[][] grid, int i, int j, int minute){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || 
           // empty cell
           grid[i][j] == 0 ||
           // already rotten by other orange cell
           (1 < grid[i][j] && grid[i][j] < minute)) return;
        
        // 2 now is 2 but should be 0 minute. So minute should subtract 2.
        grid[i][j] = minute;
        rotdfs(grid, i-1, j, minute+1);
        rotdfs(grid, i+1, j, minute+1);
        rotdfs(grid, i, j-1, minute+1);
        rotdfs(grid, i, j+1, minute+1);
        
    }
}