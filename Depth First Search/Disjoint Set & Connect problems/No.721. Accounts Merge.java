class Solution {
    public int [] parent;
    public String [] name;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        parent = new int[n];
        name = new String[n];
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Integer, List<String>> mergemap = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        
        
        for(int i = 0; i < n; i++){
            parent[i] = i;
            
        }
        
        for(int i = 0; i < n; i++){
            List<String> account = accounts.get(i);
            // 0 index is account name
            name[i] = account.get(0);
            // from 1 ~ size - 1 are emails
            for(int j = 1; j < account.size(); j++){
                if(!map.containsKey(account.get(j))){
                    map.put(account.get(j), i);
                }
                else{
                    union(map.get(account.get(j)), i);
                }
            }
        }
        
        for(String email: map.keySet()){
            int group = map.get(email);
            int parent = findParent(group);
            mergemap.putIfAbsent(parent, new ArrayList<String>());
            mergemap.get(parent).add(email);
        }
        
        for(Integer i: mergemap.keySet()){
            List<String> curaccount = mergemap.get(i);
            Collections.sort(curaccount);
            curaccount.add(0, name[i]);
            res.add(curaccount);
        }
        
        
        return res;
        
        
    }
    
    public void union(int j, int i){
        int parent1 = findParent(j);
        int parent2 = findParent(i);
        
        if(parent1 == parent2) return;
        if(parent1 < parent2){
            parent[parent2] = parent1;
        }
        else{
            parent[parent1] = parent2;
        }
    }
    
    public int findParent(int idx){
        if(parent[idx] == idx){
            return idx;
        }
        
        else return findParent(parent[idx]);
    }
}
/*
思路：
经典union & find
利用了parent[]，思路是谁parent小就跟谁姓
比如union(2,1)，那就2跟1姓，parent[2] = 1;
然后用了几个hashmap在中间倒来倒去
1\先<email, group> map，把group之间的联系union起来
2\再<parent, ArrayList> map, 记录下merge完各个group的情况
3\最后用map.get()加到ArrayList里，记住要sort一下并且add(0, names)毕竟0-idx处应该填names，然后后面跟emails

*/