class Solution {
    int[] mem ;
    public int numDecodings(String s, int i) {
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return 0;
        if(mem[i]!=-1){
            return mem[i];
        }
        int res = numDecodings(s, i+1);
        if(i<s.length() - 1 ){
            if(s.charAt(i)=='1'){
                res += numDecodings(s, i+2);
            } else if (s.charAt(i)=='2' && s.charAt(i+1)<'7'){
                res += numDecodings(s, i+2);
            }
        }
        return mem[i]= res;
    }
    public int numDecodings(String s){
        mem = new int[s.length()+1];
        Arrays.fill(mem, -1);
        return numDecodings(s, 0);
    }

}

// if current character is 1 or 2, we need to check immidaite thing, if it is 0 it should has been considered already so skip.  if we see 1 or 2 And next value is in acceptable range of current means can be comined with current  character we are on if not ways are not increased.

// 