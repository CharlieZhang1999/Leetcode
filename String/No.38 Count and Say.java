class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        
        String ans = "1";
        for(int i = 1; i < n; i++){
            ans = parseString(ans);
        }
        return ans;
    }
    
    public String parseString(String s){
        StringBuilder sb = new StringBuilder();
        char [] arr = s.toCharArray();
        char c = arr[0];
        int count = 1;
        
        for(int i = 1; i < s.length(); i++){
            if(arr[i] == c){
                count++;
                continue;
            }
            else{
                sb.append(count);
                sb.append(c);
                c = arr[i];
                count = 1;
            }
        }
        sb.append(count);
        sb.append(c);
        return sb.toString();
    }
}
/*
StringBuilder sb = new StringBuilder()
StringBuilder比String.valueOf快很多
*/