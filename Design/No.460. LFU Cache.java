class LFUCache {
    class Node{
        public Node prev;
        public Node next;
        public int key;
        public int val;
        public int counter;
        Node(int key, int val){
            this.key = key;
            this.val = val;
            this.counter = 1;
        }
    }
    
    class LRU{
        public Node head;
        public Node tail;
        public int size;
        LRU(){
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }
        
        public void addToHead(Node node){
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
            size++;
        }
        
        public void remove(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        
        public int popTail(){
            Node tailNode = tail.prev;
            this.remove(tailNode);
            return tailNode.key;
        }
    }
    
    public HashMap<Integer, Node> nodeMap;
    public HashMap<Integer, LRU> freqMap;
    public int capacity;
    public int size;
    
    public LFUCache(int capacity) {
        nodeMap = new HashMap<>();
        freqMap = new HashMap<>();
        this.capacity = capacity;
        size = 0;
    }
    
    public int get(int key) {
        if(!nodeMap.containsKey(key)){
            return -1;
        }
        Node node = nodeMap.get(key);
        update(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;
        Node res = nodeMap.get(key);
        if(res != null){
            res.val = value;
            // call update() to increment counter
            update(res);
            return;
        }
        
        Node node = new Node(key, value);
        nodeMap.put(key, node);
        LRU curLRU = freqMap.getOrDefault(1, new LRU());
        curLRU.addToHead(node);
        size++;
        if(size > capacity){
            if(curLRU.size > 1){
                int removedKey = curLRU.popTail();
                nodeMap.remove(removedKey);
                size--;
            }
            else{
                for(int i = 2; ;i++){
                    if(freqMap.containsKey(i) && freqMap.get(i).size > 0){
                        LRU thisLRU = freqMap.get(i);
                        int removedKey = thisLRU.popTail();
                        nodeMap.remove(removedKey);
                        size--;
                        break;
                    }
                }
            } 
        }
        freqMap.put(1, curLRU);
    }
    
    public void update(Node node){
        int counter = node.counter;
        // Delete node from the original LRU
        LRU prevLRU = freqMap.get(node.counter);
        prevLRU.remove(node);
        // increment counter
        node.counter++;
        // new LRU
        LRU newLRU = freqMap.getOrDefault(node.counter, new LRU());
        // Add node to the new LRU
        newLRU.addToHead(node);      
        // update freqMap
        freqMap.put(node.counter, newLRU);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/*
tag: #Design #HashTable
思路：
既然既需要frequency，又需要least recently used，干脆就使用LRU的思想，在hashmap里再嵌套一个LRU,就变成了LFU.
HashMap的key为freq，val为LRU list.即每一层的LRU都有相等的counter。这样每次超过capacity需要removeNode的时候，直接从counter为1的LRU里开始找（如果为1的LRU size为0的话就从2～N里找，然后LRU popTail()即可）

时间复杂度；
我一开始是把increment counter的implementation写在get()里，然后每次put都调用get()来更新counter。跑了一下发现时间太慢了，后来就把更新counter的implementation单独写在一个function update()里，然后get()和put()都会调用update()，这样就节省了很多不必要的get()里的步骤

*/