class Solution {
    class TrieNode{
            char val;
            TrieNode [] children = new TrieNode[26];
            String word;
            TrieNode(char c){
                val = c;
            }
    }
    public String s = "";
    public int maxlen = 0;
    
    public String longestWord(String[] words) {  
        TrieNode root = new TrieNode(' ');
        for(String word: words){
            insertWord(root, word);
        }
        
        for(TrieNode child: root.children){
            dfs(child);
        }
        return s;
    }
    
    public void dfs(TrieNode cur){
        if(cur == null) return;
        if(cur.word == null) return;
        if(cur.word.length() > maxlen){
            maxlen = cur.word.length();
            s = cur.word;
        }
        else if(cur.word.length() == maxlen && cur.word.compareTo(s) < 0){
            maxlen = cur.word.length();
            s = cur.word;
        }
        
        for(TrieNode child: cur.children){
            dfs(child);
        }
        
    }
    
    public void insertWord(TrieNode trie, String word){
        TrieNode cur = trie;
        for(Character c: word.toCharArray()){
            if(cur.children[c-'a'] == null){
                cur.children[c-'a'] = new TrieNode(c);
            }
            cur = cur.children[c-'a'];
        }
        cur.word = word;
    }
    
}
/*
#tag: trie
已经快忘了trie是怎么做的了
大概就是先insert word
然后dfs 整个trie，其实并不慢，因为如果cur.word == null就不用往下了。因此第一次for loop只有a和b可以继续，但因为b.word == null所以只有a了。
*/

