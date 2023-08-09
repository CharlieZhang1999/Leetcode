class Solution {
    public int res = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        int [] sum = new int[k];
        int zeroCount = k;
        backtrack(cookies, 0, k, sum, zeroCount);
        return res;
    }
    
    
    public void backtrack(int [] cookies, int cookieIdx, int k, int [] sum, int zeroCount){
        if(cookies.length - cookieIdx < zeroCount){
            return;
        }
        if(cookieIdx >= cookies.length){
            int curMax = 0;
            for(int i = 0; i < sum.length; i++){
                curMax = Math.max(sum[i], curMax);
            }
            res = Math.min(res, curMax);
            return;
        }
        
        int curCookie = cookies[cookieIdx];
        for(int i = 0; i < k; i++){
            if(sum[i] == 0) zeroCount--;
            sum[i] += curCookie;
            backtrack(cookies, cookieIdx+1, k, sum, zeroCount);
            sum[i] -= curCookie;
            if(sum[i] == 0) zeroCount++;
        
        }
    }
}
/*
哈哈哈哈看起来很难但是还行的一道题
思路： 
1/对于每个cookie，它都有k个选择。时间复杂度是[k^n]
2/但其实剪枝在这里起到很大的作用，从366ms到20ms。首先你看，k是< n的，意味着最优解里每个child肯定是能分到一些cookie而不是0的/所以我们就keep一个zeroCount。一旦一个child的兜从0拿到一个cookie，那么zeroCount--。一旦一个child的兜从cookie数量变到0，则zeroCount++。 每次backtrack的时候，我们如果剩的bag数量小于zeroCount，意味着这样分肯定有小孩没有cookie，意味着这肯定不是最优解，所以不用继续下去了，直接return。
*/