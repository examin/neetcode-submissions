class Solution {
    public int[] countBits(int now) {
        int[] res = new int[now+1];
        for(int i = 1; i <= now; i++){
            int n = i;
            while(n>0){
                n = n&(n-1) ;
                res[i]++;
            }
        }
        return res;
    }
}
