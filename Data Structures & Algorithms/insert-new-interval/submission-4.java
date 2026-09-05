class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // find insert location as intervals are already sorted so we will do binary search and get
        // location to insert then merge intervals using stack and finally return result;
        int insertAt = binarySearch(intervals, newInterval);
        Stack<int[]> stack = new Stack<>();
        // before insert locaiton
        for (int i = 0; i < insertAt; i++) {
            stack.push(intervals[i]);
        }
        if (stack.size() == 0) {
            stack.push(newInterval);
        } else if (stack.peek()[1] >= newInterval[0]) {
            stack.peek()[1] = Math.max(newInterval[1], stack.peek()[1]);
        } else {
            stack.push(newInterval);
        }

        // at and after inseart location
        for (int i = insertAt; i < intervals.length; i++) {
            if (stack.peek()[1] >= intervals[i][0]) {
                stack.peek()[1] = Math.max(intervals[i][1], stack.peek()[1]);
            } else {
                stack.push(intervals[i]);
            }
        }
        return stack.toArray(new int[stack.size()][]);
    }
    private int binarySearch(int[][] intervals, int[] newInterval) {
        int start = 0, end = intervals.length;
        int toFind = newInterval[0];

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (intervals[mid][0] < toFind) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}