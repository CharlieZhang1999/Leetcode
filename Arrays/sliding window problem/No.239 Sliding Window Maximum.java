class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int [] res = new int[nums.length - k + 1];
        int count = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            if(i >=k && queue.peek() <= i - k){
                queue.poll();
            }
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            queue.offer(i);
            if(i >= k-1){
                res[count++] = nums[queue.peek()];
            }
            
        }
        return res;
    }
}
/*
epiphany: 
    We just need a FIFO queue so that we can update the k numbers in the window easilty by kicking out from the left end and inserting to the right end
    这个题的精髓就是，如果现在这个window里的数比将要加的数小，那全踢出去吧，他们肯定不会成为max的。这样的话，这个window的第一个数肯定就是window里最大的数。比如[-1, -3]将要加入5，那么与其[-1, -3, 5]不如踢掉-1, -3留下[5]，这样直接从window里peek()就是最大的max

solution:
    iterate all index i in nums
    steps:
        don't insert i right now! hold a little bit~
        1\if i-k is still in the queue, kick it out from left end(queue.poll())
        2\from the tail, clean all those <= i since they will never be the max in the future if i is in prescence
        3\insert i and add i to the returned array if i is greater than or equal to k-1.(If k = 3 and i is 1, don't need to add the max right now since we haven't reached the minimum window size)
        4\repeat from step 1
*/