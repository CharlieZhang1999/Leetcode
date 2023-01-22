class Solution {
    public int [] parent;
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        parent = new int[n];
        class Edge{
            int fromId;
            int toId;
            int distance;
            Edge(int fromId, int toId, int distance){
                this.fromId = fromId;
                this.toId = toId;
                this.distance = distance;
            }
        }
        
        int distance = 0, res = 0, numEdge = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b)->a.distance-b.distance);
        HashSet<Integer> visited  = new HashSet<>();
        
        for(int i = 0; i < n; i++){
            parent[i] = i;
            for(int j = i+1; j < n; j++){
                distance = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                pq.offer(new Edge(i, j, distance));
            }
        }
        
        
        while(!pq.isEmpty() && numEdge < n-1){
            Edge e = pq.poll();
            if(findParent(e.fromId) != findParent(e.toId)){
                // System.out.println(e.fromId+"->"+e.toId);
                union(e.fromId, e.toId);
                // System.out.println(e.distance);
                res += e.distance;
                numEdge++;
            }
            
        }
        return res;
    }
    
    public int findParent(int idx){
        if(parent[idx] == idx) return idx;
        return findParent(parent[idx]);
    }
    
    public void union(int a, int b){
        if(parent[b] != b){
            union(a, parent[b]);
            return;
        }
        
        parent[b] = a;
    }
}
/*
Minimum spanning tree
用priorityqueue和parent[] 进行union & find
无敌！
*/