class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int n = temperatures.length;
        int [] res = new int[n];
        
        int stackTop = 0;
        int [] temp;
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && temperatures[i] > stack.peek()[0]){
                temp = stack.pop();
                res[temp[1]] = i - temp[1];                
            }
            stack.push(new int[]{temperatures[i], i});
            
        }
        
        return res;
    }
}

/*
#array #monotonic stack

思路：
我们做一个monotonic decreasing的stack。一旦出现任何比stack top warmer的温度，就把stacktop pop掉然后其对应的answer可以赋值了。
依次把所有比cur温度低的stack里的元素全部pop出来，然后再push cur，这样以维持monotonic decreasing的stack。

*/