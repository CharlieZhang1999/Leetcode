class Solution {
    public String reorganizeString(String s) {
        char [] string = s.toCharArray();
        int n = string.length;
        char [] ans = new char[n];
        int [] bucket = new int[26];
        
        for(int i = 0; i < n; i++){
            bucket[string[i]-'a']++;
        }
        
        int max = 0, letterindex = 0;
        for(int i = 0; i < 26; i++){
            if(bucket[i] > max){
                max = bucket[i];
                letterindex = i;
            }
        }
        
        if(max > (n+1) / 2){
            return "";
        }
        
        int idx = 0;
        while(bucket[letterindex] > 0){
            ans[idx] = (char) (letterindex+'a');
            idx +=2;
            bucket[letterindex]--;
        }
        
        for(int i = 0; i < 26; i++){
            while(bucket[i] > 0){
                if(idx > n - 1){
                    idx = 1;
                }
                ans[idx] = (char) (i+'a');
                idx += 2;
                bucket[i]--;
            }
        }
        
        return new String(ans);
        
    }
 }
/*
这是什么脑筋急转弯嘛请问
We construct the resulting string in sequence: at position 0, 2, 4, ... and then 1, 3, 5, ...
In this way, we can make sure there is always a gap between the same characters

Consider this example: "aaabbbcdd", we will construct the string in this way:

a _ a _ a _ _ _ _ // fill in "a" at position 0, 2, 4
a b a _ a _ b _ b // fill in "b" at position 6, 8, 1
a b a c a _ b _ b // fill in "c" at position 3
a b a c a d b d b // fill in "d" at position 5, 7
*/