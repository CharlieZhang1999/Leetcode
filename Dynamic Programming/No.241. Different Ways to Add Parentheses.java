class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return ways(expression, new HashMap<String, List<Integer>>());   
    }
    
    
    public List<Integer> ways(String expression, HashMap<String, List<Integer>> map){
        if(map.containsKey(expression)){
            return map.get(expression);
        }
        List<Integer> res = new ArrayList<>();
        char [] s = expression.toCharArray();
        // case 0: have operators, such as '2-1'
        for(int i = 0; i < s.length; i++){
            if(s[i] == '+' || s[i] == '-' || s[i] == '*'){
                List<Integer> leftList = ways(expression.substring(0, i), map);
                List<Integer> rightList = ways(expression.substring(i+1), map);
                for(Integer left: leftList){
                    for(Integer right:rightList){
                        res.add(calculate(left, right, s[i]));
                    }
                }
            }
        }
        
        // case 1: base case, no operators found, such as '2'
        if(res.size() == 0){
            // directly add it to res since it is one number
            res.add(Integer.parseInt(expression));
        }
        
        map.put(expression, res);
        
        return res;    
    }
    
    public int calculate(int left, int right, char operator){
        if(operator == '+'){
            return left+right;
        }
        else if(operator == '-'){
            return left-right;
        }
        else{
            return left*right;
        }
    }
}

/*
tag: dp, recursion
https://www.youtube.com/watch?v=gxYV8eZY0eQ
*/