class Solution {
    public boolean isMatch(String s, String p) {
        int s_length = s.length(), p_length = p.length();
        
        boolean [][] dp = new boolean [s_length+1][p_length+1];
        
        dp[0][0] = true;
        for(int j = 1; j <= p_length; j++){
            if(p.charAt(j-1) == '*'){
                dp[0][j] = true;
            }
            else{
                break;
            }
        }
        
        char s_char, p_char;
        for(int i = 1; i <= s_length; i++){
            for(int j = 1; j <= p_length; j++){
                s_char = s.charAt(i-1);
                p_char = p.charAt(j-1);
                    
                if(p_char == s_char || p_char== '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p_char == '*'){
                    // case 1: #a, #a*, here * should be empty
                    // case 2: #ab, #a*, here * should be the current alphabet
                    // case 3: #abc, #a*, here * should represent multiple alphabet
                    dp[i][j] = dp[i][j-1] || dp[i-1][j-1] || dp[i-1][j];
                }
            }
        }
        
        return dp[s_length][p_length];
    }
}