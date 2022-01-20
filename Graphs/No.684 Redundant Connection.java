class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int [] parent = new int[n+1];
        
        for(int i = 0; i < n; i++){
            int parent1 = find(edges[i][0], parent);
            int parent2 = find(edges[i][1], parent);
            if(parent1 == parent2){
                return edges[i];
            }
            
            union(edges[i][0], edges[i][1], parent);
        }
        
        return edges[0];
    }
    
    public int find(int i, int [] parent){
        if(parent[i] == 0){
            return i;
        }
        return find(parent[i], parent);
    }
    
    public void union(int x, int y, int [] parent){
        
        // attention: note thate we need to connect all the former parent
        // eg: if 2 is parent of 1, and now 3 is parent of 1, we need 3 to be parent[1]'s parent.           // So 3 must be parent of 2
        
        if(parent[x] != 0){
            union(parent[x], y, parent);
        }
        parent[x] = y;
        // parent[y] = x;
    }
    
}
/*
#disjoint set #union&find
这道题可谓是disjoint set的最好体现
基本上union&find都要用到dfs的
而我们这里就用一个parent array，parent[i]就指向node i的parent

判断cycle条件：
1\如果一个edge两边的parent一样，说明形成cycle，return这个edge
2\反之，parent不一样，那就需要把她们union起来，变成一个parent

注意：
第34行我什么用parent[x] = y呢
因为这里说明了每个edge[a,b]默认a<b
这样的话我们永远用后面那个大的，方便统一
如果用前面小的话，那么比如[1,4],[3,4] 4的parent就变来变去从1变到3，非常的不好
*/