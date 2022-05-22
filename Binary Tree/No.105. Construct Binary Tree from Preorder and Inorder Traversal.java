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
    int preorderIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        
        for(int i = 0; i < inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        
        return buildTreeRecursion(inorderMap, preorder, 0, preorder.length-1);
        
    }

    
    public TreeNode buildTreeRecursion(HashMap<Integer, Integer> inorderMap, int[] preorder, int left, int right){
        if(left > right) return null;
        
        int val = preorder[preorderIndex++];
        TreeNode cur = new TreeNode(val);
        int idx = inorderMap.get(val);
        
        cur.left = buildTreeRecursion(inorderMap, preorder, left, idx-1);
        cur.right = buildTreeRecursion(inorderMap, preorder, idx+1, right);
        return cur;
    }
}

/*
tag: #Hash Table #Binary Tree
video: https://www.youtube.com/watch?v=ihj4IQGZ2zc
epiphany: 
for i-th iteration:
    the i-th element of the preorder array is always the root of the tree(subtree)
    
Thus if we find the index of this element in inorder array, the elements that are at the left will be in the left tree while the elements that are at the right will be in the right tree.

1\
[3,9,20,15,7], 第一个root是3
那么[9,3,15,20,7]中，left tree:9 right tree:15 20 7

2\[3,9,20,15,7] 第二个root是9
那么[9,3,15,20,7]中，left tree:null right tree: null
...

30行这里的left和right指的是inorder里的index，就比如说inorder里9左边右边都没有数字，那就不找了。
*/