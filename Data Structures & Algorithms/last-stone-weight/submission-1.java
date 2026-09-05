class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length<2){
            return stones[0];
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone: stones){
            heap.offer(stone);
        }
        while(heap.size()>1){
            int first = heap.poll();
            int second = heap.poll();
            if(first==second){
                //done
            }else{
                int got = Math.abs(first-second);
                heap.offer(got);
            }
        }
        return heap.size()==0?0:heap.poll();
    }
}
