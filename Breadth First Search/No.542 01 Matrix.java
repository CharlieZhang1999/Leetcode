class Solution {
    public Queue<int[]> queue;
    public int[][] updateMatrix(int[][] mat) {
        queue = new LinkedList<>();
        int m =  mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    queue.offer(new int[]{i,j});   
                }
                else res[i][j] = -1;
            }
        }
        
        int [][] dirs = new int[][]{{0, -1}, {0,1}, {-1,0}, {1,0}};
        while(!queue.isEmpty()){
            int [] cur = queue.poll();
            int d = res[cur[0]][cur[1]] + 1;
            for(int[] dir:dirs){
                int r = cur[0]+dir[0];
                int c = cur[1]+dir[1];
                if(r<0||r>=m||c<0||c>=n||res[r][c] != -1) continue;
                res[r][c] = d;
                queue.offer(new int[]{r,c});
            }
        }
        return res;
        
    }           
}
/*
#tag: bfs
zero-first bfs
1\put all the zero node into the queue
2\from those zero node, find the nearby one node and update their distance by res[r][c] = res[0 node row][0 node col]+1;
*/