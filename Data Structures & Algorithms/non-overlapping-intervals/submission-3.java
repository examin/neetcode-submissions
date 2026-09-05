class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // i am thinking of sorting intervals by end and keeping what i selected last and sele
        Arrays.sort(intervals, (a,b)->Integer.compare(a[1],b[1]));
        int lastEnd = Integer.MIN_VALUE;
        int keepCount = 0;
        for(int[] interval : intervals){
            if(interval[0]>=lastEnd){
                keepCount++;
                lastEnd = interval[1];
            }
        }
        return intervals.length-keepCount;
    }
}
