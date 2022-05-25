/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode firstElement, secondElement;
    public TreeNode prev;
    public void recoverTree(TreeNode root) {
        prev = new TreeNode(Integer.MIN_VALUE);
        visitInOrder(root);

        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;

    }
    
    public void visitInOrder(TreeNode root){
        if(root == null) return;
        visitInOrder(root.left);
        if(firstElement == null && root.val < prev.val){
            firstElement = prev;
        }
        
        if(firstElement != null && root.val < prev.val){
            secondElement = root;
        }
    
        prev = root;
        visitInOrder(root.right);
    }
}
/*
The point is: find the first element that is larger than its next element and find the last element that is smaller than its prev element.

eg: [6,3,4,5,2]
6 > 3 so firstElement = 6(and temporarily secondElement = 3)
5 > 2 so secondElement = 2
so swap 6 and 2 then it's done


eg: [3,2,1]
3 > 2 so firstElement = 3(and temporarily secondElement = 2)
2 > 1 so secondElement = 1
swap 3 and 1 then it's done


https://leetcode.com/problems/recover-binary-search-tree/discuss/32535/No-Fancy-Algorithm-just-Simple-and-Powerful-In-Order-Traversal
*/