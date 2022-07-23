class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> i_stack = new Stack<>();
        
        StringBuilder sb = new StringBuilder(s);
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '('){
                i_stack.push(i);
            }
            
            if(arr[i] == ')'){
                if(!i_stack.isEmpty() && arr[i_stack.peek()] == '('){
                    i_stack.pop();
                    
                }
                else{
                    i_stack.push(i);
                }
            }
        }
        
        
        while(!i_stack.isEmpty()){
            sb.deleteCharAt(i_stack.pop());
        }
        
        return sb.toString();
    }
}