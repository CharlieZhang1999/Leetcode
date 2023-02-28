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
    public int minCameraCover(TreeNode root) {
        int [] ans = minCameraSum(root);
        return Math.min(ans[1], ans[2]);
    }
    public int[] minCameraSum(TreeNode root){
        int [] res = new int[]{0,0,1000};
        if(root == null) return res;
        
        int [] left = minCameraSum(root.left);
        int [] right = minCameraSum(root.right);
        int coveredL = Math.min(left[1], left[2]);
        int coveredR = Math.min(right[1], right[2]);
        
        res[0] = left[1] + right[1];
        res[1] = Math.min(left[2]+coveredR, right[2]+coveredL);
        res[2] = 1+Math.min(left[0], coveredL)+Math.min(right[0], coveredR);
        
        return res;
            
    }
}
/*
tag: dp, binary tree
思路：
https://leetcode.com/problems/binary-tree-cameras/solution/
一个node root共有三个state： 0=None but subtree is covered; 1=covered but with no camera here ; 2=a camera is here

*/