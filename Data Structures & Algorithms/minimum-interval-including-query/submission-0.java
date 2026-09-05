class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] sortedQueries = Arrays.stream(queries).sorted().toArray();

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        Map<Integer, Integer> res = new HashMap<>();

        int itr = 0;

        for (int query : sortedQueries) {

            while (itr < intervals.length &&
                   intervals[itr][0] <= query) {

                pq.offer(new int[]{
                    intervals[itr][1] - intervals[itr][0] + 1,
                    intervals[itr][1]
                });

                itr++;
            }

            while (!pq.isEmpty() &&
                   pq.peek()[1] < query) {

                pq.poll();
            }

            res.put(query, pq.isEmpty() ? -1 : pq.peek()[0]);
        }

        int[] result = new int[queries.length];

        for (int j = 0; j < queries.length; j++) {
            result[j] = res.get(queries[j]);
        }

        return result;
    }
}