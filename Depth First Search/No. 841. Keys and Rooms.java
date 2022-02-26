class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> visited = new HashSet<>();
        // visited.add(0);
        visit(rooms, visited, 0);
        return visited.size() == rooms.size(); 
        
    }
    
    public void visit(List<List<Integer>> rooms, HashSet<Integer> visited, int cur){
        visited.add(cur);
        for(Integer key: rooms.get(cur)){
            if(!visited.contains(key)){
                visit(rooms, visited,  key);
            }
        }
    }
}


/*
#dfs

每天都被自己菜醒，是真的
*/