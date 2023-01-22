class Solution {
    public int makeConnected(int n, int[][] connections) {
        int m = connections.length;
        int [] parent = new int[n];
        HashSet<Integer> hashSet = new HashSet<>();
        if(m < n - 1) return -1;
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        for(int i = 0; i < m; i++){
            union(connections[i][0], connections[i][1], parent);
        }
        
        for(int i = 0; i < n; i++){
            hashSet.add(findParent(i, parent));
        }
        
        return hashSet.size() - 1;
        
    }
    
    public static int findParent(int x, int [] parent){
        if(parent[x] != x){
            return findParent(parent[x], parent);
        }
        return x;
    }
    
    public static void union(int a, int b, int [] parent){
        int parentA = findParent(a, parent);
        int parentB = findParent(b, parent);
        if(parentA == parentB) return;
        if(parentA < parentB){
            parent[parentB] = parentA;
        }
        else{
            parent[parentA] = parentB;
        }
    }
}
/*
tag: union & find
思路：
都坐下！基本操作！
其实就是uf之后，看一共有几个parents。按理来说如果都connected就只有1个parent对吧
所以如果是3个parents的话，说明有两个isolated clusters，需要额外的(3-1) = 2条edges来connect
那么记录有多少个parents的话，我就直接用了hashset.add()
*/