class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        permutation(nums, 0, result, new Stack<Integer>() );
        return result;
    }
    private void permutation(int[] nums, int index, List<List<Integer>> result, Stack<Integer> curr ){
        if(index>=nums.length){
            result.add(new LinkedList<>(curr));
        }else{
            permutation(nums,  index+1, result, curr );
            curr.push(nums[index]);
            permutation(nums, index+1, result, curr );
            curr.pop();
        }
    }
    
}
