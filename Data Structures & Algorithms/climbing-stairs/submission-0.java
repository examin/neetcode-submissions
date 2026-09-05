class Solution {
    public int climbStairs(int n) {
        if(n<=3){
            return n;
        }
        int last = 1;
        int secLast = 2;
        for(int i = 3; i<=n; i ++){
            int now = last+secLast;
            last = secLast;
            secLast = now;
        }
        return secLast;
    }
}
