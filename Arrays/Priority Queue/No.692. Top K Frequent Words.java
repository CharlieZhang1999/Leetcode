class Solution {
    class Word{
        String s;
        int count;
        Word(String s, int count){
            this.s = s;
            this.count = count;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        HashMap<String, Word> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            if(!map.containsKey(words[i])){
                map.put(words[i], new Word(words[i], 1));
            }
            else{
                map.get(words[i]).count++;
            }
        }
        
        PriorityQueue<Word> pq = new PriorityQueue<>(new Comparator<Word>(){
            @Override
            public int compare(Word a, Word b){
                return a.count == b.count? b.s.compareTo(a.s):a.count - b.count;
            }
        });
        for(Map.Entry<String, Word> entry: map.entrySet()){
            pq.offer(entry.getValue());
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        while(!pq.isEmpty()){
            res.add(0, pq.poll().s);
        }
        
        return res;
    }   
}
/*
priorityQueue
比347稍微复杂一点的是要按lexicographical order再排一下
*/