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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if(root != null){
            findPathSum(root,targetSum,res,path);
        }
        return res;
    }
    public void findPathSum(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> path){
        if(root.left == null && root.right == null && targetSum == root.val){
                path.add(root.val);
                res.add(new ArrayList<>(path));
                return;
        }
        
        
        path.add(root.val);
        if(root.left != null){
            findPathSum(root.left, targetSum-root.val, res, path);
            path.remove(path.size()-1);
        }
        
        if(root.right != null){
            findPathSum(root.right, targetSum-root.val, res, path);
            path.remove(path.size()-1);
        }  
    }
}