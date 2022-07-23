class Solution {
    public int leastInterval(char[] tasks, int n) {
        // int [] count = new int[26];
        HashMap<Character, Integer> map = new HashMap<>();
        int curTime = 0;
        for(char c: tasks){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        // waiting queue
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2-i1);
        // cooldown queue
        Queue<int[]> queue = new LinkedList<>();
        
        for(char c: map.keySet()){
            pq.offer(map.get(c));
        }
        
        while(!pq.isEmpty() || !queue.isEmpty()){
            while(!queue.isEmpty() && queue.peek()[1] <= curTime){
                int num = queue.poll()[0];
                pq.offer(num);
            }
            
            if(!pq.isEmpty()){
                int count = pq.poll()-1;
                if(count > 0){
                    queue.offer(new int[]{count, curTime+n+1});
                }
            }
            // else: idle
            curTime++;
        }
        
        
        return curTime;
    }
    
}
/*
思路：
1\每次保证优先用frequency最大的character，所以waiting_queue我们选择一个PriorityQueue自动排序。
2\冷却队列的话，先推进去的就先cd，先进先出这个特征普通queue我们就能满足，所以cooldown_queue我们选择一个普通queue就够了。
3\每个iteration/time开始的时候，先把冷却好的elements推进waiting_queue（多进一）,然后从waiting_queue里poll出一个freq最大的element，decrement by 1并且推进cooldown_queue（一进一）。
此时如果waiting_queue是空的，那么说明此时没有合适的task冷却完，固为idle状态，只进行time++即可。
*/