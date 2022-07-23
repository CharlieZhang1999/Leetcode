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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> l = new LinkedList<>();
        if(root == null) return res;
        l.addLast(root);
        
        while(!l.isEmpty()){
            int size = l.size();
            res.add(l.getLast().val);
            while(size > 0){
                TreeNode cur = l.removeFirst();
                if(cur.left != null){
                    l.addLast(cur.left);
                }
                if(cur.right != null){
                    l.addLast(cur.right);
                }
                size--;
            }
        }
        return res;
    }
}
/*
tag: bfs
都是家银
*/