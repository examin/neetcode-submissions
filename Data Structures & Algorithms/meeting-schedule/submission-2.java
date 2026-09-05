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
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((a,b)->Integer.compare(a.start,b.start) );
        boolean result = true;
        int lastEnd = 0;
        for(Interval interval : intervals){
            if( lastEnd > interval.start){
                return false;
            }
            lastEnd = interval.end;
        }
        return result;
    }
}
