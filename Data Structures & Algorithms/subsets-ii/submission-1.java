class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Stack<Integer> stack = new Stack<>();
        List<List<Integer>> result = new LinkedList<>();

        permute(nums, 0, result, stack);
        return result;
    }
    private void permute(int[] nums, int index, List<List<Integer>> result, Stack<Integer> stack){
        result.add(new LinkedList<>(stack));
        if(index>=nums.length){
            return;
        }
        for(int i = index;i<nums.length;i++){
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            stack.push(nums[i]);
            permute(nums, i+1, result, stack);
            stack.pop();
        }
    }
}
