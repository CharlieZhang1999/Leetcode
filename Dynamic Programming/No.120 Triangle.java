class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
	    int rowNum = triangle.size();
        int [] M = new int[rowNum+1];//+1 is for expanding one grid for the last row(which is the longest)
        List<Integer> curRow;
        for(int i = rowNum-1; i>=0; i--){
            curRow = triangle.get(i);
            for(int j = 0; j <= i; j++){
                M[j] = Math.min(M[j], M[j+1])+curRow.get(j);
            }
        }
        
        return M[0];
    }
}

/*
bottom-up也太帅了
pro1: 最后一行是最长的 -> 保证空间是够用的 -> 可以1d array
pro2: 最后收敛到一格，只要取M[0]就行了，而如果top-bottom就要整M的每个元素遍历求出最小值
*/