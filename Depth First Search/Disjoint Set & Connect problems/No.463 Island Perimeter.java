class Solution {
    public int islandPerimeter(int[][] grid) {
        int [] ret = new int[1];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    dfs(grid, i, j, ret);
                    break;
                }        
            }
        }
        return ret[0];
    }
    public boolean dfs(int[][] grid, int i, int j, int [] count){
        // System.out.println("now in ("+i+","+j+")");
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return false;
        }
        if(grid[i][j] == 0) return false;
        if(grid[i][j] == 2) return true;
        
        grid[i][j] = 2;
        if(!dfs(grid, i-1, j, count)){
            count[0]++;
        }
        if(!dfs(grid, i+1, j, count)){
            count[0]++;
        }
        if(!dfs(grid, i, j-1, count)){
            count[0]++;
        }
        if(!dfs(grid, i, j+1, count)){
            count[0]++;
        }
        return true;
    }
}

/*
method：dfs
大概就是，定义dfs返回boolean，如果这个格子是0或者已经在board之外，就返回放false
如果这个格子是1，就返回true
这样的话再加一个if else block来累加边的数量
拿右边来举例，如果自己是true但右边返回false，说明有右边这条边，遂+1。

这不就好起来了吗！
*/