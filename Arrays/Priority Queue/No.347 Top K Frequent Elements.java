class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int [] res = new int[k];
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[1]-b[1];
            }
        });
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i:nums){
            //map.putIfAbsent(i, 1);
            map.put(i, map.getOrDefault(i,0)+1);
        }
        
        /*for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            
        }*/
        int [] temp;
        for(Integer i:map.keySet()){
            if(queue.size() < k){
                queue.offer(new int[]{i, map.get(i)});
            }
            else{
                temp = queue.peek();
                if(map.get(i) > temp[1]){
                    queue.poll();
                    queue.offer(new int[]{i, map.get(i)});
                }
            }
        }
        
        for(int i = 0; i < k; i++){
            res[i] = queue.poll()[0];
        }
        
        return res;
         
    }
}