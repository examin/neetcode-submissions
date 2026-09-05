class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int last = cost[0];
        int lastSec = cost[1];
        for(int i = 2; i< cost.length;i++){
            int now = cost[i]+ Math.min(lastSec,last);
            last = lastSec;
            lastSec = now;
        }
        return Math.min(last, lastSec);
    }
}