class Solution {
    public boolean equationsPossible(String[] equations) {
        int [] parent = new int[26];
        for(int i = 0; i < 26; i++){
            parent[i] = i;
        }
        for(String equation: equations){
            if(equation.charAt(1) == '='){
                union(equation.charAt(0)-'a', equation.charAt(3)-'a', parent);
            }
        }    
        
        for(String equation: equations){
            if(equation.charAt(1) == '!'){
                if(findParent(equation.charAt(0)-'a', parent)  == findParent(equation.charAt(3)-'a', parent)){
                    return false;
                }
            }
        }
        return true;
        
    }
    public void union(int x, int y, int [] parent){
        int parentX = findParent(x, parent);
        int parentY = findParent(y, parent);
        if(parentX < parentY){
            parent[parentY] = parentX;
        }
        else if(parentX > parentY){
            parent[parentX] = parentY;
        }
    }
    
    public int findParent(int x, int [] parent){
        if(parent[x] != x){
            return findParent(parent[x], parent);
        }
        
        return x;
    }
}