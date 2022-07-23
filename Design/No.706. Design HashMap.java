class MyHashMap {
    private class ListNode{
        int key;
        int val;
        ListNode next;
        ListNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    public ListNode [] nodes = new ListNode[10000];
    public MyHashMap() {
    }
    
    public void put(int key, int value) {
        int idx = getIndex(key);
        if(nodes[idx] == null){
            nodes[idx] = new ListNode(key, value);
            return;
        }
        
        ListNode cur = nodes[idx];
        ListNode prev = cur;
        while(cur != null){
            if(cur.key == key){
                cur.val = value;
                return;
            }
            prev = cur;
            cur = cur.next;
        }        
        
        prev.next = new ListNode(key, value);
        
    }
    
    public int getIndex(int key){
        return Integer.hashCode(key) % nodes.length;
    }
    
    public int get(int key) {
        int idx = getIndex(key);
        if(nodes[idx] == null) return -1;
        ListNode cur = nodes[idx];
        ListNode prev = cur;
        while(cur != null){
            if(cur.key == key){
                return cur.val;
            }
            prev = cur;
            cur = cur.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int idx = getIndex(key);
        if(nodes[idx] == null) return;
        ListNode cur = nodes[idx];
        if(cur.key == key){
            nodes[idx] = cur.next;
            return;
        }
        
        ListNode prev = cur;
        while(cur != null){
            if(cur.key == key){
                prev.next = cur.next;
                return;
            }
            prev = cur;
            cur = cur.next;
        }
    }
}
    
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

/*
tag: Design
思路：
1\用了一个自定义的class ListNode
2\为了防止collision用了ListNode结构，用next连接
3\每个func里有一段cur和prev的代码是可以复用的，目的是为了找到key对应的node。
4\runtime会随着size的变大而变短，因为size越大collision越少。总而言之就是time and memory trade-off
*/}
}
