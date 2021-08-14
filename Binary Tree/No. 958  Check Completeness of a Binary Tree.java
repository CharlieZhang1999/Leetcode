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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode left;
        TreeNode right;
        boolean childNotFilled = false;
        
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            left = cur.left;
            right = cur.right;
            if(left == null && right != null){
                return false;
            }
            if((left != null || right != null) && childNotFilled){
                return false;
            }
            
            if(left != null){
                queue.add(left);
            }

            if(right != null){
                queue.add(right);
            }
            
            if(left == null || right == null){
                childNotFilled = true;
            }
        }
        return true;
    }
}

/* 
左老师做法，bfs
对于每个node，不complete只有以下两种情况：
a. 有右child没有左child
b. 如果之前已经traverse过没有child的parents了，但是现在加的这个node不是leaf node

well, 这个基于每个node的判断其实比较麻烦，还有一种更简单的bfs和一个dfs做法
*/