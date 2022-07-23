class Solution {
    public int nthUglyNumber(int n) {
        if(n == 1) return 1;
        
        int [] dp = new int[n];
        dp[0] = 1;

        int two_pointer = 0, three_pointer = 0, five_pointer = 0;
        for(int pointer = 1; pointer < n; pointer++){
            int next2 = dp[two_pointer] * 2;
            int next3 = dp[three_pointer] * 3;
            int next5 = dp[five_pointer] * 5;
            int next = Math.min(next2, Math.min(next3, next5));
            dp[pointer] = next;
            if(next == next2) two_pointer++;
            if(next == next3) three_pointer++;
            if(next == next5) five_pointer++;            
        }

        return dp[n-1];
    }
}
/*
tag: dp
思路：
就是有个p2,p3,p5分别做为*2，*3，*5的pointer
然后比大小，看是p2*2, p3*3,p5*5谁大
15-17行特意用了三个if，没有用if else的原因是
比如6，它既可以是3*2也可以是2*3，为了避免sequence有两个6出现，value一样的话p2,p3都++。就不重复count 6了。
*/