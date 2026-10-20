class Solution {
    public boolean isAnagram(String s, String t) {
        int[] counter = new int[256];
        for(char curr: s.toCharArray()){
            counter[curr]++;
        } 
        for(char curr : t.toCharArray()){
            counter[curr]--;
        }
        for(int i =0;i<counter.length;i++){
            if(counter[i]!=0){
                return false;
            }
        }
        return true;
    }

}

