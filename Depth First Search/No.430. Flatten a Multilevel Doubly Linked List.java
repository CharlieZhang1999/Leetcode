/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        flattail(head);     
        return head;
    }
    
    public Node flattail(Node head){
        Node cur = head, prev = head;
        while(cur != null){
            if(cur.child != null){
                Node nextNode = cur.next;
                Node tailNode = flattail(cur.child);
                
                tailNode.next = nextNode;
                if(nextNode != null) nextNode.prev = tailNode;
                
                
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
                
                prev = tailNode;
                cur = nextNode;
            }
            else{
                prev = cur;
                cur = cur.next;
            }     
        }

        /* return the last node of this row */
        return prev;
    }
}

/*
思路：
这道题还是挺不好想的
关键在于怎么把每一行的tailNode和上一行的cur.next链接起来
后来发现原来可以return 这个tailNode
这样就可以
tailNode.next = nextNode;
if(nextNode != null) nextNode.prev = tailNode;
*/