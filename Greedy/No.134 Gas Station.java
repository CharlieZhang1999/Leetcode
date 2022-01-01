class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int sumGas = 0;
        int sumCost分别记录gas的和以及cost的和，如果 = 0;
        int start = 0, tank = 0;
        for(int i = 0; i < n; i++){
            sumGas += gas[i];
            sumCost += cost[i];
            // tank is balance
            tank = tank + gas[i] - cost[i];
            if(tank < 0){
                start = i+1;
                tank = 0;
            }
        }
        return (sumGas-sumCost<0)?-1:start;
        
    }
}
/*
关键:If the total number of gas is bigger than the total number of cost. There must be a solution.

三招指南:
1\两个变量sumGas sumCost分别记录gas的和以及cost的和，如果sumGas<sumCost, 没有solution, -1
2\用一个指针start从0开始挪，我们把tank这个变量想成balance。如果从一个start出发，一旦发现balance<0，则马上更新start; 直到找到一个从start出发一直到length-1位置都保持 balance >=0的start，那么这个start就是可行的。

至于为什么不用走完full circle就知道第一个后半程balance>=0的点就是唯一的solution，要好好想想，如果这个点是第一个能走完后半程的，说明前面的几个点都是没法走后半程还没走到这个点就gg了的，所以前面的点balance肯定<=0。
比如start是5的话，5->8 balance >=0 那么肯定0->4 balance <=0（对于0-4的任何点来说都迈不到5）. 如果你硬要杠说会不会5->1的时候balance不够用了balance < 0了，那这就imply 2->4 balance >= 0， 意味着2-4中有点可以到5，这是contradiction，所以遇到的第一个后半程balance>=0的就是start！
*/