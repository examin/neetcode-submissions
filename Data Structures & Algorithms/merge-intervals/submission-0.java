class Solution {
    public int[][] merge(int[][] intervals) {
        Stack<int[]> stack = new Stack<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for(int[] interval : intervals){
            if(stack.isEmpty()){
                stack.push(interval);
            }else {
                if( stack.peek()[1] >=interval[0] ){
                    stack.peek()[1] = Math.max(interval[1],stack.peek()[1]);
                }else {
                    stack.push(interval);
                }
            }
        }
        return stack.toArray(new int[stack.size()][]);
    }
}
