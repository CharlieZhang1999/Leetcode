/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        Node cur = head;
        Node new_head = new Node(cur.val);
        Node new_cur = new_head;
        while(cur.next != null){
            new_cur.next = new Node(cur.next.val);
            cur = cur.next;
            new_cur = new_cur.next;
            
        }
        while(cur != null){
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        
        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
        
    }
}
/*
今天做的这个是hashtable/hashmap版本的
难点：
    1、之前一直想不用map，觉得没必要用hashmap啊，用一次iteration把所有的next给串好，这样所有的nodes都有了copy之后，再copy random的指针不就行了。后来发现自己真是天       真，因为你copy random pointer的时候你并不知道在新的copy里的这个node的random pointer该指向谁，因为你即使知道node.random.val也没法access到它呀。所以这就是 hashmap在这里的必要性：以old node和new node的关系把他们串起来。当要copy random的时候，new_node.random = map.get(old_node.random).通过old node来access那个未知的random。所以hashmap在这里的目的颇有点寻址的意味。

做法：
1、map<old_node, new_node>
2、new_node.next = old.node.next
   new_node.random = old.node.random