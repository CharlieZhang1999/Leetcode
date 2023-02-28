class Solution {
    public List<String> res;
    public List<String> removeInvalidParentheses(String s) {
        res = new ArrayList<String>();
        remove(s, 0, 0, new char[]{'(',')'});
        return res;
    }
    
    public void remove(String s, int left, int right, char [] par){
        int stack = 0;
        for(; right < s.length(); right++){
            if(s.charAt(right) == par[0]) stack++;
            if(s.charAt(right) == par[1]) stack--;
            if(stack < 0) break;
        }
        
        if(stack < 0){
            for(; left <= right; left++){
                if(s.charAt(left) != par[1]) continue;
                if(left >= 1 && s.charAt(left) == s.charAt(left-1)){
                    
                    continue;
                }
                remove(s.substring(0, left)+s.substring(left+1), left, right, par);
            } 
        }
        else if(stack > 0){
            remove(new StringBuilder(s).reverse().toString(), 0, 0, new char[]{')', '('});
        }
        else{
            res.add(par[0]=='('?s:new StringBuilder(s).reverse().toString());
        }
    }
}
/*
#tag: backtracking, bfs
思路
1\有个left和right pointer，表明异常区间。我们从left pointer依次遍历，如果符号为par[1](正序par1为")" 倒序par1为"(")，说明为可以考虑删除的异常符号，则用s.substring(0, left)+s.substring(left+1)来删除它。

2\如果stack > 0 说明"("多，那么我们就反转整个string的顺序和par的顺序。最后记得在31行这判断一下是否为倒序 如果是那再reverse一下再add进来
*/