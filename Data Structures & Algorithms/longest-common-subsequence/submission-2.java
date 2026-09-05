class Solution {
    int[][] mem;
    public int longestCommonSubsequence(String text1, String text2) {
        mem = new int[text1.length()+1][text2.length()+1];

        for(int i = 0;i <text1.length(); i++){
            for(int j = 0;j<text2.length(); j++){
                if(text1.charAt(i) == text2.charAt(j)){
                    mem[i+1][j+1] = 1 + mem[i][j];
                }else{
                    mem[i+1][j+1] = Math.max(mem[i+1][j], mem[i][j+1]);
                }
            }
        }
        return mem[text1.length()][text2.length()];
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
