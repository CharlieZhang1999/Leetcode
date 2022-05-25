class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<int []> stack = new Stack<>();
        int[] res = new int[nums.length];
        int cur;
        for(int i = 0; i < nums.length; i++){
            cur = nums[i];
            while(!stack.isEmpty() && cur > stack.peek()[0]){
                res[stack.pop()[1]] = cur;
            }
            stack.push(new int[]{cur, i});
        }
        
        for(int i = 0; i < nums.length; i++){
            cur = nums[i];
            while(!stack.isEmpty() && cur > stack.peek()[0]){
                res[stack.pop()[1]] = cur;
            }
        }
        
        while(!stack.isEmpty()){
             res[stack.pop()[1]] = -1;
        }
        
        return res;
    }
}
/*
为了冬冬 gogo！
*/