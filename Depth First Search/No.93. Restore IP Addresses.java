class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s, res, "", 3);
        return res;
    }
    
    public void backtrack(String s, List<String> res, String path, int dot){
        if(dot < 0 && s.isEmpty()){
            res.add(path.substring(1));
            return;
        }
        if(dot < 0) return;
        
        for(int i = 0; i < s.length() - dot; i++){
            String part = s.substring(0, i+1);
            if(valid(part)){
                backtrack(s.substring(i+1), res, path+"."+part, dot-1);
            }
            else break;
        }
    }
    
    public boolean valid(String part){
        if(part.length() > 3 || (part.length() > 1 && part.charAt(0) == '0') || Integer.parseInt(part) > 255) return false;
        return true;
    }
}
/*
难点和思路：
主要是这个string的拼接和这个valid function有点难到我了
首先，string的拼接是用path来做的，path保留之前拼好的结果（如同line 18里path+","+part) 然后s是还剩下的数字，所以要用s.substring()来处理s

其次，它的valid function有几层逻辑。1\长度不能超过3 2\如果首位是0那么长度不能超过1 3\parse value <= 255。如果这三层逻辑有任意一个违背了，return false
*/