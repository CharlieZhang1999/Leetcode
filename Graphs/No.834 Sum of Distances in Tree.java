class Solution {
    List<Set<Integer>> graph;
    int [] ans;
    int [] count;
    int N;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        ans = new int[n];
        count = new int[n];
        Arrays.fill(count, 1);
        N = n;
        graph = new ArrayList<Set<Integer>>();
        
        
        for(int i = 0; i < n; i++){
            graph.add(new HashSet<Integer>());
        }
        
        // init
        int x = 0, y = 0;
        for(int [] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        dfs1(0, -1);
        dfs2(0, -1);
        return ans;
    }
    
    
    public void dfs1(int node, int parent){
        for(int child:graph.get(node)){
            // 不能以下犯上
            if(child != parent){
                // postorder, 先去孩子那里
                dfs1(child, node);
                // 从孩子那里拿到和，再算
                count[node] += count[child];
                ans[node] += ans[child] + count[child];
            }
        }
    }
    
    public void dfs2(int node, int parent){
        for(int child:graph.get(node)){
            if(child != parent){
                // preorder,  先在自己这里
                ans[child] = ans[node] - count[child] + (N - count[child]);
                // 从自己这里带到孩子那里，算孩子的
                dfs2(child, node);
            }
        }
    }
}