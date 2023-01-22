class Solution {
    public static int [] parent;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        for(int i = 0; i < pairs.size(); i++){
            union(pairs.get(i).get(0), pairs.get(i).get(1));
        }
        HashMap<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int p = find(i);
            map.putIfAbsent(p, new PriorityQueue());
            map.get(p).offer(s.charAt(i));
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(map.get(find(i)).poll());
        }
        return sb.toString();
    }
    
    public static void union(int x, int y){
        int parent1 = find(x);
        int parent2 = find(y);
        if(parent1 < parent2){
            parent[parent2] = parent1; 
        }
        else{
            parent[parent1] = parent2;
        }
        
    }
    public static int find(int x){
        if(parent[x] != x){
            return find(parent[x]);
        }
        else return x;
    }
}
/*
思路：

咋说呢，就是用uf先把graph 串起来
然后用个pq把对应的character offer进去，再一个个get(parent)的时候poll出来
*/