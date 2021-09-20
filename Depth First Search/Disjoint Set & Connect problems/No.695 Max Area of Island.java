import java.lang.Math;
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int [] count = new int[1];
        int maxArea = 0;
        for(int i = 0 ; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    dfs(grid, i, j, count);
                }
                //System.out.print(grid[i][j]);
                maxArea = Math.max(count[0], maxArea);
                count[0] = 0;
            }
        }
        return maxArea;
    }
    
    public void dfs(int[][] grid, int i, int j, int[] count){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        if(grid[i][j] != 1) return;
        
        // change the number to 2 and increment count
        count[0]++;
        grid[i][j] = 2;
        
        
        dfs(grid, i-1, j, count);
        dfs(grid, i+1, j, count);
        dfs(grid, i, j-1, count);
        dfs(grid, i, j+1, count);
        return;
    }
}
/*
方法：简单的dfs
这道题用int []是为了可以通过地址直接操作和修改数值，如果只传个int进去没有办法直接在上面修改数值传到下一个里
遍历过的1就变成2，这样就不会再进去了（改格子为*或者2 真的是dfs的一大利器啊）
*/