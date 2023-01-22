class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new ArrayList<>();
        
        int [] word2max = new int[26];
        for(String w2: words2){
            int [] count = count(w2);
            for(int i = 0; i < 26; i++){
                word2max[i] = Math.max(word2max[i], count[i]);
            }
        }
        
        loop: for(String w1: words1){
                int [] w1_count = count(w1);
                for(int i = 0; i < 26; i++){
                    if(w1_count[i] < word2max[i]){
                        continue loop;
                    }
                }
                res.add(w1);
        }
        
        return res;
    }
    
    public int[] count(String s){
        char [] arr = s.toCharArray();
        int [] bucket = new int[26];
        for(int i = 0; i < arr.length; i++){
            bucket[arr[i] - 'a']+=1;
        }
        return bucket;
    }
}
/*
思路：
求b中每个字母在每个词中的最高出现频率(Math.max)
然后跟a的每个词对比，看看是不是subset
*/