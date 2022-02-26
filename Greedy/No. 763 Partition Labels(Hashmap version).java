class Solution {
    public List<Integer> partitionLabels(String s) {
        char [] string = s.toCharArray();
        HashMap<Character, int[]> map = new LinkedHashMap<>();
        for(int i = 0; i < string.length; i++){
            if(!map.containsKey(string[i])){
                map.put(string[i], new int[]{i, i});
            }
            else{
                // update the last occurence position
                map.get(string[i])[1] = i;
                
            }
        }
        
        List<Integer> result = new ArrayList<>();
        int waitingStart = 0;
        int waitingEnd = 0;
        
        for(Map.Entry<Character, int[]> entry: map.entrySet()){
            int curStart = entry.getValue()[0];
            int curEnd = entry.getValue()[1];
            
            // case: overlap
            if(waitingEnd >= curStart){
                waitingEnd = Math.max(waitingEnd, curEnd);
            }
            // case: not overlap
            else{
                // close that interval and figure out the length
                result.add(waitingEnd-waitingStart+1);
                // update the waiting interval
                waitingStart = curStart;
                waitingEnd = curEnd;
            }
        }
        
        // add the last interval
        result.add(waitingEnd-waitingStart+1);
        
        return result;
      
    }
}

/*
朕疲惫了
其实就是合并interval

思路：
先排序，然后合并，排序是必须！
排序可以:(1)用LinkedHashMap preserve order (2)用Arrays.sort() 但这道题显然用1简单一点
LinkedHashMap can preserve order, but HashMap cannot!

*/