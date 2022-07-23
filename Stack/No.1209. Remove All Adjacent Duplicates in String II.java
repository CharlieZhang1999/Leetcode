class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<int []> stack = new Stack<>();
        int n = s.length();
        for(int i = n - 1; i >= 0; i--){
            int c = s.charAt(i)-'a';
            if(!stack.isEmpty() && stack.peek()[0] == c){
                if(stack.peek()[1] == k-1){
                    stack.pop();
                }
                else{
                    stack.push(new int[]{c, stack.pop()[1]+1});
                }
            }
            else{
                stack.push(new int[]{c, 1});
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int [] cur;
        while(!stack.isEmpty()){
            cur = stack.pop();
            while(cur[1] > 0){
                sb.append((char) ('a'+cur[0]));
                cur[1]--;
            }
        }
        return sb.toString();
    }
}