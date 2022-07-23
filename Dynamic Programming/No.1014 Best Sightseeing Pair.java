class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int res = 0;
        values[0]--;
        for(int i = 1; i < values.length; i++){
            res = Math.max(values[i]+values[i-1], res);
            values[i] = Math.max(values[i-1], values[i])-1;
        }
        return res;
    }
}

/*
#tag: dp

dp减distance的类型，同类型题目1937
因为是单向（i<j) ， 所以从只用考虑左+右的形式即可，即只要更新从左边起的最大值并放在values[i-1]的位置就行

思路：
1\对于每一个values[i], values[i-1]为从左边起（扣除distance后）能得到的最大值
2\当更新完res后，比较values[i]和values[i-1]哪个更大，谁配做从左边起的最大值捏～？
*/