/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb, ",", "N");
        return sb.toString();
    }
    
    public void buildString(TreeNode cur, StringBuilder sb, String spliter, String NN){
        if(cur == null){
            sb.append(NN).append(spliter);
            return;
        }
        sb.append(cur.val);
        sb.append(spliter);
        buildString(cur.left, sb, spliter, NN);
        buildString(cur.right, sb, spliter, NN);
        
        
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> tree = new LinkedList<>();
        tree.addAll(Arrays.asList(data.split(",")));
        return buildTree(tree);
    }
    
    public TreeNode buildTree(LinkedList<String> tree){
        String s = tree.removeFirst();
        if(s.equals("N")) return null;
        TreeNode cur = new TreeNode(Integer.valueOf(s));
        cur.left = buildTree(tree);
        cur.right = buildTree(tree);
        return cur;
    }
    
}

/*
tag: dfs, binary tree
*/

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));