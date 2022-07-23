class Solution {
    public int minPartitions(String n) {
        char [] arr = n.toCharArray();
        int max = 0;
        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] -'0' > max){
                max = arr[i] -'0';
            }
        }
        return max;
    }
}