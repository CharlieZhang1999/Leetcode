import java.lang.Math;
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, middle = Integer.MAX_VALUE;
        for(int num: nums){
            if(num <= small) small = num;
            else if(num <= middle) middle = num;
            // if arrives here, means we already got small and middle and we now had a number bigger 
            // than small and middle, so return true
            else return true;
        }
        return false;
    }
}

/*
= =||
感觉智商受到了侮辱
所以quadriplet, 四个五个六个的都可以做好像
= =||
*/