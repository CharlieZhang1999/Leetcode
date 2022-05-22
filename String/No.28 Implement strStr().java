class Solution {
    public int strStr(String haystack, String needle) {
        int n = needle.length();
        int h = haystack.length();
        if(n < 1) return 0;
        if(h < 1) return -1;
        
        
        for(int i = 0; i < h; i++){
            if(i + n > h) break;
            for(int j = 0; j < n; j++){
                if(needle.charAt(j) != haystack.charAt(i+j)){
                    break;
                }
                
                if(j == n-1){
                    return i;
                }
            }
        }
        return -1;
    }
}