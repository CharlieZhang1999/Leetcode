class Solution {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        char[] w = word.toCharArray();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                    if(findexist(board, w, 0, i, j)) return true;
            }
        }
        return false;
    }
    
    public boolean findexist(char[][] board, char[] word, int index, int i, int j){
        if(index == word.length) return true;
        if(i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] != word[index]){//check this situation to avoid out of scope error or if the this grid doesn't match the word[index]
            return false;
        }

        //this grid(y,x) matched! So we can't use it anymore during the rest of matching!
        board[i][j] = '*';//do this to mark "we've used this letter and we can't use it anymore!"
        
        boolean exist = findexist(board, word, index + 1, i - 1, j) || findexist(board, word, index + 1, i + 1, j) ||
            findexist(board, word, index + 1, i, j - 1) || findexist(board, word, index + 1, i, j+1);
                                                                      
        board[i][j] = word[index];//do this to restore the original letter
        return exist;
    }
}
/*
题型 bakctracking
难点
1、在exist原方法中，我知道findexist 如果是true的话就应该整个题return true，但有时候就卡住了 想不到怎么findexist true的话怎么在exist立即结束循环，原来闹了半天我想要的就是一句 if(findexist(board, w, 0, i, j)) return true;
2、在findexist方法中，我知道该用backtracking search for every position possible，但是该分开来find？比如四个if加四种backtrack？精髓是找关系，这个字母word[i]能找到是base on剩下的所有i=i+1...n都能找到的基础上。而找剩下的字母可以从四个position。所以致命的or就行了： boolean exist = findexist(board, word, index + 1, i - 1, j) || findexist(board, word, index + 1, i + 1, j) ||
findexist(board, word, index + 1, i, j - 1) || findexist(board, word, index + 1, i, j+1);
3、当用过某个字母时，要用"*"或别的什么方式码掉它，等用完了再restore
most voted solution：
    这次的backtrack return的不是ArrayList，是boolean = backtrack(option 1) || backtrack(option 2) || backtrack(option 3) || backtrack(option 4)
*/