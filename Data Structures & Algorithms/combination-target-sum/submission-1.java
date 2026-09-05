class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> subset = new Stack<>();
        int index = 0;
        int remainingTarget = target;
        // Fixes early termination bugs for unsorted inputs
        Arrays.sort(nums);
        combinationSum(nums, index, result, subset, remainingTarget);
        return result;
    }

    private void combinationSum(int[] nums, int index, List<List<Integer>> result, Stack<Integer> subset, int remainingTarget) {
        // Base Condition
        if (remainingTarget == 0) {
            result.add(new ArrayList<>(subset));
            return;
        }

        if (index >= nums.length || remainingTarget < nums[index]) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (remainingTarget < nums[index]) {
                break;
            }

            subset.push(nums[i]);
            combinationSum(nums, i, result, subset, remainingTarget - nums[i]);
            subset.pop();
        }
    }
}
