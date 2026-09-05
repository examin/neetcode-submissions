class Solution {
    public int maxSubArray(int[] nums) {
        int maxSeen = Integer.MIN_VALUE;
        int curr = 0;
        for(int i =0;i<nums.length;i++){
            curr+=nums[i];
            if(curr>maxSeen){
                maxSeen=curr;
            }
            if(curr<0){
                curr=0;
            }
        }
        return maxSeen;
    }
}

// [2,-3,4,-2,2,1,-1,4]
 

