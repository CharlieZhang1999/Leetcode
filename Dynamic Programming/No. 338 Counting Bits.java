class Solution {
    public int[] countBits(int num) {
        int dp [] = new int[num+1];
        int max_power_of_two = 1;
        for(int i = 1; i <= num; i++){
            if(i == max_power_of_two * 2){
                max_power_of_two = i;
            }
            dp[i] = dp[i-max_power_of_two]+1;
        }
        return dp;
    }
}
/*
epiphany:
首先，我们知道的一点是，每逢2的幂，都只有一位是1。
其次，我们联想一下为什么是个dp problem. 比如1是001， 5是101。2是010，6是110.
5被拆解的话是4+1，也就是这个数里最大的2的幂里1的个数（1个）+这个数减掉这个幂之后的数的1的个数
for i, dp[i] = dp[i-max_power_of_two] + 1

步骤:
step 1/ check if there's a new(bigger) max power of two, If so, assign max_power_of_two = i
step 2/ obtain dp[i] by dp[i] = dp[i-max_power_of_two]+1;
*/