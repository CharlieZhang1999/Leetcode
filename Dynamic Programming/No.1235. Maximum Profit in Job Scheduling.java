class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int [][] jobs = new int[n][3];
        for(int i = 0; i < n; i++){
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, new Comparator<int[]>(){
            @Override
            public int compare(int [] a, int [] b){
                return a[1] == b[1]?a[0]-b[0]:a[1]-b[1];
            }
        });
        
        int [] dp = new int[n];
        dp[0] = jobs[0][2];
        for(int i = 1; i < n; i++){
            // assign the current profit first
            dp[i] = jobs[i][2];
            for(int j = i-1; j >= 0; j--){
                if(jobs[j][1] <= jobs[i][0]){
                    dp[i] = Math.max(dp[i], dp[j] + jobs[i][2]);
                    break;
                }
            }
            dp[i] = Math.max(dp[i], dp[i-1]);
        }
        return dp[n-1];
    }
}
/*
tag: DP
思路：
1\先用endTime sort（如果endTime相等就startTime sort)
2\dp[i]代表包括i-th job可以取到的最大profit
3\然后对于每个job，我要不然取 它的profit+endtime比该starttime小的最后一个job，要不然取 dp[i-1]（也就是吧不取该job）
4\这个题的难点就在于想明白从末尾开始找到的第一个dp[j] where j.endTime < i.startTime的这个dp[j]就是最大的我们可以叠加到的profit value。不用再从i-1到0这样traverse了，只要找到一个第一个这样的j就可以break了，剪枝。
*/