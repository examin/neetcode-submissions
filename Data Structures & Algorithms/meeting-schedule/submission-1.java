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
        Collections.sort(intervals, (a,b)-> Integer.compare(a.start, b.start));
        Stack<Interval> stack = new Stack<>();
        for(Interval interval :  intervals){
            if(stack.isEmpty()){
                stack.push(interval);
            }else{
                if(stack.peek().end <= interval.start ){
                    stack.push(interval);
                }else{
                    // System.out.println(stack.peek().end+" >= "+ interval.start );
                    return false;
                }
            }
        }
        return true;
    }
}

