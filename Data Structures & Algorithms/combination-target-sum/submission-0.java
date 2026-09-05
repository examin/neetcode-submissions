class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet<>();

        combinationSum(nums,  target, 0, new Stack<Integer>(), result,  0);

        return new LinkedList<>(result);
        
    }
    private void combinationSum(int[] nums, int target, int index, Stack<Integer> stack,Set<List<Integer>> result, int count){
        
        if(count==target){
            result.add(new LinkedList<>(stack));
        }

        if(index>=nums.length||count>target){
            return;
        }
        

        combinationSum(nums,  target, index+1, stack, result,  count);
        stack.push(nums[index]);
        count+=nums[index];
        combinationSum(nums,  target, index, stack, result,  count);
        combinationSum(nums,  target, index+1, stack, result,  count);

        stack.pop();
    }
}
