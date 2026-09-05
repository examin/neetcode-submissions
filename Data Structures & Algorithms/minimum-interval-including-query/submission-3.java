class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        // Sort intervals by start
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Store query value + original index
        int[][] sortedQueries = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i]; // query value
            sortedQueries[i][1] = i; // original index
        }

        // Sort queries by value
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        // Min heap based on interval length
        PriorityQueue<int[]> heap =
            new PriorityQueue<>((a, b) -> Integer.compare(a[1] - a[0], b[1] - b[0]));

        int[] result = new int[queries.length];

        int intervalItr = 0;

        for (int i = 0; i < sortedQueries.length; i++) {
            int query = sortedQueries[i][0];
            int originalIndex = sortedQueries[i][1];

            // Add all intervals that have started
            while (intervalItr < intervals.length && intervals[intervalItr][0] <= query) {
                heap.offer(intervals[intervalItr]);
                intervalItr++;
            }

            while (!heap.isEmpty() && heap.peek()[1] < query) {
                heap.poll();
            }

            // Smallest valid interval
            if (!heap.isEmpty()) {
                int[] interval = heap.peek();
                result[originalIndex] = interval[1] - interval[0] + 1;
            } else {
                result[originalIndex] = -1;
            }
        }

        return result;
    }
}