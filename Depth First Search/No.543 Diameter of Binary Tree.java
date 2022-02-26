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
    public int maxDiameter;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxDiameter;
    }
    
    public int dfs(TreeNode root){
        if(root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        //这一行表示，如果不用我parent的关系，仅用我自己的左膀右臂，我可以得到的maxDiameter
        maxDiameter = Math.max(maxDiameter, left+right);
        //这一行的意思是，如果要用我parent的关系，那左膀右臂只能用其中一个了，那就用其中最长的那个
        return 1+Math.max(left, right);
    }
}

/*
这道题我一直在纠结，怎么才能也考虑上inner edges而不只是outer edges
但后来我才发现，这个28行更新全局变量maxDiameter的途中就已经考虑过所有inner route的可能性了
*/