class Solution {
    public int numSplits(String s) {
        int res = 0;
        if(s.length()<=1) return 1;
        int [] leftBucket = new int[26];
        int [] rightBucket = new int[26];
        int lc = 0, rc = 0;
        
        for(char c: s.toCharArray()){
            if(rightBucket[c-'a']++ == 0){
                rc++;
            }
        }
           
        for(char c: s.toCharArray()){
            if(leftBucket[c-'a']++ == 0){
                lc++;
            }
            if(--rightBucket[c-'a'] == 0){
                rc--;
            }
            if(lc == rc) res++;
            if(lc > rc) break;
        }

        
        return res;
        
    }
}
/*
#tag: String, DP

for(char c: s.toCharArray())应该是比for(int i = 0; ...) s.charAt(i)要快的
记住了 
*/