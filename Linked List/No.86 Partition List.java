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
    public ListNode partition(ListNode head, int x) {
        ListNode shead = null;
        ListNode stail = null;
        ListNode elhead = null;
        ListNode eltail = null;
        
        ListNode next = null;
        while(head != null){
            next = head.next;
            head.next = null;
            // if less than x
            if(head.val < x){
                if(shead == null){
                    shead = head;
                    stail = head;
                }
                else{
                    stail.next = head;
                    stail = head;
                }
            }
            // if greater than or equal to x
            else{
                if(elhead == null){
                    elhead = head;
                    eltail = head;
                }
                else{
                    eltail.next = head;
                    eltail = head;
                }
            }
            head  = next;
        }
        
        if(stail != null){
            stail.next =  elhead;
        }
        
        return shead != null? shead:elhead;
        
    }
}
/*
这道题也是左老师那里看到的
如果partition是按照小于pivot，等于pivot，和大于pivot，那么则需要六个指针
如果partition是按照小于pivot，大于等于pivot，那么只需要四个指针
分成n段就需要n*2个指针：一个负责那段的head，一个负责那段的end
*/