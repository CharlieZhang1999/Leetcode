class Solution {

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Queue<Pair<Integer, Double>> queue = new PriorityQueue<>((a,b) -> Double.compare(b.getValue(), a.getValue()));
        Map<Integer, List<Pair<Integer, Double>>> map = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            int from = edges[i][0], to = edges[i][1];
            map.putIfAbsent(from, new ArrayList<>());
            map.get(from).add(new Pair(to, succProb[i]));
            
            map.putIfAbsent(to, new ArrayList<>());
            map.get(to).add(new Pair(from, succProb[i]));
            
        }
        int [] visited = new int[n];
        queue.offer(new Pair(start, 1.0));
        
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int cur = (int) pair.getKey();
            visited[cur] = 1;
            double prob = (double) pair.getValue();
            if(cur == end) return prob;
            
            for(Pair<Integer, Double> neighborPair: map.getOrDefault(cur, new ArrayList<>())){
                int neighbor = neighborPair.getKey();
                if(visited[neighbor] == 0){
                    queue.offer(new Pair(neighbor, neighborPair.getValue() * prob));
                }
            }
        }
        
        return 0;
        
    }
    

}

/*
思路： dijkistra
每次更新到某个node的最大probabiliy
比如到了1之后，mark 1 as visited，并且通过1的edge更新所有到其他node的权重
然后再到2
再到3...
*/