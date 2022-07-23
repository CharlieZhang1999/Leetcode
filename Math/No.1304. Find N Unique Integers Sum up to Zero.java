class Solution {
    public int[] sumZero(int n) {
        int [] res = new int[n];
        int j = 0;
        
        for(int i = 1; i <= n / 2; i++){
            res[j] = i;
            res[j+1] = -1 * i;
            j += 2;
        }
        
        if(n % 2 == 1){
            res[j] = 0;
        }
        
        return res;
    }
}