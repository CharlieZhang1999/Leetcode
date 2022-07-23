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
    public List<TreeNode> allPossibleFBT(int n) {
        HashMap<Integer, List<TreeNode>> map = new HashMap<>();
        // List<TreeNode> nullList = new ArrayList<>();
        // nullList.add(null);
        List<TreeNode> oneList = new ArrayList<>();
        oneList.add(new TreeNode(0));
        map.put(1, oneList);
        return allFBT(n, map);
    }
    
    
    public List<TreeNode> allFBT(int n, HashMap<Integer, List<TreeNode>> map){
        if(map.containsKey(n)){
            return map.get(n);
        }
        
        List<TreeNode> res = new ArrayList<>();
        if(n % 2 == 0) return res;
        
        
        for(int i = 1; i < n; i+=2){
            List<TreeNode> leftTree = allFBT(i, map);
            List<TreeNode> rightTree = allFBT(n-i-1, map);
            for(TreeNode leftRoot: leftTree){
                for(TreeNode rightRoot: rightTree){
                    TreeNode root = new TreeNode(0);
                    root.left = leftRoot;
                    root.right = rightRoot;
                    res.add(root);
                }
            } 
        }
        
        map.put(n, res);
        return res;
    }
    
}
/*
tag: DP+recursion
跟583异曲同工！
*/