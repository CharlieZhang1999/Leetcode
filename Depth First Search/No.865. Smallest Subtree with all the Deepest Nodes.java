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
    public HashMap<TreeNode, Integer> hashmap;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        hashmap = new HashMap<>();
        depth(root);
        return dfs(root);
    }
    
    public int depth(TreeNode root){
        if(root == null) return 0;
        if(hashmap.containsKey(root)) return hashmap.get(root);
        int d = Math.max(depth(root.left), depth(root.right))+1;
        hashmap.put(root, d);
        return d;
    }
    
    public TreeNode dfs(TreeNode root){
        int l = depth(root.left);
        int r = depth(root.right);
        
        if(l == r) return root;
        else if(l > r) return dfs(root.left);
        return dfs(root.right);  
    }
    
}
/*
#tag: dfs
两次dfs
第一次：向下找depth
第二次：向下找左右一样的depth。如果左depth比右depth高，那说明deepest那个node在左边。所以直接去左边找dfs(root.left)
*/