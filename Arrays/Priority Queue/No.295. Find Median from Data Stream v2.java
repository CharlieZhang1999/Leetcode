class MedianFinder {
    public PriorityQueue<Integer> small;
    public PriorityQueue<Integer> large;
    public boolean even = true;
    public MedianFinder() {
        small = new PriorityQueue<Integer>((a,b)->b-a);
        large = new PriorityQueue<Integer>((a,b)->a-b);
    }
    
    public void addNum(int num) {
        // case: even->odd的时候，无条件加给small
        if(even){
            large.offer(num);
            small.offer(large.poll());
        }
        // case: odd -> even的时候，加给large
        else{
            small.offer(num);
            large.offer(small.poll());
        }
        
        even = !even;
    }
    
    public double findMedian() {
        if(!even){
            return small.peek();
        }
        else{
            return (double)(small.peek() + large.peek())/2;
        }
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
version-2:
两个queue，一个small一个large
相比于上一个version用比较和while来保持small里的数永远小于large里的数
这个version先把数字放进small里，然后从small里挑一个最大的给large，这样就能保持这个顺序。（或者先放进large里，再从large挑一个最小的给small）

*/