class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int [][] pairs = new int[nums1.length][2];
        long runningSum = 0;
        for(int i = 0; i < nums1.length; i++){
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }
        
        Arrays.sort(pairs, (a,b) -> b[1]-a[1]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < k; i++){
            runningSum += pairs[i][0];
            pq.offer(pairs[i][0]);
        }
        
        long answer = runningSum * pairs[k-1][1];
        
        
        
        for(int i = k; i < pairs.length; i++){
            runningSum += pairs[i][0] - pq.poll();
            pq.offer(pairs[i][0]);
            
            answer = Math.max(answer, runningSum * pairs[i][1]);
        }
        
        return answer;
    }
}

/*
思路： https://www.youtube.com/watch?v=ax1DKi5lJwk
https://leetcode.com/problems/maximum-subsequence-score/solution/
*/