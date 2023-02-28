class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, res = 0, max_len = 0;
        // len[i] 表示以i结尾的最长lis
        int [] len = new int[n];
        
        // cnt[i] 表示有多少条longest increasing的路径可以到i
        int [] cnt = new int[n];
        for(int i = 0; i < n; i++){
            // initialization
            len[i] = cnt[i] = 1;
            
            // update
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    if(len[i] == len[j] + 1){
                        cnt[i] += cnt[j];
                    }
                    else if(len[i] < len[j] + 1){
                        len[i] = len[j]+1;
                        cnt[i] = cnt[j];
                    }
                }    
            }
            
            // 对于[1,3,5,4,7]来说
            // 如果是共同最大的length，比如4结尾的长度也是3，那么res += cnt[3] （increment）
            // 如果是单独最大的length， 比如7结尾的时候长度是4，那么res = cnt[4] （直接赋值）
            if(len[i] == max_len){
                res += cnt[i];
            }
            else if(len[i] > max_len){
                max_len = len[i];
                res = cnt[i];
            }
        }
        return res;
    }
}
/*
思路：
tag: dp, longest increasing subsequence
https://leetcode.com/problems/number-of-longest-increasing-subsequence/discuss/107293/JavaC%2B%2B-Simple-dp-solution-with-explanation
*/