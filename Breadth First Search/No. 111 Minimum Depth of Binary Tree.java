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
    public int minDepth(TreeNode root) {
        int minDepth = 0;
        if(root == null) return minDepth;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int i = queue.size();
            while(i > 0){
                TreeNode cur = queue.poll();
                if(cur.left == null && cur.right == null){
                    minDepth++;
                    return minDepth;
                }
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
                i--;
            }
            minDepth++;
        }
        return minDepth;
    }
}
/*
epiphany: 这道题和max depth of binary tree 有异曲同工之处，都是BFS + queue
思路：先说说BFS吧，今天挺有体会的，就是先在一步内把所有的可能性都offer到queue里，再讨论下一步。
     就比如这道题，就是先把left, right child加到queue里，广度上探索遍所有可能性，再进行下一步。

构建queue之后
step 1/判断有没有empty，empty则break
step 2/queue.size（）反馈的是这个level有几个node。毕竟Depth一个level加一遍就够了，一定要在这个while loop外面
step 3/queue.poll() pop出queue的第一个node，如果同时无左无右，断后了，满足条件，return minDepth+1(因为一半minDepth的计算累加在后面，如果要提前结算必须先把这层的计算给做了再结算)
step 4/如果有后代，则把后代加进queue
step 5/加完一个level的后代，再minDepth++累加
step 6/重复step 1


*/