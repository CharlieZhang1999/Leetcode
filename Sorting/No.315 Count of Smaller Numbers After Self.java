class Solution {
    public int[] counts;
    public int[] index;
    public int[] result;
    public List<Integer> countSmaller(int[] nums) {
        
        counts = new int[nums.length];// the counts array
        result = new int[nums.length];// the temporary array that stores the index of nums according to the descending order of nums
        index = new int[nums.length];// the index mapping array that stores the index of the merge-sorted nums. For example, if the initial nums is                                                 [2,5,6,1], the final index should be [2,1,0,3]
        for(int i = 0; i < nums.length; i++){
            index[i] = i;
        }
        List<Integer> ans = new ArrayList<>();
        mergeSort(nums, 0, nums.length - 1);
        for(int i = 0; i < nums.length; i++){
            ans.add(i, counts[i]);
        }
        return ans;
    }
    
    
    public void mergeSort(int[] nums, int left, int right){
        if(left == right || left > right){
            return;
        }
        
        int mid = left + (right - left)/2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid+1, right);
        int i = left, j = mid + 1;
        int m = left;
        while(i <= mid && j <= right){
            if(nums[index[i]] > nums[index[j]]){
                // update counts if the left element is bigger than the right element
                counts[index[i]] += right - j + 1;
                result[m++] = index[i++];  
            }
            else{
                result[m++] = index[j++];
            }
        }
        
        while(i <= mid){
            result[m++] = index[i++];
        }
        
        while(j <= right){
            result[m++] = index[j++];
        }
        
        // update the index mapping array using the temp result array
        for(int k = left; k <= right; k++){
            index[k] = result[k];
        }
        
    }
}


/*
https://zhuanlan.zhihu.com/p/158739366
*/