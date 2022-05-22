class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret = new ArrayList<Integer>();
        
        int[] chars = new int[26];
        int len = p.length();
        // edge case: s < p
        if(s.length()<len){
            return ret;
        }
        
        
        for(Character c:p.toCharArray()){
            chars[c-'a']++;
        }
        
        int start = 0, end = len - 1, diff = len;
        int temp;
        for(int j = 0; j < len; j++){
            temp = s.charAt(j)-'a';
            chars[temp]--;
            if(chars[temp] >= 0){
                diff--;
            }
        }
        
        if(diff == 0){
            ret.add(0);
        }
        
        while(end < s.length()-1){
            temp = s.charAt(start)-'a';
            if(chars[temp] >= 0){
                diff++;
            }
            chars[temp]++;
            
            start+=1;
            end+=1;
            
            temp = s.charAt(end)-'a';
            chars[temp]--;
            
            if(chars[temp] >= 0){
                diff--;
            }
            
            if(diff == 0){
                ret.add(start);
            }
        }
        
        return ret;
    }
}