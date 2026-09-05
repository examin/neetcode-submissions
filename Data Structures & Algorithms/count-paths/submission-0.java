class Solution {
    public int uniquePaths(int m, int n) {
        int[][] mem = new int[m+1][n+1];
        mem[0][0] = 1;
        for(int i = 0;i<m;i++){
            for(int j = 0; j<n;j++){
                if(i>0 && j>0){
                    mem[i][j] = mem[i][j-1]+mem[i-1][j];
                }else{
                    mem[i][j] = 1;
                }
            }
        }
        for(int[] now : mem){
            // System.out.println(Arrays.toString(now));
        }
        return mem[m-1][n-1];
    }
}
