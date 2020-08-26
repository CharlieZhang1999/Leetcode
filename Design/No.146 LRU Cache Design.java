import java.util.*;
class LRUCache {
    private int capacity, count;
    private DoubleLinkedNode head, tail;
    private Hashtable<Integer, DoubleLinkedNode> cache;
    public class DoubleLinkedNode{
        int key;
        int val;
        DoubleLinkedNode pre;
        DoubleLinkedNode post;
    }
    
    public void addNode(DoubleLinkedNode node){
        node.post = head.post;
        node.pre = head;
        head.post.pre = node;
        head.post = node;
        //count = count + 1;
    }
    
    public void removeNode(DoubleLinkedNode node){
        node.post.pre = node.pre;
        node.pre.post = node.post;
        //count = count - 1;
        
    }
    
    public void movetoHead(DoubleLinkedNode node){
        this.removeNode(node);
        this.addNode(node);
    }
    
    public DoubleLinkedNode popTail(){
        DoubleLinkedNode node = tail.pre;
        this.removeNode(node);
        return node;
    }
    
    public LRUCache(int capacity) {
        //initialization
        this.capacity = capacity;
        this.count = 0;
        Hashtable<Integer, DoubleLinkedNode> hashtable = new Hashtable<>();
        cache = hashtable;
        
        this.head = new DoubleLinkedNode();
        this.tail = new DoubleLinkedNode();
        head.post = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        DoubleLinkedNode node = cache.get(key);
        if(node == null){
            return -1;
        }
        this.movetoHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        DoubleLinkedNode node = cache.get(key);
        if(node == null){
            DoubleLinkedNode new_node = new DoubleLinkedNode();
            new_node.key = key;
            new_node.val = value;
            
            cache.put(key, new_node);
            this.addNode(new_node);
            count++;
            if(count > capacity){
                DoubleLinkedNode removed_node = this.popTail();
                cache.remove(removed_node.key);
                count--;
            }
        }
        else{
            node.val = value;
            this.movetoHead(node);
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


/*
精髓：1\DoubleLinkedNode作为一个DLL，来实现更新元素的priority，像一个splay tree一样把元素从most recently used 到 least recently used的顺序sort。
2\Hashtable: 用来储存key对应的node。如果有put操作，就在DLL上添加node或者把已有的node移到最前。当超过capacity时，就踢除最后一个DLL的最后一个node by popTail().
3\所以一个put操作，或一个get操作，一般是双管齐下，在DLL和table中都有对应的操作才行。难点在于，写put的时候，光顾着在DLL里addNode/moveNode了，却忘了在hashtable中也要进行对应的put/remove
*/