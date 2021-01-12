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
    public TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}

/* 
epiphany: 从右往左倒序拼接，利用recursion触底，prev为全局变量记录上一次拼接的结果。
 --- 始终记住，倒序拼接 ---
step 1\flatten右边，并且右边拼接prev，自己成为prev（因为右边比较大，所以先把右边和后人的结果拼接上）
step 2\flatten左边，并且左边拼接prev，自己成为prev
step 3\把所有结果变为自己的右手，把左手砍了（left = null) （心疼赢奚哈哈哈哈哈）
step 4\自己化为prev，供前人拼接所用
*/