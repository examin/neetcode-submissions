public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        Stack<int[]> stack = new Stack<>();
        for(int[] interval : intervals){
            if(stack.size()>0 && stack.peek()[1]>=interval[0]) {
                stack.peek()[1] = Math.max(stack.peek()[1], interval[1]);
            }else{
                stack.push(interval);
            }
        }
        return stack.toArray(new int[stack.size()][]);
    }
}