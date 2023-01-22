class Solution {
    public class Cell{
        int maxDist;
        int row, col;
        Cell(int row, int col, int dist){
            this.row = row;
            this.col = col;
            this.maxDist = dist;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int num_rows = heights.length;
        int num_cols = heights[0].length;
        int [][] distance = new int[num_rows][num_cols];
        for(int i = 0; i < num_rows; i++){
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        boolean [][] visited = new boolean[num_rows][num_cols];
        PriorityQueue<Cell> queue = new PriorityQueue<>((a,b)->(a.maxDist-b.maxDist));
        int [][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        
        Cell initialCell = new Cell(0,0,0);
        queue.offer(initialCell);
        while(!queue.isEmpty()){
            Cell cur = queue.poll();
            if(cur.row == num_rows-1 && cur.col == num_cols - 1){
                return cur.maxDist;
            }
            distance[cur.row][cur.col] = Math.min(cur.maxDist, distance[cur.row][cur.col]);
            visited[cur.row][cur.col] = true;
            for(int [] dir:dirs){
                int nextRow = cur.row + dir[0];
                int nextCol = cur.col + dir[1];
                if(nextRow < 0 || nextRow >= heights.length || nextCol < 0 || nextCol >= heights[0].length || visited[nextRow][nextCol]){
                    continue;
                }
                int curDistance = Math.abs(heights[nextRow][nextCol] - heights[cur.row][cur.col]);
                int maxDistance = Math.max(curDistance, cur.maxDist);
                if(distance[nextRow][nextCol] > maxDistance){
                    distance[nextRow][nextCol] = maxDistance;
                    queue.offer(new Cell(nextRow, nextCol, maxDistance));
                }      
            }
        }
        return 0;
    }
}
/*
经典Dijkstra
*/