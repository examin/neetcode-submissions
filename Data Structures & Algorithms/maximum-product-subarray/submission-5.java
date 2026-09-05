class Solution {
    public int maxProduct(int[] nums) {
        int high = 1;
        int low = 1;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                high = 1;
                low = 1;
                result = Math.max(result, 0);

            } else {
                int newLow = Math.min(high * nums[i], low * nums[i]);
                int newHigh = Math.max(high * nums[i], low * nums[i]);
                low = newLow;
                high = newHigh;
                if (newHigh < 0) {
                    result = Math.max(result, nums[i]);
                    high = 1;
                }else{
                    result = Math.max(result, high);
                }
            }
            // System.out.println(high + ":" + low + ":" + result);

        }
        return result;
    }
    
}
