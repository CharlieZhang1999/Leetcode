class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int ans = 0;
        
        for(int num:nums){
            queue.add(num);
        }
        
        while(k > 0){
            queue.add(-queue.poll());
            k--;
        }
        
        while(queue.size() > 0){
            ans += queue.poll();
        }
        return ans;
    }
}
/*
一开始没想到priority queue还是因为没弄清optimal rule

optimal rule：
1\排序
2\每次从最小的数开始negate
3\用negation替换掉原来的数进行下一次排序，重复1-3

所以这不断的negate和排序让priority queue成为了不二之选
*/