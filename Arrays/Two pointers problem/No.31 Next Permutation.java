class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int [] bucket = new int[101];
        
        int temp;
        boolean swap = false;
        for(int i = 0; i < n; i++){
            bucket[nums[i]] = i;
        }
        
        int i = 0;
        for(i = n-2; i >= 0; i--){
            for(int j = nums[i]+1; j <= 100; j++){
                if(bucket[j] > i){
                    // do swap
                    temp = nums[i];
                    nums[i] = nums[bucket[j]];
                    nums[bucket[j]] = temp;
                    swap = true;
                    break;
                }
            }
            if(swap){
                break;
            }
        }
            

        for(int x = i+1; x < n - 1; x++){
            for(int y = x+1; y < n; y++){
                temp = nums[x];
                nums[x] = nums[y];
                nums[y] = temp;
            }
        }
        
    }
}