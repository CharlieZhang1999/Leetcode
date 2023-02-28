class Solution {
    public int res = 0;
    public int totalNQueens(int n) {
        
        backtrack(0, n, new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>());
        return res;
    }
    
    public void backtrack(int r, int n, HashSet<Integer> colSet, HashSet<Integer> posDiagSet, HashSet<Integer> negDiagSet){
        if(r >= n){
            res++;
            return;
        }    
        
        for(int c = 0; c < n; c++){
            if(colSet.contains(c) || posDiagSet.contains(r+c) || negDiagSet.contains(r-c)) continue;
            
            colSet.add(c);
            posDiagSet.add(r+c);
            negDiagSet.add(r-c);
            backtrack(r+1, n, colSet, posDiagSet, negDiagSet);
            
            colSet.remove(c);
            posDiagSet.remove(r+c);
            negDiagSet.remove(r-c);
        }
        
        return;
    }
}
/*
思路：
就是用N-Queens I的做法
只不过省掉了board的visualize
只是res++罢了

具体的还是用三个set：colSet, posDiagSet, negDiagSet
*/