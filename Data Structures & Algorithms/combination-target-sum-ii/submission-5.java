class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(candidates);

        permutation(candidates, 0, result, new Stack<Integer>() , target);
        return new LinkedList<>(result);
    }
    private void permutation(int[] nums, int index, List<List<Integer>> result, Stack<Integer> curr , int target ){
        if(target==0){
            result.add(new LinkedList<>(curr));
            return;
        }
        if(target<0 || index>=nums.length){
            return;
        }
        for(int i  = index; i < nums.length;i++){
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            curr.push(nums[i]);
            permutation(nums, i+1, result, curr , target-nums[i]);
            curr.pop();
        }
        
    }
}