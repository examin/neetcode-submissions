class Solution {
    int[][] mem;
    public int longestCommonSubsequence(String text1, String text2) {
        mem = new int[text1.length()][text2.length()];
        return longestCommonSubsequence(text1, text2, 0,0);
    }
    private int longestCommonSubsequence(String text1, String text2, int index1, int index2){
        if(index1>=text1.length() ||index2>=text2.length()){
            return 0;
        }
        if(mem[index1][index2]!=0){
            return mem[index1][index2];
        }

        if(text1.charAt(index1)==text2.charAt(index2)){
                return mem[index1][index2] = 1 + longestCommonSubsequence(text1, text2, index1+1,index2+1);
        }else{
                return mem[index1][index2] = Math.max(
                    longestCommonSubsequence(text1, text2, index1,index2+1),
                    longestCommonSubsequence(text1, text2, index1+1,index2)) ;
        }
    }
}
