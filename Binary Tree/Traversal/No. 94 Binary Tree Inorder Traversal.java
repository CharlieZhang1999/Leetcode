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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new LinkedList<>();
        TreeNode cur = root;
        //while()
        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            ans.add(cur.val);
            cur = cur.right;
        }
        return ans;
        
    }
}
/*
epiphany: 感觉traversal的题目 stack会很common
大体思路：其实挺清晰的，有左child的就沿着左child顺，没有左child就顺右child。都没有就pop
难点：
    1、我在纠结到底是判断if cur == null 还是if cur.left == null;但其实你会发现，如果用后者，你就没办法     把最后一个cur node push到stack里去/pop出来，这样就很难实现一个traversal的统一规则。
    2、我在纠结两个while到底该怎么写，这两个while肯定是集中在极端情况的，也就是1.整个tree的leftmost         node和2.整个tree的root。对于情况1，到了最后它的children是null，所以它会被pop 并遍历它所有右边的         children，但请注意，此时它的left child我们已经不care了，为了避免下一个loop又找到它的left child是=形     成死循环，我们必须严格按stack顺序遍历，下一个遍历的值必须是它的父辈，所以必须从stack里赋值。
    也就是说，第一次stack.pop是把它本身移出，第二次stack.pop是把它的父辈（而不是它或它的子辈）赋值给cur。
    
    对于情况2，当root被pop出之后，stack并没有真正变空，因为下个cur是root.right。所以我们在大loop中判         断!stack.isEmpty是没问题的。只有全部遍历完了stack才会真正变empty。
    
    至此，两个极端情况都已有了解释。
    
*/