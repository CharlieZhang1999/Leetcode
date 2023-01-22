class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length, m = (n + 1) / 2;
        int half = n / 2 +1;
        int [] copy = Arrays.copyOf(nums, n);
        int median = findKLargest(copy, half);
        
        int i = 0, j = n - 1, k = n-1;
        while(j >= i){
            if(copy[j] < median){
                swap(copy, j, k);
                j--;
                k--;
            }
            else if(copy[j] > median){
                swap(copy, i, j);
                i++;
            }
            else{
                j--;
            }
        }
        
        
        for(i = 0; i < n; i++){
            nums[(1+2*i)% (n|1)] = copy[i]; 
        }

        
        return;
    }
    
    public int findKLargest(int [] nums, int k){
        int n = nums.length;
        int low = 0, high = n - 1;
        int k_idx = n - k;
        
        while(low < high){
            int pivot = partition(nums, low, high);
            if(pivot == k_idx){
                break;
            }
            else if(pivot < k_idx){
                low = pivot + 1;
            }
            else{
                high = pivot - 1;
            }
        }
        return nums[k_idx];
    }
    
    
    public int partition(int [] nums, int low, int high){
        int end = high;
        int pivot = nums[end];
        while(low < high){
            while(low < high && nums[low] < pivot){
                low++;
            }
            
            while(low < high && nums[high] >= pivot){
                high--;
            }
            swap(nums, low, high);
        }
        
        swap(nums, low, end);
        return low;
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
/*
quicksort，巨难，难到哭
大概就是
1\先找到median
2\然后按比median大比median小放在左右，左半边都大于等于median，右半边都小于median
3\按照1 3 5 0 2 4 6… 这个 1+2*idx %(n|1)来map
*/