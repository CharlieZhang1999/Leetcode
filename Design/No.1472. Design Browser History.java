class BrowserHistory {
    class Node{
        Node prev;
        Node next;
        String url;
        Node(String url){
            this.url = url;
        }
    }
    public Node head, cur;
    public BrowserHistory(String homepage) {
        head = new Node(homepage);
        cur = head;
    }
    
    public void visit(String url) {
        cur.next = new Node(url);
        cur.next.prev = cur;
        cur = cur.next;
    }
    
    public String back(int steps) {
        while(steps > 0 && cur.prev != null){
            cur = cur.prev;
            steps--;
        }
        return cur.url;
    }
    
    public String forward(int steps) {
        while(steps > 0 && cur.next != null){
            cur = cur.next;
            steps--;
        }
        return cur.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */

/*
一开始用两个stack感觉特别intuitive
但是时间复杂度很高
后来发现原来用linkedlist更快呢
有个Node cur指向cur pointer就行！
*/