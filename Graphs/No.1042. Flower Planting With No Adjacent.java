class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int [] res = new int[n];
        for(int i = 0; i < paths.length; i++){
            // 0-based index
            int u = paths[i][0]-1;
            int v = paths[i][1]-1;
            
            map.putIfAbsent(u, new ArrayList<Integer>());
            map.get(u).add(v);
            
            map.putIfAbsent(v, new ArrayList<Integer>());
            map.get(v).add(u);
        }
        
        
        
        
        for(int i = 0; i < n; i++){
            int [] colors = new int[5];
            // if no neighbors, give it whatever color
            if(map.get(i) == null){
                res[i] = 1;
                continue;
            }
            for(int nei: map.get(i)){
                colors[res[nei]] = 1;
            }
            
            for(int j = 4; j > 0; j--){
                if(colors[j] != 1){
                    res[i] = j;
                }
            }
        }
        return res;
        
    }
}
/*
从4到1，避开所有邻居的颜色，就行
https://leetcode.com/problems/flower-planting-with-no-adjacent/discuss/290858/JavaC%2B%2BPython-Greedily-Paint
*/