import java.lang.Math;
class Solution {
    public int reverse(int x) {
        // edge case: -2147483648
        if(x <= -1 * Math.pow(2,31)){
            return 0;
        }
        // -2147483647 ~ -1
        if(x < 0){
            return -reversepositive(-x);
        }
        // 0 ~ 2147483647
        else return reversepositive(x);
        
    }
    public int reversepositive(int x){

        int result = 0, remainder = 0;
        while(x != 0){
            remainder = x % 10;
            result = result * 10 + remainder;
            x = x / 10;
            
            // make sure it doesn't go outside the signed 32-bit integer
            if(x != 0 && result > Math.pow(2,31)/10){
                return 0;
            }
        }
        return result;
    }
    
}