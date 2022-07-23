while(cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        TreeNode par = stack.pop();
        cur = par.right;