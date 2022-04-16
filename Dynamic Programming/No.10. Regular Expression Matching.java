class Solution {
    public boolean isMatch(String s, String p) {
        int s_length = s.length();
        int p_length = p.length();
        boolean [][] M = new boolean[s_length+1][p_length+1];
        // M[i][j] means if first i characters in s match first j characters in p
        
        M[0][0] = true;
        
        // declare variables
        char s_char;
        char p_char;
        char prev_p_char;
        
        
        for(int j = 2; j < p_length+1; j+=2){
            p_char = p.charAt(j-1);
            if(p_char == '*' && M[0][j-2]){
                M[0][j] = true;
            }
        }
        
        
        
        
        
        for(int i = 1; i < s_length+1; i++){
            for(int j = 1; j < p_length+1; j++){
                s_char = s.charAt(i-1);
                p_char = p.charAt(j-1);
                
                if(p_char == s_char){
                    M[i][j] = M[i-1][j-1];
                }
                
                else if(p_char == '.'){
                    M[i][j] = M[i-1][j-1];
                }
                
                else if(p_char == '*'){
                    prev_p_char = p.charAt(j-2);
                    
                    // case 0: ad, ab*  -- here b* should be "" (0 occurence) -- M[i][j] = M[i][j-2]
                    if(prev_p_char != s_char && prev_p_char != '.'){
                        M[i][j] = M[i][j-2];
                    }
                    else{
                        // case 1: #a, #a*a, here a*should be empty  ---- M[i][j-2]
                        // case 2: #a, #a*, here a* should be a      -----M[i-1][j-2]
                        // case 3: #aaaa, #a*, here a* should be multiple a  -- M[i-1][j]
                        M[i][j] = M[i][j-2] || M[i-1][j-2] || M[i-1][j];
                    }
                                    
                }
            }
        }
        
        
        return  M[s_length][p_length];
        
    }
}