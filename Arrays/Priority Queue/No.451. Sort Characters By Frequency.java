class Solution {
    public String frequencySort(String s) {
        HashMap<Character, int[]> map = new HashMap<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return b[1]-a[1];
            }
        });
        
        for(char c: s.toCharArray()){
            if(!map.containsKey(c)){
                int [] cur = new int[]{c-'a', 0};
                map.put(c, cur);
            }
            map.get(c)[1]++;
        }
        
        for(int[] value: map.values()){
            queue.offer(value);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            int [] cur = queue.poll();
            for(int i = 0; i < cur[1]; i++){
                sb.append((char) (cur[0]+'a'));
            }
        }
        return sb.toString();        
    }
}
/*
思路：pq + hashmap
*/
