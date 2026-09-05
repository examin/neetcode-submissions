class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for(int num =0;num<=n;num++){
            int counter =0;
            for(int i =0;i<32;i++){
                if((num&(1<<i))!=0){
                    counter++;
                }
            }
            result[num] = counter;
        }
        return result;
    }
}
