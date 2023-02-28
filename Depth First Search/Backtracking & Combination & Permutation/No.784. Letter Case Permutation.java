class Solution {
    public List<String> letterCasePermutation(String s) {
        char [] wordArray = s.toCharArray();
        List<String> ret = new ArrayList<>();
        backtrack(ret, wordArray, 0, wordArray.length);
        return ret;
    }
    
    public void backtrack(List<String> ret, char [] wordArray, int i, int n){
        if(i >= n){
            ret.add(String.valueOf(wordArray));
            return;
        }
        if(Character.isLetter(wordArray[i])){
            wordArray[i] = Character.toLowerCase(wordArray[i]);
            backtrack(ret, wordArray, i+1, n);
            
            wordArray[i] = Character.toUpperCase(wordArray[i]);
            backtrack(ret, wordArray, i+1, n);
            
        }
        else{
            backtrack(ret, wordArray, i+1, n);
        }
    }
}
/*
思路：

清清爽爽。
对于每个是字母的charcter 有2-way option
1、lowercase
2、uppercase
所以简单backtrack就好了
*/