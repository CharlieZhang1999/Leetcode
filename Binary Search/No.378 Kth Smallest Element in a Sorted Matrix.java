class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int lo = matrix[0][0];
        int hi = matrix[n-1][n-1];
        
        
        int mid, count;
        while(lo < hi){
            mid = lo + (hi-lo)/2;
            count = getLessOrEqual(matrix, mid);
            if(count < k){
                lo=mid+1;
            }
            else{
                // since this case also involves count == k, we should consider hi = mid instead of hi = mid - 1
                hi = mid;
            }
        }
        return lo;
    }
    
    public int getLessOrEqual(int[][] matrix, int s){
        int i = matrix.length-1;
        int j = 0;
        int count =  0;
        while(i >= 0 && j < matrix[0].length){
            if(matrix[i][j] > s){
                i--;
            }
            else{
                count+=i+1;
                j++;
            }
        }
        return count;
    }
}