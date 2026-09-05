class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] mem = new int[1001];
        int result = 0;
        for(int i = nums.length-1;i>=0;i--){
            int max = 0;
            for(int j = i+1;j<nums.length;j++){
                if(nums[j]>nums[i] && mem[j]>max){
                    max = mem[j];
                }
            }
            mem[i] = 1 + max;
            result = Math.max(result, mem[i]);
        }
        System.out.println(Arrays.toString(mem));
        return result;
    }
}
