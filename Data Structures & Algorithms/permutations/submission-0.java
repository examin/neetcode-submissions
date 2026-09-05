class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        List<List<Integer>> result= new LinkedList<>();
        permute(nums, 0, visited, result, new Stack<Integer>());
        return result;
    }
    private void permute(int[] nums, int index, Set<Integer> visited, List<List<Integer>> result,   Stack<Integer> stack){
        if(index>nums.length){
            return;
        }
        if(index==nums.length){
            result.add(new LinkedList<>(stack));
        }

        for(int i = 0;i<nums.length;i++ ){
            if(visited.contains(i)==false){
                visited.add(i);
                stack.push(nums[i]);
                permute(nums, index+1, visited, result, stack);
                stack.pop();
                visited.remove(i);
            }
        }
    }
}
