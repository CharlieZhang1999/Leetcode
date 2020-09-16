class MinStack {

    /** initialize your data structure here. */
    public Node head;
    public MinStack() {
        head = null;
    }
    
    public void push(int x) {
        if(head == null){
            head = new Node(x, x, null);
        }
        else{
            head = new Node(x, Math.min(x, head.minimum), head);
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.minimum;
    }
    
    public class Node{
        public Node next;
        public int val;
        public int minimum;
        public Node(int val, int minimum, Node next){
            this.val = val;
            this.next = next;
            this.minimum = minimum;
            
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

/*
epiphany：
1、这道题考察了变通能力，一定要用stack做stack的题吗？其实万物皆可linkedlist（狗头。只不过我们这次要自己写一个linkedlist node class，为啥呢～看2
2、因为这道题的应对策略在于每个node都存一个当前的最低minimum，所以minimum成了一个attribute，每个node都保存着。如果top node被pop了，那么minimum就是当前的top node的当前minimum。利用了stack structure中node 顺序不会变的道理。
*/