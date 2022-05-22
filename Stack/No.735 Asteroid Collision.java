class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        for (int ast: asteroids) {
            if(ast > 0){
                stack.push(ast);
            }
            else{
                // left moving win and pop last case
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -ast){
                    stack.pop();
                }
                
                if(!stack.isEmpty() && stack.peek() == -ast){
                    // two same size explode case
                    stack.pop();
                    continue;
                }
                // right winning do nothing case
                else if(stack.isEmpty() || stack.peek() < 0){
                    stack.push(ast);
                }
                    
            }
        }

        int[] ans = new int[stack.size()];
        for (int t = ans.length - 1; t >= 0; --t) {
            ans[t] = stack.pop();
        }
        return ans;
    }
}