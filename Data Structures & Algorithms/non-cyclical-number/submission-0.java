class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(set.contains(n)==false && n>0 && n<=1000 && n!=1){
            int result = 0;
            set.add(n);
            while(n!=0){
                result += (n%10)*(n%10);
                n = n/10;
            }
            n = result;
        }
        return n==1?true:false;
    }
}
