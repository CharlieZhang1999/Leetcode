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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null) return res;
        queue.add(root);
        while(queue.peek()!=null){
            List<Integer> temp = new ArrayList<>();  
            int i = queue.size();
            while(i > 0){
                TreeNode cur = queue.poll();
                temp.add(cur.val);
                if (cur.left!= null) queue.add(cur.left);
                if (cur.right!= null) queue.add(cur.right);
                i--;
            }
            res.add(temp);
        }
        return res;
    }
}
/*
基本是自己纯手磨出来的吧
epiphany：
    首先，先进先出要想到Queue
    遍历某个level时
    1、queue把这个level层的所有nodes poll出来，并且数着计数器i来poll（i为当前level的node数，由在遍历该层node前由queue,size()得出）并把他们的children加到queue里      去（所以如果queue本来有2个node，虽然都poll出来了，但queue并不是empty的，因为这两个node可能有4个children呢！
    2、每层遍历结束后，把temp加到res中，然后刷新temp。

难点：
    1、special case要尽量避免。之前的一个版本，我先int i = 1. 这一步非常没必要，因为完全可以省掉这一步special case的initializaion
    2、每次iteration结束用temp.clear来刷新中括号，更巧妙的办法是在每次iteration前直接temp = new ArrayList(), 能省掉不少时间！
*/