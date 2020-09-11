class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        int n = s.length();
        StringBuilder [] sb = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++){
            sb[i] = new StringBuilder();
        }
        int index = 0;
        while(index < n){
            for(int i = 0; i < numRows && index < n; i++){
                sb[i].append(s.charAt(index++));
            }
            for(int i = numRows - 2; i > 0 && index < n; i--){
                sb[i].append(s.charAt(index++));
            }
        }
        
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < numRows; i++){
            result.append(sb[i]);
        }
        return result.toString();
     }
}