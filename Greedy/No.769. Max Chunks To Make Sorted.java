class Solution {
    public int maxChunksToSorted(int[] arr) {
        int curMax = 0;
        int res = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > curMax){
                curMax = arr[i];
            }
            if(curMax == i){
                res++;
            }
        }
        return res;
    }
}
/*
tag: Greedy
思路：
1\一个对的chunk是A[:index]正好有0,1,2...index
所以只要到目前的index为止的max == index，说明正好满足一个chunk，则chunk++
比如到i=5的时候正好max=5，说明前6个数正好为0～5，所以可以组成一个chunk。

*/