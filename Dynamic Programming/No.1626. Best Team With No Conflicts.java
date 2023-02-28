class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int [][] pair = new int[n][2];
        for(int i = 0; i < n; i++){
            pair[i][0] = ages[i];
            pair[i][1] = scores[i];
        }
        Arrays.sort(pair, (a, b) -> a[0] == b[0]? a[1]-b[1]:a[0]-b[0]);
        
        int [] dp = new int[n];
        int max = 0;
        
        for(int i = 0; i < n; i++){
            dp[i] = pair[i][1];
            for(int j = 0; j < i; j++){
                if(pair[j][1] <= pair[i][1]){
                    dp[i] = Math.max(dp[i], dp[j] + pair[i][1]);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
/*
思路：
跟No.300一毛一样
https://leetcode.com/problems/best-team-with-no-conflicts/solution/
*/