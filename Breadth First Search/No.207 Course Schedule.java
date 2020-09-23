class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int edges [][] = new int[numCourses][numCourses];
        int incomingDegrees[] = new int[numCourses];
        int course_explored = 0;
        for(int i = 0; i < prerequisites.length; i++){
            int from_node = prerequisites[i][0];
            int to_node = prerequisites[i][1];
            if(edges[from_node][to_node] == 0){
                edges[from_node][to_node] = 1;
                incomingDegrees[to_node]++; 
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(incomingDegrees[i] == 0) queue.offer(i);
        }
        while(!queue.isEmpty()){
            int node = queue.poll();//this node is explored
            course_explored++;
            for(int i = 0; i < edges[node].length; i++){
                if(edges[node][i] > 0) {
                    edges[node][i]--;
                    incomingDegrees[i]--;
                    if(incomingDegrees[i] == 0) queue.offer(i);
                }
            }
        }
        return numCourses == course_explored;
    }
}
/*
epiphany:
    这就是典型的topological sort，如果没法sort（也就是如果queue并没有遍历所有的nodes），说明不是DAG 存在cycle。
    具体做法：1\把indgree=0的node 加到等着被从graph remove的queue当中
            2\iteration step 1： 如果queue不是empty的，那么从queue中poll一个node出来，从graph里remove掉这个node和相关的edges，并把周围的nodes的indegree做相应调整
            3\iteration step 2：把indegree=0的nodes加到queue里
            4\重复iteration step 1
*/