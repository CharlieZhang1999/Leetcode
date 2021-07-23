/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

/*
这道题就是移形换影大法, 直接change value of the nodeß
4-5-1-9-null 要删除掉node是5
直接5 copy 1的那个node， val变成1，next变成1的next，移形换影done！
*/