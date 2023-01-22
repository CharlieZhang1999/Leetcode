class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        char [] c = s.toCharArray();
        reverse(c, 0, n-1);
        reverseWord(c, n);
        return cleanSpace(c, n);
    }
    public void reverseWord(char [] c, int n){
        int i = 0, j = 0;
        while(j < n){
            // increment i to the first char of the word
            while(i < j || (i < n && c[i] == ' ')) i++;
            // increment j to the blankspace at the end of the word
            while(j < i || (j < n && c[j] != ' ')) j++;
            reverse(c, i, j-1);
        }        
    }
    
    public String cleanSpace(char [] c, int n){
        int i = 0, j = 0;
        while(j < n){
            // skip all the space before the word
            while(j < n && c[j] == ' ') j++;
            
            // copy all the non-space part
            while(j < n && c[j] != ' ') c[i++] = c[j++];
            
            // skip all the space after the word. This one is neccessary since words like "  hello world  " after reversing, there are spaces after "hello" but there are no word after hello. So you have to get over all the blankspace to see if we reach the end. If we are sure we reach the end, then there is no need to add ' ' after hello.
            while(j < n && c[j] == ' ') j++;
            if(j < n){
                c[i++] = ' ';
            }
        }
        return new String(c).substring(0, i);
    }
    
    
    public void reverse(char [] c, int i, int j){
        while(i < j){
            char temp = c[i];
            c[i++] = c[j];
            c[j--] = temp;
        }
    }
}