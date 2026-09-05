class Solution {
    public int rob(int[] nums, int start , int end) {
        if(start==end){
            return nums[start];
        }
        int include = nums[start], notInclude = 0;
         for(int i = start+1;i<=end; i++){
            int temp = notInclude;
            notInclude = Math.max(notInclude, include);
            include = temp + nums[i];
         }
         return Math.max(include, notInclude);
    }
    public int rob(int[] nums){
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length-2), rob(nums, 1, nums.length-1));
    }
}

