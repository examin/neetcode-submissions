class Solution {
    public int reverseBits(int n) {
      int res = 0;
//      I thought that i will check current bit by n& (1<<1) and then use that bit with or and add that to front
      for(int i =0;i<32;i++){
        if((n&(1<<i))!=0){
            res |= (1<<(31-i));
        }
      }
      return res;
    }
}
