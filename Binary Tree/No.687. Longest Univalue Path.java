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
    public int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return res;
    }
    
    public int dfs(TreeNode root){
        if(root == null) return 0;
        int pl = 0;
        int pr = 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(root.left != null && root.left.val == root.val){
            pl = 1+left;
        }
        if(root.right != null && root.right.val == root.val){
            pr = 1+right;
        }
        res = Math.max(res, pr+pl);
        return Math.max(pr, pl);
    }
}
/*
思路：
dfs这个func算的是如果经过root的话的最长单边univalue path
这样的话经过root的最长univalue path就是pl + pr where pl = 1+dfs(root.left). pr = 1+dfs(root.right) 前提是root.val = root.left.val 或root.right.val
这个题的难点在于意识到，虽然我每次return的是单边最长，但我们可以在func中更新最长的UP（line 35）
*/