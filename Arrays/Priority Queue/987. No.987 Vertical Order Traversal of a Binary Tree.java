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
class TreeNodeWtCor{
    TreeNode node;
    int row;
    int col;
    TreeNodeWtCor(TreeNode cur, int row, int col){
        this.node = cur;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[1] == b[1]){
                    return a[0] == b[0]?a[2]-b[2]:a[0]-b[0];
                } 
                return a[1]-b[1];
            }
        });
        
        Queue<TreeNodeWtCor> q = new LinkedList<>();
        TreeNodeWtCor cur;
        int size;
        int r = 0, c = 0;
        q.offer(new TreeNodeWtCor(root, r, c));
        pq.offer(new int[]{r,c,root.val});
        while(!q.isEmpty()){
            size = q.size();
            while(size > 0){
                cur = q.poll();
                if(cur.node.left != null){
                    q.offer(new TreeNodeWtCor(cur.node.left, cur.row+1, cur.col-1));
                    pq.offer(new int[]{cur.row+1, cur.col-1, cur.node.left.val});
                }
                if(cur.node.right!= null){
                    q.offer(new TreeNodeWtCor(cur.node.right, cur.row+1, cur.col+1));
                    pq.offer(new int[]{cur.row+1, cur.col+1, cur.node.right.val});
                }
                size--;
            }
        }
        
        
        
        // add to res
        List<List<Integer>> res  = new ArrayList<>();
        int prevCol = pq.peek()[1];
        
        List<Integer> newList = new ArrayList<>();
        while(!pq.isEmpty()){
            // List<Integer> newList = new ArrayList<>;
            int [] curE = pq.poll();
            if(curE[1] != prevCol){
                res.add(newList);
                newList = new ArrayList<>();
                prevCol = curE[1];

            }
            newList.add(curE[2]);
        }
        // add  last newList
        res.add(newList);
        
        return res;
        
        
    }
}