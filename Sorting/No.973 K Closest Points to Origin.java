class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // edge case: points.length == k
        if(points.length == k) return points;
        return quickSelect(points, k);
    }
    
    public int[][] quickSelect(int[][] points, int k){
        int left = 0, right = points.length - 1;
        while(left < right){
            int partition_index = partition(points, left, right);
            // after partition, we are certain that the closet (partition_index) # of points are in the front
            // eg: if partition_index is 2, we are sure that the first two elements are the lowest two elements.
            if(partition_index == k){
                return Arrays.copyOf(points, k);
            }
            else if(partition_index < k){
                left = partition_index;
            }
            else{
                right = partition_index - 1;
            }
        }
        
        return Arrays.copyOf(points, k);
    }
    
    public int partition(int[][] points, int left, int right){
        int pivot_distance = squaredDistance(points[left + (right - left)/2]);
        while(left < right){
            if(squaredDistance(points[left]) >= pivot_distance){
                int[] temp = points[right];
                points[right] = points[left];
                points[left] = temp;
                right--;
            }
            else{
                left++;
            }
        }
        if(squaredDistance(points[left]) < pivot_distance){
            left++;
        }
        return left;
    }
    
    public int squaredDistance(int[] point){
        return point[0]*point[0]+point[1]*point[1];
    }
}
/*
tag: #sort #quicksort #quickselect
pivot criteria: left + (right-left)/2
*/