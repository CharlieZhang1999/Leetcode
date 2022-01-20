class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int [] res = new int[numCourses];
        int [][] prerequisitesEdge = new int[numCourses][numCourses];
        int [] incoming = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            incoming[course]++;
            prerequisitesEdge[prereq][course]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(incoming[i] == 0){
                queue.offer(i);
            }
        }
        
        int course_explored = 0;
        while(!queue.isEmpty()){
            int c = queue.poll();
            res[course_explored] = c;
            course_explored++;
            for(int i = 0; i < numCourses; i++){
                if(prerequisitesEdge[c][i] == 1){
                    prerequisitesEdge[c][i]--;
                    incoming[i]--;
                    if(incoming[i] == 0){
                        queue.offer(i);
                    }
                }
            }
        }
        
        if(course_explored == numCourses){
            return res;
        }
        
        return new int[0];
    }
}
/*
topological sort
和course schedule I一样的套路
[1,0]可以想成是0->1
所以incoming_degree[1] += 1

*/