class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o2-o1;
            }
        });
        for(int i = 0; i < stones.length; i++){
            queue.offer(stones[i]);
        }
        

        int a = 0, b = 0;
        while(queue.size()>1){
            a = queue.poll();
            b = queue.poll();
            queue.offer(a-b);
        }
        return queue.poll();
    }

}