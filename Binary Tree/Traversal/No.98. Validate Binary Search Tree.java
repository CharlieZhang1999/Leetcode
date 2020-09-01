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
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            
            cur = stack.pop();
            if(prev != null && prev.val >= cur.val){
                return false;
            }
            prev = cur;
            cur = cur.right;
        }
        return true;
    }
}
/*
难点：很难联想到，1\validate bst或者2\找第k个大的元素和traversal能有什么联系。但事实上，做一个inorder traversal。对于1，直接看后一个元素是否总是比前一个大。对于2，也就是inorder traversal的第k个元素
*/