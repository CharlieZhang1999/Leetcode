class Solution {
    public int findKthNumber(int m, int n, int k) {
        int lo = 1, hi = m * n, mi = 0;
        int count = 0;
        while(lo < hi){
            mi = lo + (hi - lo) / 2;
            count = le(mi, m, n);
            if(count < k){
                lo = mi+1;
            }
            else{
                hi = mi;
            }
        }
        return lo;
    }
    
    public int le(int x, int m, int n){
        int sum = 0;
        for(int j = 1; j <= n && j <= x; j++){
            sum += Math.min(m,x/j);
        }
        return sum;
    }
}
/*
思路：
跟378如出一辙
也是用lessThanEqual() + binary Search

只不过这个题的lessThanEqual()的算法不太一样，
比如一个数4，4/1是第一列比4小的数的数量，4/2是第二列比4小的数量，依次类推。当然要求一个min(m，x/j)因为当m=3时，第一列只有3个数所以比4小的数只能取到3.
*/