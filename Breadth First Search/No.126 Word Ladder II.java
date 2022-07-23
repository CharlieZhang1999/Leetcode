class Solution {
    
    public boolean found;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {   
        HashSet<String> wordSet = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if(!wordSet.contains(endWord)) return res;
        
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        set1.add(beginWord);
        set2.add(endWord);
        
        HashMap<String, List<String>> map = new HashMap<>();
        bfs(set1, set2, wordSet, true, map);
        if(!found) return res;
        
        List<String> temp = new ArrayList<>();
        temp.add(beginWord);
        findLadderDFS(beginWord, endWord, temp, map, res);
        
        return res;
    }
    
    public void bfs(HashSet<String> set1, HashSet<String> set2, HashSet<String> wordSet, boolean direction, HashMap<String, List<String>> map){
        if(set1.isEmpty()) return;
        if(set1.size() > set2.size()){
            bfs(set2, set1, wordSet, !direction, map);
            return;
        }
        
        wordSet.removeAll(set1);
        wordSet.removeAll(set2);
        
        HashSet<String> newSet = new HashSet<>();
        
        for(String s: set1){
            char [] s_arr = s.toCharArray();
            for(int i = 0; i < s_arr.length; i++){
                char old = s_arr[i];
                for(char j = 'a'; j <= 'z'; j++){
                    s_arr[i] =  j;
                    String w = String.valueOf(s_arr);
                    
                    String key = direction? s:w;
                    String val = direction? w:s;
                    List<String> l1 = map.containsKey(key)?map.get(key):new ArrayList<String>();
                    
                    // if the next layer is the endWord, great! Path is found!
                    if(set2.contains(w)){
                        found = true;
                        l1.add(val);
                        map.put(key, l1);
                    }
                    
                    // if the shortest path is not found and the next layer is not endWord, count this into map
                    if(!found && wordSet.contains(w)){
                        // update/expand set1
                        newSet.add(w);
                        l1.add(val);
                        map.put(key,l1);
                    }
                    
                }
                s_arr[i] = old;
            }
        }
        
        if(found) return;
        bfs(newSet, set2, wordSet, direction, map);

        
    }
    
    public void findLadderDFS(String beginWord, String endWord, List<String> temp, HashMap<String, List<String>> map, List<List<String>> res){
        if(beginWord.equals(endWord)){
            res.add(new ArrayList<>(temp));
            return;
        }
        
        if(map.containsKey(beginWord)){
            for(String toWord: map.get(beginWord)){
                temp.add(toWord);
                findLadderDFS(toWord, endWord, temp, map, res);
                temp.remove(temp.size()-1);
            }
        }
    }
    
    
}

/*
#tag: bfs, dfs
这个是更规范的做法
1、先用2-direction bfs把edge搭好，形式是hashmap，相当于把fromWord和toWord整理成一个map。
2、然后用dfs来traverse这个map，相当于backtracking，直到traverse到了endWord就res.add(new(temp));很熟悉的backtracking形式对吧

这里虽然没有explicitly dfs shortest path，但很有意思的一点这个map保证能traverse到endWord的path都是shortest的，因为我们在码里面写明了如果已经有path了(found=true)而当前word还需要一些layer才能到endWord的时候，那就不把当前path或node记入map中。详见line 56,57的判断

inspiration: https://leetcode.cn/problems/word-ladder-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-3-3/
*/