class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>(){
            @Override
            public int compare(int [] a, int [] b){
                return a[0]-b[0];
            }
        });
        int n = pairs.length;
        int [] dp = new int[n];
        // dp[0] = 1;
        Arrays.fill(dp, 1);
        for(int i = 1; i < n; i++){
            for(int j = i - 1; j >=0; j--){
                if(pairs[i][0] > pairs[j][1]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    break;
                }
            }
        }
        return dp[n-1];
        
    }
}