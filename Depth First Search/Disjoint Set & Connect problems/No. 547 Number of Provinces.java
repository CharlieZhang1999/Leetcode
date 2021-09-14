class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int [] visited = new int[n];
        int count = 0;
        for(int i = 0; i < n; i++){
            if(visited[i] == 1){
                continue;
            }
            dfs(isConnected, visited, i);
            count++;
        }
        return count;
    }
    
    public void dfs(int[][] isConnected, int[] visited, int i){
        for(int j = 0; j < isConnected.length; j++){
            if(isConnected[i][j] == 1 && visited[j] == 0){
                visited[j] = 1;
                dfs(isConnected, visited, j);
            }
        }
    }
}
/*
This is a typical disjoint set problem. Similar to Number Of Islands
Any question that alikes Union find can be solved using dfs. 

Method: dfs
Explanation: Basically u just use depth-first search to connect/visit all the nodes you can through this route.
And then start another route to connect/visit all the nodes. 
Until all the nodes are connected/visited, then return the number of routes.
*/