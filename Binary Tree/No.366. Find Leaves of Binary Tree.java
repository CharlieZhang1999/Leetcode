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
    public List<List<Integer>> res;
    public List<List<Integer>> findLeaves(TreeNode root) {
        res = new ArrayList<>();
        getHeight(root);
        return res;
    }
    
    public int getHeight(TreeNode root){
        if(root == null) return -1;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        int curHeight = Math.max(leftHeight, rightHeight) + 1;
        if(curHeight == res.size()){
            res.add(new ArrayList<Integer>());
            
        }
        res.get(curHeight).add(root.val);
        return curHeight;
    }
}
/*
在得到height的途中添加val
怎么做到呢？
通过一个简单的判断：if(height == res.size()) 如果 true，说明到了新的一层，需要在res里新建一个[]，并把val放进去。
*/