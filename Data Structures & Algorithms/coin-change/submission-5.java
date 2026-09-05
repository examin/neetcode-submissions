class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[10001];
        Arrays.fill(dp, amount+1);
        for(int coin: coins){
            if(coin<=amount){
               dp[coin] = 1;
            }
        }
        dp[0] = 0;
        for(int i = 1; i<= amount; i++){
            if(dp[i] == 1){
                continue;
            }else{
                int min = amount+1;
                for(int coin: coins){
                    if(i>=coin){
                        min = Math.min(dp[i-coin]+1, min);
                    }
                }
                dp[i] = min;
            }
        }
        // System.out.println(Arrays.toString(dp));
        return (dp[amount]>amount)?-1:dp[amount];
    }
}


//[1][][]