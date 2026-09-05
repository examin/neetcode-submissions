class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        List<int[]> level1 = new LinkedList<>();
        List<int[]> level2 = new LinkedList<>();
        List<int[]> level3 = new LinkedList<>();

        for(int[] triplet: triplets){
            if(triplet[0]>target[0] || triplet[1]>target[1] || triplet[2]>target[2]){
                continue;
            }

            if(triplet[0]==target[0]){
                level1.add(triplet);
            }
            if(triplet[1]==target[1]){
                level2.add(triplet);
            }
            if(triplet[2]==target[2]){
                level3.add(triplet);
            }
        }

        if(level1.size()> 0 && level2.size()>0 &&level3.size()>0){
            return true;
        }else return false;
    }
}
