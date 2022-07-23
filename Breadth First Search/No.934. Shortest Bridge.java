class Solution {
    public Queue<int[]> queue;
    public int shortestBridge(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int r = 0, c = 0;
        queue = new LinkedList<>();
        
        int [] firstIsland = findOne(grid, m, n);
        int[][] dirs = new int[][]{{0,-1}, {0,1}, {-1,0}, {1,0}};
        int[][] visited = new int[m][n];
        dfs(firstIsland[0], firstIsland[1], grid, visited, dirs);
        
        
        int d = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                int [] cur = queue.poll();
                for(int [] dir:dirs){
                    int next_r = cur[0] + dir[0];
                    int next_c = cur[1] + dir[1];
                    if(next_r < 0 || next_r >= grid.length || next_c < 0 || next_c>= grid[0].length ||visited[next_r][next_c] == 1) continue;
                    
                    int [] new_rc = new int[]{next_r, next_c};
                    if(grid[next_r][next_c] == 0){
                        visited[next_r][next_c] = 1;
                        queue.offer(new_rc);
                    }
                    
                    else if(grid[next_r][next_c] == 1){
                        return d;
                    }
                }
                size--;
            }
            d++;
        }
        
        return 0;
        
    }
    
    
    public void dfs(int r, int c, int[][] grid, int[][] visited, int[][] dirs){
        visited[r][c] = 1;
        // System.out.println("visited "+r +","+c);
        queue.offer(new int[]{r,c});
        for(int [] dir:dirs){
            int next_r = r+dir[0];
            int next_c = c+dir[1];
            if(next_r < 0 || next_r >= grid.length || next_c < 0 || next_c>= grid[0].length || grid[next_r][next_c] != 1 || visited[next_r][next_c] == 1) continue;
            dfs(next_r, next_c, grid, visited, dirs);
        }
    }
    
    public int[] findOne(int[][] grid, int m, int n){
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{0,0};
    }
}
/*
Yeah~ 自己做出来了934！dfs+bfs！
思路大概就是先用dfs把一个island给通遍，全加入queue里
然后再用bfs把这个island附近的0都加到queue里
哪边先到另外一个island就直接输出d，即距离。
*/