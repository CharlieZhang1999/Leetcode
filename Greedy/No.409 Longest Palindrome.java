
class Solution {
    public int longestPalindrome(String s) {
        int [] lowercase = new int[26];
        int [] uppercase = new int[26];
        char [] string = s.toCharArray();
        int index = 0;
        int ans = 0;
        boolean haveOdd = false;
        for(int i = 0; i < string.length; i++){
            index = string[i]-'a';
            if(index < 0){
                uppercase[string[i]-'A']++;
            }
            else{
                lowercase[index]++;
            }
        }
        
        
        for(int i = 0; i < 26; i++){
            if(lowercase[i] % 2 == 1){
                haveOdd = true;
                ans+= (lowercase[i]-1);
            }
            else{
                ans+=lowercase[i];
            }
            
            if(uppercase[i] % 2 == 1){
                haveOdd = true;
                ans+= (uppercase[i]-1);
            }
            else{
                ans+=uppercase[i];
            }
        }
        
        
        return haveOdd?ans+1:ans;
    }
}