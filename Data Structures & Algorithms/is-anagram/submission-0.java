class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[256];

        // itr and populate counter of string s;
        for(char curr : s.toCharArray()){
            count[curr]++;
        }
        // itr and populate counter of string t;
        for(char curr : t.toCharArray()){
            count[curr]--;
        }

        //check all character exist
        for(int i  =0 ;i<256;i++){
            if(count[i]!=0){
                return false;
            }
        }
        return true;
    }
}
