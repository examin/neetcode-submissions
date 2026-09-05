class Solution {
    int maxSeen = Integer.MAX_VALUE;
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0) return 0;
        Stack<int[]> stack = new Stack<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        dfs(intervals, 0, stack);
        return maxSeen;
    }
    private void dfs(int[][] intervals, int index, Stack<int[]> stack) {
        if (index >= intervals.length) {
            // System.out.println(stack.stream().map(Arrays::toString).toList());
            maxSeen = Math.min(maxSeen, intervals.length - stack.size());
            return;
        }
        if (stack.isEmpty() || stack.peek()[1] <= intervals[index][0]) {
            stack.push(intervals[index]);
            dfs(intervals, index + 1, stack);
            stack.pop();
        }
        dfs(intervals, index + 1, stack);
    }
}
