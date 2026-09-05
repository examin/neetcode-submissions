

class Solution {
    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int result = 0, robLast = nums[0], notRobLast = 0;
        for(int i = 1; i<nums.length;i++){
            int temp = notRobLast;
            notRobLast = Math.max(robLast, notRobLast);
            robLast = nums[i]+ temp;
            
        }
        return Math.max(robLast, notRobLast);
    }
}


// n : 0 , 2 , 1 , 3
// r : 2 , 1 , 3 , 3

// temp = 2;
// notRobLast = 1
// robLast = 1 + 2;


