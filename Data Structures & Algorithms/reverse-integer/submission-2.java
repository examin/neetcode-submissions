class Solution {
    public int reverse(int x) {
        if(x==0){
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        boolean isNegative = false;
        long num = x;

        if(num<0){
            isNegative = true;
            num = -1*num;
        }
        
        while(num!=0){
            long now = num%10;
            sb.append(now);
            num = num/10;
        }
        long result  = Long.parseLong(sb.toString());
        if(result<Integer.MIN_VALUE || result>Integer.MAX_VALUE){
            return 0;
        }
        if(isNegative){
            return (int)(-1 * result);
        }else{
            return (int)(result);
        }
    }
}
