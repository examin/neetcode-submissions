class Solution {
    Map<Integer, Integer> dp = new HashMap<>();
    public int jump(int[] nums) {
        dp.put(nums.length-1, 0);
        return jump(nums,0);
    }
    private int jump(int[] nums, int index){
        if(dp.containsKey(index)){
            return dp.get(index);
        }
        if( index >=nums.length-1 ){
            return -1;
        }
        
        int minSteps = Integer.MAX_VALUE;
        for(int itr = 0; itr < nums[index]; itr++){
            int stepsToEnd = jump(nums,index+itr+1);
            if(stepsToEnd != -1 && stepsToEnd < minSteps){
                minSteps = stepsToEnd;
            }
        }

        if(minSteps== Integer.MAX_VALUE){
            System.out.println(index+" : "+(minSteps+1));
            dp.put(index, -1);
            return -1;
        }else {
            System.out.println(index+" : "+(minSteps+1));
            dp.put(index, minSteps+1);
            return minSteps+1;
        }
    }
}
