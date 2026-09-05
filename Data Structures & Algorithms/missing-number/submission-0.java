class Solution {
    public int missingNumber(int[] nums) {
        boolean[] find = new boolean[nums.length+1];
        for(int i =0;i<nums.length;i++){
            find[nums[i]] = true;
        }
        int neg = -1;
        for( int i = 0;i < find.length; i++){
            if(find[i] == false){
                neg = i;
            }
        }
        return neg;
    }
}
