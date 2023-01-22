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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root == null) return res;
        int level = 0;
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            while(size > 0){
                if(level % 2 == 0){
                    TreeNode cur = queue.removeFirst();
                    levelList.add(cur.val);
                    if(cur.left != null){
                        queue.addLast(cur.left);
                    }
                    if(cur.right != null){
                        queue.addLast(cur.right);
                    }
                }
                else{
                    TreeNode cur = queue.removeLast();
                    levelList.add(cur.val);
                    if(cur.right != null){
                        queue.addFirst(cur.right);
                    }
                    if(cur.left != null){
                        queue.addFirst(cur.left);
                    }
                }
                size--;
                
            }
            level++;
            res.add(levelList);
        }
        
        return res;
    }
}
/*
用linkedlist就完事
记住
even level是add last, remove first
odd level是add first, remove last
*/