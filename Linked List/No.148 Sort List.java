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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head, fast = head, prev = head;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next; 
        }
       
        // separate the two linkedlist into half and half
        prev.next = null;
        
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1, l2);
        
    }
    
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode cur = head;
        
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }
            else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
          
        if(l1 != null){
            cur.next = l1;
        }
        else if(l2 != null){
            cur.next = l2;
        }
        
        return head.next;  
    }
}

/*
tag: #two pointer #merge sort

这道题是个top down的merge sort
每一次sortList把一个linkedlist通过two pointer分成two half
然后再调用merge
*/