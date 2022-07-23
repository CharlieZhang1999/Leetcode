class MyStack {
    Queue<Integer> q1;
    
    public MyStack() {
        q1 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.offer(x);
        int size = q1.size();
        while(size > 1){
            q1.add(q1.remove());
            size--;
        }
        
    }
    
    public int pop() {
        return q1.poll();
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

/*
#tag:Design, Stack
保持新加的那个在第一个，其他保持原序就行！
*/