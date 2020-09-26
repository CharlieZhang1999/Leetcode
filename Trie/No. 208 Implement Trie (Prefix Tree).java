class Trie {
    /** TrieNode **/
    public class TrieNode{
        public char val;
        public boolean isEnd;
        public TrieNode [] children_node = new TrieNode[26];
        public TrieNode(){};
        public TrieNode(char c){
            val = c;
        }
    }
    
    /** Root **/
    public TrieNode root; 
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
        root.val = ' ';
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            int id = word.charAt(i) - 'a';
            //If there is already, say an 'a' in the tree, don't create a new 'a'. Reuse it!
            if(cur.children_node[id] == null){
                cur.children_node[id] = new TrieNode(word.charAt(i));
            }
            cur = cur.children_node[id];
        }
        cur.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            int id = word.charAt(i) - 'a';
            if(cur.children_node[id] == null){
                return false;
            }
            cur = cur.children_node[id];
        }
        return cur.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0; i < prefix.length(); i++){
            int id = prefix.charAt(i) - 'a';
            if(cur.children_node[id] == null){
                return false;
            }
            cur = cur.children_node[id];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
/*
epiphany:
1\a Trie is a list of nodes layered on another list of nodes. Every children of the tree has a list of nodes, namely 26 nodes since we have a-z.Each node in the list links to its children, which is another list of nodes(26 nodes). Whenever we insert or search, we start from the root and top to bottom.

functions:
    eg: "apple"
    1\insert: Insert from root. Make cur = root. If cur.children[0] (because a - 'a' = 0) exists, continue; otherwise, create Node('a'). Then make cur = Node('a') and repeat the above steps until inserting all of the nodes. On the last node 'e', write its isEnd property to true.
    2\search: Search from root and make cur = root. If cur.children[0] doesn't exist, then we are sure we have no word "apple" so return false. Else, make cur = Node('a') and repeat the above steps. Return true if we find all the alphabets and the last alphabet is an end.
    3\startwith: Search from root and make cur = root. If cur.children[0] doesn't exist, then we are sure we have no prefix "apple" so return false. Else, make cur = Node('a') and repeat the above steps. Return true if all the alphabets in the prefix match all we had in the trie. So we are sure at least we have one word that starts with this prefix. no need to dig deeper*/