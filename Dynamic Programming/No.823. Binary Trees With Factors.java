class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int mod = 1000000000 + 7;
        Arrays.sort(arr);
        HashMap<Integer, Long> map = new HashMap<>();
        long count = 1,sum = 1;
        map.put(arr[0], count);
        for(int i = 1; i < arr.length; i++){
            count = 1;
            for(int j = 0; j < i; j++){
                if(arr[i] % arr[j] == 0 && map.containsKey(arr[i] / arr[j])){
                    count += (map.get(arr[j]) * map.get(arr[i] / arr[j])) % mod;
                }
            }
            map.put(arr[i], count);
            sum = (sum + count) % mod ;
        }
        return (int) sum;
    }
}
/*
tag: DP
DP with memoization 
*/