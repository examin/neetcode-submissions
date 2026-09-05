class Solution {
    public int findKthLargest(int[] arr, int k) {

        PriorityQueue<Integer> pq =
            new PriorityQueue<>(
                Arrays.stream(arr)
                      .boxed()
                      .toList()
            );

        while (pq.size() > k) {
            pq.poll();
        }

        return pq.peek();
    }
}