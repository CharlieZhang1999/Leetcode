class Solution {
    public int findKthLargest(int[] nums, int k) {
        // because we want the kth largest, it should be in the index nums.length - k after         sorted
        int real_position = nums.length - k;
        int low = 0;
        int high =  nums.length - 1;
        
        while(low < high){
            int partition_index = partition(nums, low, high);
            if(partition_index < real_position){
                low++;
            }
            else if(partition_index > real_position){
                high--;
            }
            else break;
        }
        return nums[real_position];
        
    }
    
    public static void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    
    public static int partition(int[] nums, int low, int high){
        int pivot = nums[high];
        int left = low;
        int right = high;
        while(left != right){
            while(left < right && nums[left] < pivot){
                left++;
            }
            while(left < right &&  nums[right] >= pivot){
                right--;
            }
            if(left < right){
                swap(nums, left, right);
            }
        }
        swap(nums, high, left);
        return left;
    }   
}

/*
epiphany: 所有的求第k大第k小的问题都可以用selection/partition来解决哦
(:生气 还是要20多ms 才击败了9% 哼
(雾草 原来是quickselect 算了下次再写吧
*/