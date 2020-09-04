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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.empty()) {
            TreeNode n1 = stack.pop(), n2 = stack.pop();
            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null || n1.val != n2.val) return false;
            stack.push(n1.left);
            stack.push(n2.right);
            stack.push(n1.right);
            stack.push(n2.left);
        }
        return true;
    }
}
/*
My approach: 
public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> left_stack = new Stack<>();
        Stack<TreeNode> right_stack = new Stack<>();
        if(root == null){
            return true;
        }
        TreeNode cur_left = root.left;
        TreeNode cur_right = root.right;
        while(cur_left != null || cur_right != null || !left_stack.isEmpty() || !right_stack.isEmpty()){
            while(cur_left != null && cur_right != null){
                left_stack.push(cur_left);
                cur_left = cur_left.left;
                right_stack.push(cur_right);
                cur_right = cur_right.right;
            }
            if(cur_left != null || cur_right != null) return false;
            cur_left = left_stack.pop();
            cur_right = right_stack.pop();
            if(cur_left == root && cur_right == root){
                break;
            }
            
            if(cur_left.val != cur_right.val){
                return false;
            }
            
            cur_left = cur_left.right;
            cur_right = cur_right.left;
            
        }
        return true;
    }

I use traversal to tackle this problem. It's the same time complexity, but there are so many conditions to check in my approach. So I consider my solution worse than the most voted solution above.
*/