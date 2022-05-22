class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;

        while(rowBegin <= rowEnd && colBegin <= colEnd){
            for(int j = colBegin; j <= colEnd; j++){
                ans.add(matrix[rowBegin][j]);
            }
            rowBegin++;
            
            for(int i = rowBegin; i <= rowEnd; i++){
                ans.add(matrix[i][colEnd]);
            }
            colEnd--;
            
            if(rowBegin > rowEnd || colBegin > colEnd){
                break;
            }
            
            for(int j = colEnd; j >= colBegin; j--){
                ans.add(matrix[rowEnd][j]);
            }
            rowEnd--;
            
            for(int i = rowEnd; i >= rowBegin; i--){
                ans.add(matrix[i][colBegin]);
            }
            colBegin++;
            
        }
        
        return ans;
    }
}
// 题目要点： 四次一循环，中间一判断