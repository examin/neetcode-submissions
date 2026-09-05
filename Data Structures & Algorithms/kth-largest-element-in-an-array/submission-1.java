class Solution {
    public int findKthLargest(int[] arr, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        
        for (int n : arr) {
            if (heap.size() < k) {
                heap.add(n);
            } else if (heap.peek() < n) {
                heap.poll();
                heap.add(n);
            }
        }
        return heap.poll();
    }
}