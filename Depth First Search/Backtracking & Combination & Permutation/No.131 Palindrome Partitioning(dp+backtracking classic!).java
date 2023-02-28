class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean [][] dp = new boolean[n][n];
        for(int i = n-1; i >= 0; i--){
            for(int j = i; j < n; j++){
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j-i<3 || dp[i+1][j-1] == true);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        List<String> temp =  new ArrayList<>();
        backtrack(s, ans, temp, dp, 0, n);
        return ans;
    }
    
    public void backtrack(String s, List<List<String>> ans, List<String> temp, boolean [][] dp, int idx, int length){
        if(idx > length-1){
            ans.add(new ArrayList<String>(temp));
            return;
        }
        for(int i = idx; i < length; i++){
            if(dp[idx][i] == true){
                temp.add(s.substring(idx, i+1));
                backtrack(s, ans, temp, dp, i+1, length);
                temp.remove(temp.size()-1);
            }
        }
    }
}
/*
完全是自己想出来的！给他整明白了！
(1)看到palindrome就要想起dp[][]
(2)看到return all possible/generate all possible就可以用backtracking!
*/