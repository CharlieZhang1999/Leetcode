class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, HashMap<Integer, Integer>> map = getMap(times);
        
        // Note: a[0] is distance/time from the origin, a[1] is the node number
        Queue<int []> queue = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        queue.offer(new int[]{0, k});
        
        boolean [] visited = new boolean[n+1];
        int curNode = 0, curDist = 0;
        int nextNode = 0, nextDist = 0;
        int N = n;
        int res = 0;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            curDist = cur[0];
            curNode = cur[1];
        
            if(visited[curNode]){
                continue;
            }
            
            res = curDist;
            visited[curNode] = true;
            N--;
            if(map.containsKey(curNode)){
               for(Map.Entry<Integer,Integer> entry: map.get(curNode).entrySet()){
                    nextNode = entry.getKey();
                    nextDist = entry.getValue();
                    queue.offer(new int[]{curDist+nextDist, nextNode});
                } 
            }
            
        }
        return N == 0? res:-1;
    }
    
    
    public HashMap<Integer, HashMap<Integer, Integer>> getMap(int[][] times){
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for(int i = 0; i < times.length; i++){
            int s = times[i][0];
            int d = times[i][1];
            int t = times[i][2];
            
            map.putIfAbsent(s, new HashMap<Integer, Integer>());
            map.get(s).put(d, t);
        }
        return map;
        
    }
    
    
}
/*
#bfs
这道题又让我觉得我有点混淆bfs和dfs了
所以graph的题还是第一眼先判断用bfs还是dfs

思路：
因为是要找从i node到其他所有node的最短路径
那就一个一个推进queue里，把距离累加，然后queue按照距离排序
[distance, node]
比如[2,3]就比[4,3]要优先
然后遇到visited过的比如visited[3]=true 那后面的[4,3]就会被自动pass掉
*/

