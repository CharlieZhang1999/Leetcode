class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                setFlag(board, i, j);
                // for previous 0 now 1, we set it to 8
                // for previous 1 now 0. we set it to 9
            }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j]  == 8){
                    board[i][j] = 1;
                }
                else if(board[i][j] == 9){
                    board[i][j] = 0;
                }
            }
        }
    }
    
    public void setFlag(int[][] board, int i, int j){
        int sum = 0;
        
        for(int c = j-1; c < j+2; c++){
            sum += countLive(board, i-1, c);
        }
        sum += countLive(board, i, j-1);
        sum += countLive(board, i, j+1);
        for(int c = j-1; c < j+2; c++){
            sum += countLive(board, i+1, c);
        }
        
        if(board[i][j] == 0 || board[i][j] == 8){
            if(sum == 3){
                // previous 0 now 1
                board[i][j] = 8;
            }
        }
        else{
            if(sum < 2 || sum > 3){
                // previous 1 now 0
                board[i][j] = 9;
            }
        }
        
        
    }
    
    public int countLive(int[][] board, int i, int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return 0;
        }
        
        if(board[i][j] == 0|| board[i][j] == 8){
            return 0;
        }
        
        return 1;
    }
}