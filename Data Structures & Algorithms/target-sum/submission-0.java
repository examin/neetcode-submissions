class Solution {
    HashMap<Integer, HashMap<Integer, Integer>> mem;
    public int findTargetSumWays(int[] nums, int target) {
        mem = new HashMap<Integer, HashMap<Integer, Integer>>();
        for(int i =0;i<nums.length;i++){
            mem.put(i, new HashMap<>());
        }
        return findTargetSumWays(nums, target, 0, 0 );
    }
    private int findTargetSumWays(int[] nums, int target, int index, int sum){
        if(index>=nums.length){
            return target==sum?1:0;
        }
        if(mem.get(index).containsKey(sum)){
            return  mem.get(index).get(sum);
        }
        mem.get(index).put(sum, findTargetSumWays(nums, target, index+1, sum+nums[index] )
                + findTargetSumWays(nums, target, index+1, sum-nums[index] ));
        return mem.get(index).get(sum);
    }
}
