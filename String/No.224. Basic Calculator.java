class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char [] arr = s.toCharArray();
        int sum = 0;
        int sign = 1;
        
        
        for(int i = 0; i < arr.length; i++){
            if(Character.isDigit(arr[i])){
                int num = 0;
                while(i < arr.length && Character.isDigit(arr[i])){
                    num = num * 10 + (arr[i] - '0');
                    i++;
                }
                sum += sign * num;
                // This line is very important. It revokes the i++ in line 14.
                i--;
            }
            else if(arr[i] == '+'){
                sign = 1;
            }
            else if(arr[i] == '-'){
                sign = -1;
            }
            else if(arr[i] == '('){
                stack.push(sum);
                stack.push(sign);
                sum = 0;
                sign = 1;
            }
            else if(arr[i] == ')'){
                sign = stack.pop();
                sum = stack.pop()+sign*sum;
            }
            else{
                continue;
            }    
        }
        return sum;
    }
}
/*
tag: Stack, String
1\思路就是如果遇到open parentheses就push stack，如果遇到close parentheses就pop stack
2\遇到连续的数字时就num = num * 10 + current，毕竟有两位数以上的数存在的
*/
