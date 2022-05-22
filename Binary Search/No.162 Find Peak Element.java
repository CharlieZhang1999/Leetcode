class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        int mid;
        while(left < right){
            mid = left + (right - left)/2;
            
            
            
            // case: we are going downwards from peak. so peak in previous
            if(nums[mid] > nums[mid+1]){
                right = mid;
            }
            // case: we are going upward towards the peak
            else{
                left = mid + 1;
            }
        }
        
        return left;
    }
}

/*
tag: #binary search

Imagine it as climbing a peak. Now the left and right ends are at -infinity and there is no plateau so there is a  peak to be guaranteed. Now check the middle element,if the next element is less this means that we are on our downward journey in the peak,so the peak is at the left part i.e end=mid (Note:This element might be the peak as the next element is less therefore we included it).And if the next element is greater than the current,this means that we are climbing the peak therefore peak happens to be on the right part(Note:This element can't be the peak).So s=mid+1
*/