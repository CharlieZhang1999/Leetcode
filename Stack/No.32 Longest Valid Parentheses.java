class Solution {
    public int longestValidParentheses(String s) {
        char [] charArr = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int temp;
        stack.push(-1);
        for(int i = 0; i < charArr.length; i++){
            if(charArr[i] == ')'){
                stack.pop();
                // case: ))), edge case, don't need to update res
                if(stack.isEmpty()){
                    stack.push(i);
                }
                // case: )(), normal case, need to update res
                else{
                    res = Math.max(res, i - stack.peek());
                }
            }
            else{
                stack.push(i);
            }
        }
        
        return res;
    }
}