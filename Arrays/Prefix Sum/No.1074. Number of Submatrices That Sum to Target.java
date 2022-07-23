class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        // int [][] A = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 1; j < n; j++){
                matrix[i][j] += matrix[i][j-1];
            }
        }
        HashMap<Integer, Integer> counter = new HashMap<>();
        int cur = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                counter.clear();
                counter.put(0, 1);
                cur = 0;
                for(int k = 0; k < m; k++){
                    cur += matrix[k][j] - (i>0?matrix[k][i-1]:0);
                    res += counter.getOrDefault(cur-target, 0);
                    counter.put(cur, counter.getOrDefault(cur, 0)+1);
                }
            }
        }
        
        return res;
    }
}
/*
tag: prefix sum, array
跟No.560的思路是一样的
只是变成二维的了
大概就是既然submatrice是可伸缩的，那我们选择竖着伸缩（即变动m，然后求差，看看差是否在hashmap里）
那么我们就要对每一种情况的i,j伸缩m
有几种情况的i,j呢？
在n=3时
我们的(i,j)有(0,0),(0,1),(0,2),(1,1),(1,2),(2,2)
分别对这几种i,j向下伸缩m，求差，就行了。
*/