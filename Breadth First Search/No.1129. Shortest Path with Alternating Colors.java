class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int [] ans = new int[n];
        Arrays.fill(ans, -1);
        Queue<int[]> queue = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> redNeighbors = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> blueNeighbors = new HashMap<>();
        for(int [] edge: redEdges){
            redNeighbors.putIfAbsent(edge[0], new ArrayList<Integer>());
            redNeighbors.get(edge[0]).add(edge[1]);
        }
        for(int [] edge: blueEdges){
            blueNeighbors.putIfAbsent(edge[0], new ArrayList<Integer>());
            blueNeighbors.get(edge[0]).add(edge[1]);
        }
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});
        
        HashMap<Integer, ArrayList<Integer>> tempNeighbor;
        int [] redVisited = new int[n];
        int [] blueVisited = new int[n];
        redVisited[0] = blueVisited[0] = 1;
        
        int [] tempVisited;
        int steps = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                int [] cur = queue.poll();
                int curNode = cur[0];
                ans[curNode] = ans[curNode] >= 0? Math.min(ans[curNode], steps):steps;
                
                tempNeighbor = cur[1] == 0? redNeighbors:blueNeighbors;
                tempVisited = cur[1] == 0? redVisited:blueVisited;
                
                if(tempNeighbor.containsKey(curNode)){
                    for(Integer node: tempNeighbor.get(curNode)){
                        if(tempVisited[node] == 1) continue;
                        queue.offer(new int[]{node, 1-cur[1]});
                        tempVisited[node] = 1;
                    }
                }
                size--;
            }
            steps++;
        }
        
        return ans;
    }
}
/*
思路：
https://zxi.mytechroad.com/blog/graph/leetcode-1129-shortest-path-with-alternating-colors/
简简单单breadth first search/level first search
轻松拿下
queue里面的“nodes”其实是（Node, color)的形式
我们在此认red = 0, blue = 1
比如 (0,0)就代表0号Node，下一个是red edge的情况。那么每当poll出一个edge, edge[1]就是其color，可以根据这个对应的color调出对应的map和visited
如果下一个是red edge，那就去red Edges map里找所有可以去的node，如果该node没有被visited过，queue.offer(node, 1-color)。
*/