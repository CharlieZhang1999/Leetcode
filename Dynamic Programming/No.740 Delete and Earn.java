class Solution {
    public int deleteAndEarn(int[] nums) {
        int [] arr = new int[10001];
        int max = 0;
        for(int num: nums){
            arr[num] += num;
            if(num > max){
                max = num;
            }
        }
        
        int [] dp = new int[max+1];
        dp[0] = 0;
        dp[1] = arr[1];
        for(int i = 2; i <= max; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+arr[i]);
        }
        
        return dp[max];
        
    }
}

/*
tag: #dp
变种house robber No.198

思路：
反正大概意思就是对于每个数i, 要不就不取它保持dp[i] = dp[i-1]， 要不就取它dp[i] = dp[i-2] + arr[i]
比如说4，要不就不取它保留到3时候的最大值，要不就取它+到2时候到最大值
行！

难点：
刚开始有点卡壳在想用hashtable和sort来做这道题，但是hashtable是没法取dp[i-1]和dp[i-2]这两个值的，所以达咩
*/