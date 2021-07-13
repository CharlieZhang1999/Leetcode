class Solution {
    public int trap(int[] height) {
        int total_water = 0;
        if(height == null || height.length == 0){
            return total_water;
        }
        int length = height.length;
        int left_max [] = new int[length];
        int right_max [] = new int[length];
        
        
        // left_max 
        left_max[0] = height[0];
        for(int i = 1; i < length; i++){
            left_max[i] = Math.max(height[i], left_max[i-1]);
        }
        
        // right_max
        right_max[length-1] = height[length-1];
        for(int i = length - 2; i >= 0; i--){
            right_max[i] = Math.max(height[i], right_max[i+1]);
        }
        
        for(int i = 1; i < length; i++){
            total_water += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return total_water;
    }
}