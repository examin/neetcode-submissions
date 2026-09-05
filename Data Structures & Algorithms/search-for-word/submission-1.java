class Solution {
    int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
    public boolean exist(char[][] board, String word) {
        for(int i = 0;i<board.length;i++){
            for(int j =0;j<board[0].length;j++){
                if(find(board, i, j , word,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean find(char[][] board, int row, int col, String word, int itr){
        if (word.charAt(itr) != board[row][col]) return false;
        if(itr==word.length() - 1){
            return true;
        }
        char temp = board[row][col];
        board[row][col] = '#';
        
        for(int[] dir : dirs){
            int newRow= row+dir[0];
            int newCol = col+dir[1];
            if(valid(board, newRow, newCol) && find(board, newRow, newCol , word,itr+1)){
                return true;
            }
        }
        board[row][col] = temp;
        return false;
    }
    private boolean valid(char[][] board, int row, int col){
        if(row<0||col<0||row>=board.length||col>=board[0].length){
            return false;
        }
        return true;
    }
}