class Solution {
    public int reverseBits(int n) {
      StringBuilder sb  = new StringBuilder();
      for(int i =0;i<32;i++){
        if((n&(1<<i))==0){
            sb.append("0");
        }else {
            sb.append("1");
        }
      }
      int res = 0;
      String reverse = sb.reverse().toString();
      for(int i = 0 ;i <32;i++){
        if(reverse.charAt(i)=='1'){
            res |= (1<<i);
        }
      }
      return res;
    }
}
