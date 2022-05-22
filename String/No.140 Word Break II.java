class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int l = s.length();
        ArrayList<Integer> [] arr = new ArrayList[l];
        
        List<String> ret = new ArrayList<>();
        
        for(int i = l-1; i >= 0; i--){
            for(int j = i; j < l; j++){
                if(wordDict.contains(s.substring(i,j+1))){
                    if(arr[i] == null){
                        arr[i] = new ArrayList<Integer>();
                    }
                    arr[i].add(j);
                }
            }
        }
        

        dfs(arr, s, 0, l, ret, "");
        
        return ret;
    }
    
    public void dfs(ArrayList<Integer>[] arr, String s, int src, int dst, List<String> res, String cur){
        if(src == dst){
            // because we have a extra " " in the front, we have to use substring(1)
            res.add(cur.substring(1));
            return;
        }
        
        if(arr[src] != null){
            for(int d: arr[src]){
                String word = s.substring(src, d+1);
                dfs(arr, s, d+1, dst, res, cur + " "+word);
            }
        }
        return;
    }   
}