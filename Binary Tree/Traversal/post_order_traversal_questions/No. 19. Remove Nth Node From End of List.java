/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode(0, head);
        removeAction(sentinel, n);
        return sentinel.next;
    }
    public int removeAction(ListNode cur, int n){
        if(cur == null){
            return 0;
        }
        int counter = removeAction(cur.next, n) + 1;
        if(counter == n + 1){
            cur.next = cur.next.next;
        }
        
        return counter;
    }
}
/* 
epiphany: 其实这道题哥更应该属于two-pointer类，但是我前些天做post order traversal的时候（准确的说是No.114）有了些灵感，recursion可以达成的一个goal就是从后往前traversal。既然如此，那我们定义一个counter，等到最后一个node的时候开始计1，接着2，3，....n不就可以了吗

1\先触底，判断是否为最后一个node后面的null，如果是，开始计counter = 0
2\然后逐一往回加，直到加到n+1的时候，说明我们倒了目标node前面的node了，直接cur.next = cur.next.next来remove掉n-th node即可
3\但有个缺点 就是要把整个两个pass走完才行，counter也要return到N（node的总数量）为止，所以没能在一个pass走完。一个pass的solution请看two pointer的folder
*/