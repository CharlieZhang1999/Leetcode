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
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenhead = even;
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        if(even != null){
            even.next = null;
        }
        odd.next = evenhead;
        return head;
    }
}
/* strategy：
1\这一关，pointer = pointer.next.next这种隔山打牛简直是t下水道级别的，因为这个赋值的前提就是pointer和pointer.next都不为null，判断这两个很麻烦

2\t0是什么呢，就是打配合，odd和even不是错一个嘛，如果even.next有（这就是odd.next.next)，就赋值给odd，再判断如果odd.next有（这就是even.next.next)，就赋值给even。两个pointer就是钎九双c啊！*/