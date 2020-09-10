import java.util.*;
class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();
        Hashtable<Character, Integer> hashtable = new Hashtable<>();
        //Hashtable<Character, Integer> hashtable = new Hashtable<Character, Integer>();
        for(int i = 0; i < n; i++){
            hashtable.put(s.charAt(i), hashtable.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        for(int i = 0; i < n; i++){
            if(hashtable.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
}