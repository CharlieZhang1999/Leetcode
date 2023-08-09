class Solution {
    private class UnionFind{
        int [] representative;
        int [] componentSize;
        int components;
        
        UnionFind(int n){
            representative = new int[n+1];
            componentSize = new int[n+1];
            for(int i = 0; i < n; i++){
                representative[i] = i;
                componentSize[i] = 1;
            }
            components = n;
        }
        
        public boolean isConnected(){
            return components == 1;
        }
        
        public int findRepresentative(int x){
            if(representative[x] == x) return x;
            return findRepresentative(representative[x]);
        }
        
        public int union(int x, int y){
            int representativeX = findRepresentative(x);
            int representativeY = findRepresentative(y);
            if(representativeX == representativeY) return 0;
            
            if(componentSize[representativeX] > componentSize[representativeY]){
                representative[representativeY] = representativeX;
                componentSize[representativeX] += componentSize[representativeY];
            }
            else{
                representative[representativeX] = representativeY;
                componentSize[representativeY] += componentSize[representativeX];
            }
            components--;
            return 1;
        }
        
        
    }
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind alice = new UnionFind(n);
        UnionFind bob = new UnionFind(n);
        int edgeRequired = 0;
        
        for(int [] edge: edges){
            if(edge[0] == 3){
                edgeRequired += alice.union(edge[1], edge[2]) | bob.union(edge[1], edge[2]);
            }
        }
        
        for(int [] edge: edges){
            if(edge[0] == 1){
                edgeRequired += alice.union(edge[1], edge[2]);
            }
            
            if(edge[0] == 2){
                edgeRequired += bob.union(edge[1], edge[2]);
            }
        }
        
        if(alice.isConnected() && bob.isConnected()){
            return edges.length - edgeRequired;
        }
        
        return -1;
    }
}

/*
思路：
好久没做Union Find了
总结一下UF有以下几个方法：
1.constructor
2.isConnected
3.union or connect
4.findRepresentative

这道题就是alice和bob各一个uf。
initialize一个变量edgeRequired = 0
然后优先type == 3的，这个可以调alice 和 bob两个uf的union方法，然后edgeRequired += union的结果（如果可以union就return 1，已经在一个set的话就return 0）
再traverse type == 1或type == 2的，同样也对edgeRequired increment
最后就用所有的edge数量 - edgeRequired = edgeRemoved
*/