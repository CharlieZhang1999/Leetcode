class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 1;
        for(int i = 0; i < arr.length; i++){
             int target = arr[i] - difference;
            if(!map.containsKey(target)){
                map.put(arr[i], 1);
            }
            else{
                int val =  map.get(target) + 1;
                map.put(arr[i], val);
                res = Math.max(res, val);
            }
        }
        
        return res;
    }
}

/*
思路：
dp[i] = dp[i-d] + 1;
*/