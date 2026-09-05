class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[][] Arr = new int[nums.length][2];
        for(int i =0;i<nums.length;i++){
            Arr[i][0] = nums[i];
            Arr[i][1] = i;
        }
        Arrays.sort(Arr, (a, b)->(a[0]-b[0]));

        int i = 0, j = nums.length-1;
        while(i<j){
            int curr = Arr[i][0]+Arr[j][0];
            if(curr == target){
                return new int[]{Math.min(Arr[i][1], Arr[j][1]), Math.max(Arr[i][1], Arr[j][1])};
            }
            else if(curr<target){
                i++;
            } else{
                j--;
            }
        }
        return new int[]{-1,-1};
    }
}

