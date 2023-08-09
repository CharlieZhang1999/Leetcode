class Solution {
    public int [] dist;
    public HashMap<Integer, Integer> pathMap = new HashMap<>();
    public int m = 1000000000+7;
    HashMap<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>();
    public int countRestrictedPaths(int n, int[][] edges) {
        dist = new int[n+1];
        
        for(int [] edge: edges){
            int from = edge[0], to = edge[1];
            map.putIfAbsent(from, new ArrayList<Pair<Integer, Integer>>());
            map.get(from).add(new Pair(to, edge[2]));
            map.putIfAbsent(to, new ArrayList<Pair<Integer, Integer>>());
            map.get(to).add(new Pair(from, edge[2]));
        }
        doDijkstra(n);
        return path(1, n);
    }
    
    public int path(int node, int target){
        if(node == target) return 1;
        if(pathMap.containsKey(node)){
            return pathMap.get(node);
        }
        int sum = 0;
        for(Pair pair: map.get(node)){
            int neighbor = (int) pair.getKey();
            if(dist[neighbor] < dist[node]) {
                sum =  (sum + path(neighbor, target)) % m;
            }
        }
        pathMap.put(node, sum);
        return sum;
        
        
    }
    
    public void doDijkstra(int end){
        Queue<int []> queue = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int [] a, int [] b){
                return a[1] - b[1];
            }
        });
        
        queue.offer(new int[]{end, 0});
        int k = end;
        int [] visited = new int[end+1];
        while(!queue.isEmpty() && k > 0){
            int [] cur = queue.poll();
            int node = cur[0];
            if(visited[node] == 1) continue;
            
            visited[node] = 1;
            dist[node] = cur[1];
            k--;
            for(Pair pair: map.get(node)){
                int neighbor = (int) pair.getKey();
                if(visited[neighbor] != 1){
                    queue.offer(new int[]{neighbor, cur[1] + (int) pair.getValue()});
                }
            }
            
        } 
    }
}
/*
思路：
dijkstra + dfs
好无敌啊
1、先用dijkstra算出end node到每个node之间的距离，填在dist[]里面
2、接着是一个dfs+memoization，从1开始循环其neighbor，如果它的neighbor到end node的dist < 它到end node的dist，则path(1) += path(neighbor)
*/