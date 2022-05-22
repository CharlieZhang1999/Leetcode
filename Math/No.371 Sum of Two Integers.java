class Solution {
    public int getSum(int a, int b) {
        while(b != 0){
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}

/*
^ can be seen as sum without carry
& can be seen as carry


For example, 2 + 3

Step 1
a & b:
2 = 0 0 1 0
3 = 0 0 1 1
-------------
    0 0 1 0
carry should be left shift one bit, so it's
    0 1 0 0
    
Step 2
a ^ b:
2 = 0 0 1 0
3 = 0 0 1 1
------------
    0 0 0 1

Step 3
a & b = 
     0 0 0 1
     0 1 0 0
-------------
     0 0 0 0
     
a ^ b= 
     0 0 0 1
     0 1 0 0
     ---------
     0 1 0 1 = 5
*/