class MedianFinder {
    public PriorityQueue<Integer> maxheap;
    public PriorityQueue<Integer> minheap;
    public MedianFinder() {
        maxheap = new PriorityQueue<Integer>((a,b)->b-a);
        minheap = new PriorityQueue<Integer>((a,b)->a-b);
    }
    
    public void addNum(int num) {
        maxheap.offer(num);
        // case: [2,4], [3,7]
        if(!minheap.isEmpty() && maxheap.peek() > minheap.peek()){
            minheap.offer(maxheap.poll());
        }
        // case:[1,1,2], [3]
        while(maxheap.size() - minheap.size() > 1){
            minheap.offer(maxheap.poll());
        }
        
        // case:[2], [3,4,7]
        while(minheap.size() - maxheap.size() > 1){
            maxheap.offer(minheap.poll());
        }
        
        
    }
    
    public double findMedian() {
        int maxh = maxheap.size();
        int minh = minheap.size();
        return  maxh>minh?maxheap.peek():(maxh<minh?minheap.peek():(double) (maxheap.peek()+minheap.peek())/2);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

/* 
tag: priority-queue
version-1:
两个queue，一个minheap一个maxheap
保证maxheap里的所有数都<minheap里的所有数
1\如果不满足都小于
2\如果两个heap的size相差超过1
则需要balance

同理，findMedian的时候
odd:
(1)如果minheap size > maxheap size,  则输出minheap.peek
(2)如果maxheap size > miheap size, 输出maxheap peek
even:
(3)如果两heap size相等，说明为even, 则输出(minheap peek + maxheap peek) / 2
*/