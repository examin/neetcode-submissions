class Solution {

    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

    public int maxAreaOfIsland(int[][] grid) {

        int max = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {

                if(grid[i][j] == 1) {
                    int counter = traverse(grid, i, j);
                    
                    max = Math.max(counter, max);
                }
            }
        }

        return max;
    }

    private int traverse(int[][] grid, int row, int col) {

        if(!validCell(grid, row, col)) {
            return 0;
        }

        // mark visited
        grid[row][col] = 2;

        int counter = 1;

        for(int[] curr : dir) {

            int newRow = row + curr[0];
            int newCol = col + curr[1];

            counter += traverse(grid, newRow, newCol);
        }

        return counter;
    }

    private boolean validCell(int[][] grid, int row, int col) {

        if(row < 0 || col < 0 ||
           row >= grid.length ||
           col >= grid[0].length ||
           grid[row][col] != 1) {

            return false;
        }

        return true;
    }
}