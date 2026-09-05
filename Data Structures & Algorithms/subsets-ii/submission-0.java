class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Stack<Integer> stack = new Stack<>();
        Set<List<Integer>> result = new HashSet<>();

        permute(nums, 0, result, stack);
        return new LinkedList<>(result);
    }
    private void permute(int[] nums, int index, Set<List<Integer>> result, Stack<Integer> stack){
        if(index==nums.length){
            result.add(new LinkedList<>(stack));
        }
        if(index>=nums.length){
            return;
        }
        
        permute(nums, index+1, result, stack);
            stack.push(nums[index]);
            permute(nums, index+1, result, stack);
            stack.pop();
        
    }
}
