class Solution {
    public String decodeString(String s) {
        Stack<Integer> num_stack = new Stack<>();
        Stack<String> res_stack = new Stack<>();
        int idx = 0;
        String res = "";
        while(idx < s.length()){
            if(Character.isDigit(s.charAt(idx))){
                int count = 0;
                while(Character.isDigit(s.charAt(idx))){
                    count = count * 10 + s.charAt(idx) - '0';
                    idx++;
                }
                num_stack.push(count);
            }
            if(s.charAt(idx) == '['){
                res_stack.push(res);
                res = "";
            }
            else if(s.charAt(idx) == ']'){
                StringBuilder temp = new StringBuilder (res_stack.pop());
                int repeatTimes = num_stack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
            }
            else{
                res += s.charAt(idx);
            }
            idx++;
        }
        return res;
    }
}
/*
这是作为一道DFS刷的。慢慢才意识到Stack适合做DFS，而Queue适合做BFS
epiphany:
    1\这道题的精髓在于把每个segment都可以理解为a+k[b]的形式。
    2\DFS就是recursive的a'+k'[a+k[b]]

steps:
    1\如果是数字，push到数字stack存起来
    2\如果是[, 把现在的a push到string stack存起来
    3\如果是], 把重复次数k从数字stack pop出来，把a从stack中pop出来并+k*[]中的b，变为a+k[b]的形式
    4\如果是字母，a = a + char(i)
    重复步骤*/