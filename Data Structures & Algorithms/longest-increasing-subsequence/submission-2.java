class Solution {
    int[][] mem;
    public int lengthOfLIS(int[] nums) {
        mem = new int[nums.length+1][nums.length+1];
        return dfs(nums, 0, -1);
    }
    private int dfs(int[] nums, int curr, int last){
        if(curr==nums.length){
            return 0;
        }
        if( mem[curr][last+1]!=0){
            return mem[curr][last+1];
        }
        int notInclude = dfs(nums, curr+1, last), include = 0;
        if(last == -1 || nums[curr]>nums[last]){
            include = 1 + dfs(nums, curr+1, curr);
        }
        return mem[curr][last+1] = Math.max(include, notInclude);
    }
}
