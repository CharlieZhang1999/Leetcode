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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        TreeNode cur = root;
        int leftLevel = 0, rightLevel = 0;
        while(cur != null){
            cur = cur.left;
            leftLevel++;
        }
        cur = root;
        while(cur != null){
            cur = cur.right;
            rightLevel++;
        }
        // case 1: Perfect Binary Tree
        if(leftLevel == rightLevel){
            return (int)Math.pow(2, leftLevel) - 1;
        }
        // case 2: Complete Binary Tree
        else{
            return 1+countNodes(root.left)+countNodes(root.right);
        }     
    }
}
/*
tag: #binary tree #dfs
思路：
好有意思的题。大概就是一个CBT肯定是可以拆分成PBT的。
一开始可能左边是PBT右边是CBT, 但右边的CBT也可以拆分成PBT和一个null。
所以不完美的本质是完美（？）哲学大师
*/