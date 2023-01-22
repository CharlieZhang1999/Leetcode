class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int [] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i = 1; i <= n; i++){
            int maxHeight = 0, sum = 0;
            for(int j = i; j >= 1; j--){
                sum += books[j-1][0];
                if(sum > shelfWidth) break;
                maxHeight = Math.max(maxHeight, books[j-1][1]);
                dp[i] = Math.min(dp[i], dp[j-1] + maxHeight); 
            } 
        }
        return dp[n];
    }
}
/*
思路：
https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-1105-filling-bookcase-shelves/
比如求dp[i] 相当于把i parition成前j个以及A[j+1...i]且A[j+1...i]能放进一排（width加起来<shelfWidth)
dp[i] = Math.min(dp[i], dp[j-1] + maxHeight); 

讲道理，说实话，有点像1043
*/