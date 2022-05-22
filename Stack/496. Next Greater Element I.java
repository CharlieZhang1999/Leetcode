class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // monotonic stack
        Stack<Integer> stack = new Stack<>();
        int [] res = new int[nums1.length];
        int cur;
        
        // This is O(nums2.length)
        for(int j = 0; j < nums2.length; j++){
            cur = nums2[j];
            // maintain monotonic stack
            while(!stack.isEmpty() && cur > stack.peek()){
                map.put(stack.pop(), cur);
                // eg: map(1,3); map(3,4);
            }
            stack.push(cur);
        }
        
        
        // This is O(nums1.length)
        for(int i = 0; i < nums1.length; i++){
            res[i] = map.getOrDefault(nums1[i], -1);
        }

        return res;
    }
}

/*
오늘은하나만했어요 
明天必须next level
为了金冬 gogo！
*/