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
    public int [] l = new int[100001];
    public int [] r = new int[100001];
    public int [] h = new int[100001];
    public int[] treeQueries(TreeNode root, int[] queries) {     
        int [] res = new int[queries.length];
        getHeight(root);
        solve(root.left, r[root.val], 1);
        solve(root.right, l[root.val], 1);
        for(int i = 0; i < queries.length; i++) {
            res[i] = h[queries[i]];
        }
        return res;
        
    }
    
    public int getHeight(TreeNode cur){
        if(cur == null) return 0;
        int left = getHeight(cur.left);
        int right = getHeight(cur.right);
        l[cur.val] = left;
        r[cur.val] = right;
        return Math.max(left, right)+1;
    } 
    
    public void solve(TreeNode cur, int curMax, int depth){
        if(cur == null) return;
        h[cur.val] = curMax;
        solve(cur.left, Math.max(curMax, depth + r[cur.val]), depth+1);
        solve(cur.right, Math.max(curMax, depth + l[cur.val]), depth+1);
    }
    
}
/*
真的精妙
dfs memoization
去掉我这个node，要不然你就用curmax（就是连我parent都没用的route），要不然你就用我旁边的这个node不用我（如果我是left那该route高度是depth+root.right)，然后取这俩的最大值，赋给h[我自己]。代表去掉我之后最大的height
*/