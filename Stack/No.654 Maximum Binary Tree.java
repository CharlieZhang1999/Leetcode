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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> stack = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            TreeNode cur = new TreeNode(nums[i]);
            while(!stack.isEmpty() && stack.peek().val < nums[i]){
                cur.left = stack.pop();
            }
            
            // meaning that someone is bigger than cur
            if(!stack.isEmpty()){
                stack.peek().right = cur;
            }
            stack.push(cur);
        }
        // TreeNode res = null;
        // while(!stack.isEmpty()){
        //     res = stack.pop();
        // }
        return stack.isEmpty()?null:stack.removeLast();
    }
    
}

/*
#tag: stack
*/