class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int [] nums_padded = new int[n+2];
        nums_padded[0] = 1;
        nums_padded[n+1] = 1;
        for(int i = 1; i <= n; i++){
            nums_padded[i] = nums[i-1];
        }
        
        int [][] dp = new int[n+2][n+2];
        /* We want dp[1][n] */
        
        // l is length of window 
        for(int l = 1; l <= n; l++){
            // i is start of the window
            for(int i = 1; i <= n - l + 1; i++){
                // j is end of the window
                int j = i + l - 1;
                for(int k = i; k <= j; k++){
                    // if u want to burst k lastly, you are gonna get other coins on the left + ballon[i-1] * ballon[k] * ballon[j+1] + other coins on the right
                    dp[i][j] =  Math.max(dp[i][j], dp[i][k-1] + nums_padded[i-1] * nums_padded[k] * nums_padded[j+1] + dp[k+1][j]);
                }
                
            }
        }
        return dp[1][n];
    }
}

/*
思路：bottom-up dp
0\前提：先要在nums的两边pad两个1，把[3,1,5,8] => [1,3,1,5,8,1]
1\定义：dp[i][j]为burst ballon[i-1...j-1]可以得到的最大coins数量
2\关系：
这个subproblem的关系其实有一点绕，就比如[3,1,5,8], 它的subproblem其实是留哪一个最后burst呢？
如果留3，那么就是burst 3之前能拿到的最大coin + burst [1...8]能拿到的最大coin +  1*3*1 
如果留1， 那么就是burst [3] 的最大coin + burst [5..8]能拿到的最大coin + 1*1*1
如果留5，那么就是burst[3..1]能拿到的最大coin + burst[8]能拿到的最大coin+1*5*1
如果留8，同理

所以burst[3,1,5,8]就是这四种情况中取最大值
我们设最后要留下的ballon的index为k
那么general的表达式就是 dp[i][j] =  Math.max(dp[i][j], dp[i][k-1] + nums_padded[i-1] * nums_padded[k] * nums_padded[j+1] + dp[k+1][j]);

3\参考： https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-312-burst-balloons/
*/
