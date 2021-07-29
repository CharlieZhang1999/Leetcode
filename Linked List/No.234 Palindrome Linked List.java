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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        // ini
        boolean res = true;
        ListNode n1 = head;
        ListNode n2 = head;
        // mov pointer to the middle
        while(n2.next != null && n2.next.next != null){
            n2 = n2.next.next;
            n1 = n1.next;
        }
        
        // 下中点
        n2 = n1.next;
        n1.next = null;

        ListNode n3 = null;
        // reverse
        while(n2 != null){
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        
        n2 = head;
        n3 = n1;
        while(n1 != null && n2 != null){
            if(n1.val != n2.val){
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        
        n1 = n3.next;
        n3.next = null;
        // restore
        while(n1 != null){
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        
        
        return res;
    }
}

/* 
这次提交，时间复杂度反而比上一次高了，因为这次submission是省空间复杂度的方法，inplace的，只用了额外的三个空间，所有的reverse和restore都只用了那三个变量

上次提交，reverse完全是创建了一个新的linklist，也不用restore，所以时间复杂度上小了很多
*/