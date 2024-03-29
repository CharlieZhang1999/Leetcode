class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int [][] lcs = new int[m+1][n+1];
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(nums1[i-1] == nums2[j-1]){
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                }
                else{
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }
        
        return lcs[m][n];
    }
}

/*
思路：
怎么说呢，经典lcs
你会发现，看起来很难一道题，它本质上就是longest common sequence...

它也可以用recursion with memoization做，也可以用dp。

*/