class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < dislikes.length; i++){
            int u = dislikes[i][0];
            int v = dislikes[i][1];
            map.putIfAbsent(u, new ArrayList<Integer>());
            map.get(u).add(v);
            
            map.putIfAbsent(v, new ArrayList<Integer>());
            map.get(v).add(u);
        }
        int [] colors = new int[n+1];
        for(int i = 1; i < colors.length; i++){
            if(colors[i] == 0 && !disLike(dislikes, colors, 1, map, i)){
                return false;
            }
        }
        
        return true;
            
        
    }
    
    public boolean disLike(int[][] dislikes, int [] colors, int color, HashMap<Integer, ArrayList<Integer>> map, int index){
        if(colors[index] != 0){
            return colors[index] == color;
        }
        
        colors[index] = color;
        if(map.containsKey(index)){
            for(Integer neighbor: map.get(index)){
                if(!disLike(dislikes, colors, color * -1, map, neighbor)){
                   return false; 
                }
            }
        }
        
        return true;
    }
}
/*
这个题和785一样
只是没有准备好一个[][] 的2d undirected edge array
所以我们要自己搭建一个，用2d array或hashmap都行
然后再dfs
*/