class Solution {
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public int numIslands(char[][] grid) {
        int counter = 0;
        for(int i =0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    counter++;
                    grid[i][j] = '2';
                    traverse(grid, i, j);
                }
            }
        }
        return counter;
    }
    private void traverse(char[][] grid, int row, int col){
        for(int[] curr : dir){
            int newRow = curr[0]+row;
            int newCol = curr[1]+col;
            if(validCell(grid, newRow, newCol)){
                 grid[newRow][newCol] = '2';
                traverse(grid, newRow, newCol);
            }
        }
    }
    private boolean validCell(char[][] grid, int row, int col){
       if(row<0||col<0||row>=grid.length||col>=grid[0].length||grid[row][col] == '0'||grid[row][col]=='2'){
            return false ;
        }
        return true;
    }
}
