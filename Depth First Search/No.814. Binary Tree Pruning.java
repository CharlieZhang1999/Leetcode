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
    public TreeNode pruneTree(TreeNode root) {
        if(removeZero(root)) return null;
        return root;
    }
    
    public boolean removeZero(TreeNode root){
        if(root == null) return true;
        boolean left = removeZero(root.left);
        boolean right = removeZero(root.right);
        if(root.val == 0 && left && right){
            return true;
        }

        if(left){
            root.left = null;
        }
        if(right){
            root.right = null;
        }
        return false;
        
        
    }
}