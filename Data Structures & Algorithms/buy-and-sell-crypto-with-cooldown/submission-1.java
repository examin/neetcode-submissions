class Solution {
    int[][] mem;
    public int maxProfit(int[] prices) {
        mem = new int[prices.length][3];
        for(int[] itr : mem){
            Arrays.fill(itr, -1);
        }
        int result = maxProfit(prices, 0, 0);
        for(int[] itr : mem)
        System.out.println(Arrays.toString(itr));
        return result;

    }
   private int maxProfit(int[] prices, int index, int status){
        if(index>=prices.length){
            return 0;
        }
        if(mem[index][status]!=-1){
            return mem[index][status];
        }
        switch(status){
            case 0:
                return mem[index][status] = Math.max(
                    -prices[index]+maxProfit(prices, index+1, 1), maxProfit(prices, index+1, 0)
                );
            case 1 :
                return mem[index][status]= Math.max(
                        prices[index] + maxProfit(prices, index+1, 2),
                        maxProfit(prices, index+1, 1)
                    );
            case 2:
                return mem[index][status]= maxProfit(prices, index+1, 0);
        }
        return 0;
    }
}

// [ 1,3,4,0,4]
// 0 > can buy 
// 1 > sell is option
// 2 > cooldown

