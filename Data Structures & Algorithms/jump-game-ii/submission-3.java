class Solution {
    
    public int jump(int[] nums) {
        int farthest = 0;
        int end = 0;
        int jumps = 0;

        for(int i = 0;i<nums.length-1;i++){
            farthest = Math.max(farthest, nums[i]+i);
            if(end == i){
                jumps++;
                end = farthest;
            }
        }
        return jumps;
    } 
}


// [2,4,1,1,1,1]
// [0,1,2,3,4,5]


// int farthest = 5;
// int end = 5;
// int jumps = 1;