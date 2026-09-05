class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // Fix 1: Return the new interval if the original array is empty
        if (intervals.length == 0) {
            return new int[][] { newInterval };
        }
        
        List<int[]> intervalList = new LinkedList<>();
        boolean newIntervalInserted = false;
        
        if (newInterval[0] < intervals[0][0]) {
            intervalList.add(newInterval);
            newIntervalInserted = true;
        }
        
        for (int[] interval : intervals) {
            if (!newIntervalInserted && newInterval[0] < interval[0]) {
                intervalList.add(newInterval);
                newIntervalInserted = true;
            }
            intervalList.add(interval);
        }
        
        if (!newIntervalInserted) {
            intervalList.add(newInterval);
        }
        
        Stack<int[]> stack = new Stack<>();
        for (int[] interval : intervalList) {
            if (stack.isEmpty()) {
                stack.push(interval);
            } else {
                if (interval[0] <= stack.peek()[1]) {
                    stack.peek()[1] = Math.max(stack.peek()[1], interval[1]);
                } else {
                    stack.push(interval);
                }
            }
        }
        
        return stack.toArray(new int[stack.size()][]);
    }
}