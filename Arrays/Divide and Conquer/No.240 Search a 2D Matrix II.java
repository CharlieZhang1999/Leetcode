class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int curRow = 0, curCol = n-1;
        while(curRow < m && curCol >= 0){
            if(matrix[curRow][curCol] == target){
                return true;
            }
            else if(matrix[curRow][curCol] < target){
                curRow++;
            }
            else if(matrix[curRow][curCol] > target){
                curCol--;
            }
        }
        
        return false;
        
    }
}

/*
#divide and conquer
https://www.youtube.com/watch?v=g4Qy83toSzc

规律：
比如说找16
你发现从第一行最后一个开始，15比16小，所以这一行都不能要，因此向下移动一行
第二行最后一个，19比16大，所以19下的这一列都不能要，因此往左移动一列

所以整个问题就变成了只能朝两个方向移动的点，向左或向下

思路：
既然只能向左或向下，那就从右上方开始
m为行数，n为列数，因此从[0,n-1]开始
判断
（1）如果比target小，向下移动一行
（2）如果比target大，向左移动一列
（3）如果相等，return true
otherwise return false
*/