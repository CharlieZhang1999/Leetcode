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
        buildString(root, sb, ',');
        return sb.toString();
    }
    
    public void buildString(TreeNode cur, StringBuilder sb, Character spliter){
        if(cur == null) return;
        sb.append(cur.val).append(spliter);
        buildString(cur.left, sb, spliter);
        buildString(cur.right, sb, spliter);
        
    } 
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        LinkedList<String> linkedlist = new LinkedList<>();
        linkedlist.addAll(Arrays.asList(data.split(",")));
        System.out.println(linkedlist);
        return buildTree(linkedlist, 0, 10000);
        
    }
    
    public TreeNode buildTree(LinkedList<String> linkedlist, int lower, int upper){
        if(linkedlist.isEmpty()) return null;
        int val = Integer.valueOf(linkedlist.peek());
        
        if(val < lower || val > upper) return null;
        linkedlist.poll();
        TreeNode cur = new TreeNode(val);
        cur.left = buildTree(linkedlist, lower, val);
        cur.right = buildTree(linkedlist, val, upper);
        return cur;
    }
    
    
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;

/*
思路：
这题跟297不一样的点在于
因为要build string as compact as possible
所以297 BT里的null还可以用N表示
但是449里BST的null就可以不用字符串表示直接跳过，因为在buildtree时可以用lower bound和upper bound来判断某个node的左子树和右子树是否为null（这就是41行在做的）
*/