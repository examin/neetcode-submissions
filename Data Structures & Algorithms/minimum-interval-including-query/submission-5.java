class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[][] sortedQueries  = sortWithIndex(queries);
        int[] result = new int[queries.length];
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));
        
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)-> Integer.compare(a[1]-a[0], b[1]-b[0]));
        int itr = 0;

        for(int[] query : sortedQueries){
            //remove top expired one
            while(itr<intervals.length&& intervals[itr][0]<=query[0]){
                // System.out.println("Added " + Arrays.toString(intervals[itr]));
                heap.offer(intervals[itr++]);
            }

            while(heap.size()>0&& heap.peek()[1]<query[0]){
                heap.poll();
            }
            
            int[] resultInterval = heap.isEmpty()?new int[]{2,0}:heap.peek();
            // System.out.println("For "+query[0]+ " answe is "+Arrays.toString(resultInterval));
            result[query[1]] = resultInterval[1]-resultInterval[0]+1;
        }

        return result;
    }

    private int[][] sortWithIndex(int[] queries){

        int[][] sortedQueries = new int[queries.length][2];
        for(int i =0;i<queries.length;i++){
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, (a,b)->Integer.compare(a[0], b[0]));
        return sortedQueries;
    }
}