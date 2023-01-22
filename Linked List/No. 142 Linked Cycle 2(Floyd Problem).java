/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import java.util.*;
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast_pointer = head;
        ListNode slow_pointer = head;
        boolean isCycle = false;
        while(fast_pointer != null && slow_pointer != null){
            if(fast_pointer.next == null) return null;
            fast_pointer = fast_pointer.next.next;
            slow_pointer = slow_pointer.next;
            if(fast_pointer == slow_pointer){
                isCycle = true;
                break;
            }
        }
        if(isCycle){
            slow_pointer = head;
            while(slow_pointer != fast_pointer){
                slow_pointer = slow_pointer.next;
                fast_pointer = fast_pointer.next;
            }
            return slow_pointer;
        }
        return null;
    }
}
/*
这道题也太神了 Floyd牛皮
epiphany：
“Just make a easier understanding.
Suppose the first meet at step k,the distance between the start node of list and the start node of cycle is s,
and the distance between the start node of cycle and the first meeting node is m. 
Then 2k = (s + m + n1r) = 2(s + m + n2r) ==> s + m = nr. Steps moving from start node to the start of the cycle is just s, moving from m by s steps would be the start of the cycle, covering n cycles. In other words, they meet at the entry of cycle.”
1、设fast 和slow pointer，一个每次2 steps， 一个每次1 step，直到他们的first meeting node
2、然后把其中任意一个赋值为starting node，另一个还是这个first meeting node，两个pointer 同时出发，直至相遇，相遇的点则是circle开始的地方。

所以从starting node出发的pointer，和从first meeting node(m) 出发的pointer，走同样的step（其实就是s steps）,会相遇，相遇的地方就是circle开始的地方，因为m + s = nr
*/