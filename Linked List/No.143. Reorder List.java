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
    public void reorderList(ListNode head) {
        ListNode sen = new ListNode(0, head);
        ListNode slow = sen;
        ListNode fast = sen;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = reverseList(slow.next);
        slow.next = null;
        
        ListNode cur = head;
        ListNode next = head;
        while(fast != null){
            next = cur.next;
            cur.next = fast;
            fast = fast.next;
            cur.next.next = next;
            cur = next;
        }
    }
    
    public ListNode reverseList(ListNode head){
        ListNode prev = null, next = null;
        ListNode cur = head;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        return prev;
    }
}