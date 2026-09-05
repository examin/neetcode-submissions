class Solution {
    public boolean canJump(int[] nums) {
        boolean[] mem = new boolean[nums.length];
        mem[nums.length-1] = true;
        int lastReachable = nums.length-1;
        for(int i = nums.length-2;i>=0;i--){
            if(nums[i] + i >= lastReachable){
                mem[i] = true;
                lastReachable = i;
            }else{
                mem[i] = false;
            }
        }
        System.out.println(Arrays.toString(mem));
        return mem[0];
    }
    
}

// [1,2,0,1,0]
// [0,1,2,3,4]
// [f,f,f,t,t]

