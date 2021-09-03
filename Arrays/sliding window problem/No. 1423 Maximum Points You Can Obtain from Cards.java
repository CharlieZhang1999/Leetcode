class Solution {
    public int maxScore(int[] cardPoints, int k) {
        // initialization
        int lSum = 0, rSum = 0;
        int n = cardPoints.length;
        
        for(int i = 0; i < k; i++){
            lSum += cardPoints[i];
        }
        int max = lSum;
        for(int i = 0; i < k; i++){
            lSum -= cardPoints[k-1-i];
            rSum += cardPoints[n-1-i];
            max = Math.max(max, lSum+rSum);
        }
        return max;
    }
}
/*
This is a hard-to-see sliding window problem 
You initially start with all k elements starting from left
and then each iteration you slide to the left(which means kick out one left element and add one to the right tail)
Take the largest sum of all the sums
我身骑白马，走三关～
*/