/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a,b)->Integer.compare(a.start, b.start));
        int rooms = 0;
        PriorityQueue<Interval> heap = new PriorityQueue<>((a,b)->Integer.compare(a.end,b.end));
        for(Interval interval :  intervals){
            while(heap.size()>0 && heap.peek().end<=interval.start){
                heap.poll();
            }
            heap.offer(interval);
            rooms = Math.max(heap.size(), rooms);
        }
        return rooms;

    }
}
