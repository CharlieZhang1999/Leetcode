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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode LCA = getLCA(root, startValue, destValue);
        StringBuilder path_s = new StringBuilder();
        findPath(LCA, startValue, path_s);
        StringBuilder path_d = new StringBuilder();
        findPath(LCA, destValue, path_d);

        int i = 0, j = 0;
        while(i < path_s.length() && j < path_d.length()){
            if(path_s.charAt(i) == path_d.charAt(j)){
                i++;
                j++;
            }
            else break;
        }
        String res = "";
        while(i < path_s.length()){
            res += "U";
            i++;
        }

        res += path_d.substring(j);
        return res;

    }

    public boolean findPath(TreeNode root, int value, StringBuilder sb){
        if(root == null) return false;
        if(root.val == value) return true;

        sb.append("L");
        if(findPath(root.left, value, sb)) return true;
        sb.deleteCharAt(sb.length()-1);

        sb.append("R");
        if(findPath(root.right, value, sb)) return true;
        sb.deleteCharAt(sb.length()-1);

        return false;
    }
    public TreeNode getLCA(TreeNode root, int p, int q){
        if(root == null || (root.val == p || root.val == q)) return root;

        TreeNode left = getLCA(root.left, p, q);
        TreeNode right = getLCA(root.right, p, q);
        return left == null? right: right == null? left:root;
    }
}