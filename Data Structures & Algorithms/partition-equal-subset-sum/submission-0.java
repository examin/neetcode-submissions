class Solution {
    Boolean[][] mem ;
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum%2!=0){
            return false;
        }
        mem = new Boolean[nums.length+1][sum];
        return canPartition(nums, 0, sum/2);
    }
    private boolean canPartition(int[] nums, int index, int sum){
        if(index==nums.length||sum==0){
            return sum==0;
        }
        if(sum<0){
            return false;
        }
        if(mem[index][sum]!=null ) return mem[index][sum];

        return mem[index][sum] = canPartition(nums, index +1 ,sum-nums[index] ) || canPartition(nums, index+1, sum);
    }
}
