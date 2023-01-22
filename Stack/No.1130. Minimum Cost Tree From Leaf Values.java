class Solution {
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        stack.push(Integer.MAX_VALUE);
        for(int a : arr){
            while(stack.peek() < a){
                int minNode = stack.pop();
                res += minNode * Math.min(stack.peek(), a);
            }
            stack.push(a);
        }
        
        // after all the operations, the stack is a monotonic-decreasing stack
        // for instance, 6,4,3
        // so always pop the stack top and peek the stack top(pop 3; peek 4) then pop the stack top and peek the stack top(pop 4; peek 6)
        // remember the most inner element is Integer.MAX. So don't touch that. So make sure we are using stack.size() > 2 to check if we have one element  left or not
        while(stack.size() > 2){
            res += stack.pop() * stack.peek();
        }
        
        return res;
    }
}
/*
思路：monotonic stack
以下的抱团=形成一个tree
1\这个游戏的本质就是，为了让总和最小，让应该让小的数字抱团，大的数字单走。这样就能保证大的数字对于乘积尽可能的贡献少
2\所以维持一个monotonically decreasing的stack，如果输入到一个比stack顶大的数字，那说明stack顶那个小的数字可以抱团了。跟谁抱团呢，跟这个小的数字再前一个数（peek一下）和输入到这个数比较一下，那个小跟谁抱团，这就是8-9行干的事情
3\最后stack里的数列是monotonically decreasing的，说明可以从stack top最小的数字开始跟前面已经抱团的数抱团。最后最大的数字最后一个抱团，所以对于total sum保证只奉献一次。
比如6，2，4，3
2，4先抱团成为一棵树（+2*4）
然后3跟2，4抱团成为一棵树（+3*4）
然后以4为首的数跟6最后抱团（+6*4）
答案为44

笑死我了，熟练运用单走和抱团的芜湖鹅鸭杀忠实观众
*/