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
        
        while(queue.peek() != null){
            TreeNode cur = queue.poll();
            queue.add(cur.left);
            queue.add(cur.right);
        }
        while(!queue.isEmpty() && queue.peek() == null){
            queue.poll();
        }
        return queue.isEmpty();
    }
}

/* 
bfs

如果null node之后后面还有非null的node，说明不complete
For a complete binary tree,
there should not be any node after we met an empty one.
*/