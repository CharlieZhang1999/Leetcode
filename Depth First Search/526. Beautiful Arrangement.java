class Solution {
    public int countArrangement(int n) {
        char [] used = new char[n+1];
        Arrays.fill(used, 'n');
        return helper(new HashMap<String, Integer>(), n, used, 1);
    }
    
    public int helper(HashMap<String, Integer> map, int n, char [] used, int pos){
        if(pos > n){
            return 1;
        }
        String key = new String(used);
        if(map.containsKey(key)){
            return map.get(key);
        }
        
        int count = 0;
        for(int i = 1; i <= n; i++){
            if(used[i] == 'n' && (i % pos == 0 || pos % i == 0)){
                used[i] = 'u';
                count += helper(map, n, used, pos+1);
                used[i] = 'n';
            }
        }
        map.put(new String(used), count);
        return count;
    }
    
}class Solution {
    public int countArrangement(int n) {
        char [] used = new char[n+1];
        Arrays.fill(used, 'n');
        return helper(new HashMap<String, Integer>(), n, used, 1);
    }
    
    public int helper(HashMap<String, Integer> map, int n, char [] used, int pos){
        if(pos > n){
            return 1;
        }
        String key = new String(used);
        if(map.containsKey(key)){
            return map.get(key);
        }
        
        int count = 0;
        for(int i = 1; i <= n; i++){
            if(used[i] == 'n' && (i % pos == 0 || pos % i == 0)){
                used[i] = 'u';
                count += helper(map, n, used, pos+1);
                used[i] = 'n';
            }
        }
        map.put(new String(used), count);
        return count;
    }    
}

/*
思路：
1\dfs + memoization，前三位是‘123’和‘321’后面的arrangement数量应该是相等的，所以如果map检测到当前key出现过，直接就return行了，省了很多时间
2\怎么储存123=321这个信息呢，就是把used 改成char array，假设n=10，那么就把'uuunnnnnnn'和对应的count数量存进去就行了！
*/