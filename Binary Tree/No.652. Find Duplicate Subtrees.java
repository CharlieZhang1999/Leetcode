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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String, TreeNode> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        HashSet<TreeNode> set = new HashSet<>();
        buildString(root, sb, "N", ",", map, set);
        return new ArrayList<TreeNode>(set);
    }
    
    public String buildString(TreeNode cur, StringBuilder sb, String N, String spliter, HashMap<String, TreeNode> map, HashSet<TreeNode> set){
        if(cur == null){
            return "N,";
        }
        String res = cur.val+",";
        res += buildString(cur.left, sb, N, spliter, map, set);
        res += buildString(cur.right, sb, N, spliter, map, set);
        if(map.containsKey(res)){
            set.add(map.get(res));
        }
        else{
            map.put(res, cur);
        }
        
        return res;
    }
}
/*
思路：
serialize之后储存到hashmap里
*/