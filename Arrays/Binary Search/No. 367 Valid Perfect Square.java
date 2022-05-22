class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 1){
            return true;
        }
        int left = 1;
        int right = num;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int quo = num / mid;
            int res = num % mid;
            if(quo == mid && res == 0){
                return true;
            }
            else if(quo > mid){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return false;
    }
}

/* ，class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 1){
            return true;
        }
        int left = 1;
        int right = num;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(mid * mid == num){
                return true;
            }
            else if(mid * mid > num){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return false;
    }
}]

第二段这个代码有个问题，在于如果num是个很大的数，那么mid也很大，mid * mid很有可能会超出int的范畴
所以与其拿mid * mid和num对比，不如拿num / mid 和mid对比，他们是等效的，而又不至于超出int的范畴
good good
*/