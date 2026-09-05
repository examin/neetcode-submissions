class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap =
                         new PriorityQueue<int[]>(
                                (a,b)-> Double.compare(distance(b,new int[]{0,0}),distance(a,new int[]{0,0}))
                         );

        for(int[] point: points){
            heap.offer(point);
            if(heap.size()>k){
                heap.poll();
            }
        }
        int[][] result = new int[heap.size()][2];
        int itr=0;
        while(heap.size()>0){
            result[itr++] = heap.poll();
        }
        return result;

    }
    private double distance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];
        return Math.sqrt(dx * dx + dy * dy);
    }
}
