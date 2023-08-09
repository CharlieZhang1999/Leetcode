class Solution {
    public HashMap<String, Integer> map = new HashMap<>();
    public int res = 0;
    public int equalPairs(int[][] grid) {
        for(int [] row: grid){
            insert(row);
        }
        
        for(int j = 0; j < grid[0].length; j++){
            search(grid, j);
        }
        
        return res;
    }
    
    
    public void insert(int [] row){
        StringBuilder sb = new StringBuilder();
        for(int num: row){
            sb.append(num);
            sb.append(',');
        }
        String key = sb.toString();
        map.put(key, map.getOrDefault(key, 0)+1);
    }
    
    public void search(int [][] grid, int col){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < grid.length; i++){
            sb.append(grid[i][col]);
            sb.append(',');
        }
        
        String query = sb.toString();
        res += map.getOrDefault(query, 0);
    }
    
    
    
}