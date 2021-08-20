class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = board.length;
        HashSet [] rows = new HashSet[N];
        HashSet [] cols = new HashSet[N];
        HashSet [] boxes = new HashSet[N];
        
        for(int r = 0; r < N; r++){
            rows[r] = new HashSet<Character>();
            cols[r] = new HashSet<Character>();
            boxes[r] = new HashSet<Character>();
        }
        
        for(int i = 0;  i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] != '.'){
                    if(!rows[i].add(board[i][j])){
                        return false;
                    }
                    if(!cols[j].add(board[i][j])){
                        return false;
                    }
                    int box_index = (i/3) * 3 + j/3;
                    if(!boxes[box_index].add(board[i][j])){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
/* 
因为行，列，九宫格要各满足constraint，所以就三种hashset
*/