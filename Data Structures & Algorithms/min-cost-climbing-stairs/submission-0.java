class Solution {
    int[] mem = new int[2000];
    public int minCostClimbingStairs(int[] cost) {
        Arrays.fill(mem, -1);
        return Math.min(minCostClimbingStairs(cost, 0), minCostClimbingStairs(cost, 1));
    }
    private int minCostClimbingStairs( int[] cost, int index){
        if(index>=cost.length){
            return 0;
        }
        if(mem[index] != -1){
            return mem[index];
        }
        return mem[index] = cost[index]+Math.min(minCostClimbingStairs(cost, index+1), minCostClimbingStairs(cost, index+2));
    }
}