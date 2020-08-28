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
    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                res.add(cur.val);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return res;
    }
}
/*
我只能说，悟道了啊。基本跟上次的Inorder traversal一个思路，只是更多了些体会
epiphany: 
1\这个框架的思路，就是无论如何先往左下走，等到没有左下的时候，开始掉头往右探索 + 往上探索。
2\当stack is not empty的时候，说明有些node的可能性还没有探索完，更explicit点，有些遍历过的node的right child还没有遍历到，它们还有可能性，所以我们的第一个while loop要坚持探索完所有的可能性。
by 张秀秀
*/
