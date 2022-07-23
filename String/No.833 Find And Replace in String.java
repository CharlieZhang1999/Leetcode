class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < indices.length; i++){
            if(s.startsWith(sources[i], indices[i])){
                map.put(indices[i], i);
            }
            
        }
        
        for(int i = 0; i < s.length(); ){
            if(map.containsKey(i)){
                sb.append(targets[map.get(i)]);
                i+=sources[map.get(i)].length();
            }
            else{
                sb.append(s.charAt(i));
                i++;
            }
        }
        
        
        return sb.toString();
    }
}

/*
其实就两种情况 
对于每个字符来说
1\要不就是被替换(append target)
2\要不就是不变（append source）
*/