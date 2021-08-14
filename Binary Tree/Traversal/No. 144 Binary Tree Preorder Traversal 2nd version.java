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
    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode head = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if(head != null){
            stack.push(head);
            while(!stack.isEmpty()){
                TreeNode cur = stack.pop();
                res.add(cur.val);
                if(cur.right != null){
                    stack.push(cur.right);
                }
                if(cur.left != null){
                    stack.push(cur.left);
                }
            }
        }
        return res;
        
    }
}

/* 
左大佬的办法，这回不是一路向左了，而是通过 “右左” 逆序过来是 “左右”这个策略来实现“头左右”的遍历
*/