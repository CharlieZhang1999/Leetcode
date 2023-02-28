class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        backtrack(num, 0, res, "", 0, 0, target);
        return res;
    }
    
    public void backtrack(String num, int pos, List<String> res, String path, long prev, long cur, int target){
        if(pos >= num.length()){     
            if(cur == target){
                res.add(path);
            }
            return;
        }
        
        String temp;
        long n = 0;
        for(int i = pos; i < num.length(); i++){
            temp = num.substring(pos, i+1);
            
            // edge case 1: like '01'
            if(temp.charAt(0) == '0' && temp.length() > 1) break;
            
            n = n * 10 + (num.charAt(i) -'0');
            // edge case 2: too large
            if(n > Integer.MAX_VALUE) break;
            
            // edge case 3: no operators in front and no path in front, so manually pass in
            if(pos == 0){
                backtrack(num, i+1, res, temp, n, cur+n, target);
                continue; 
            }
            
            // case 1: +
            backtrack(num, i+1, res, path+"+"+temp, n, cur+n, target);
            // case 2: -
            backtrack(num, i+1, res, path+"-"+temp, -n, cur-n, target);    
            // case 3:*
            backtrack(num, i+1, res, path+"*"+temp, prev*n, cur-prev+prev*n, target);
            //case 4: concatenate number
            // do nothing
        }   
    }
}
/*
思路：
这道题太抽象了
跟轰轰仔一样抽象
需要多做几遍
https://zxi.mytechroad.com/blog/searching/leetcode-282-expression-add-operators/

tag：dfs， backtrack
对于每个数字，我们有以下四种选择
1\+它，更新cur=cur+n, prev=n
2\-它，更新cur=cur-n, prev=-n
3\*它，更新cur=cur-prev+prev*n, prev=prev*n
4\concatenate它,什么operator都不加
*/