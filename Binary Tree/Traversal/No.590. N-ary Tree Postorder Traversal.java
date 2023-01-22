/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        Stack<Node> stack = new Stack<>();
        if(root == null) return res;
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            res.addFirst(cur.val);
            if(cur.children != null){
                for(int i = 0; i < cur.children.size(); i++){
                    stack.push(cur.children.get(i));
                }
            }
        }
        return res;
        
    }
}