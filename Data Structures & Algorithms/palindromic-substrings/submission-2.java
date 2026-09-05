class Solution {
    public int countSubstrings(String s) {
        int result = 0;

        for(int i = 0;i<s.length();i++){
            //odd
            int odd = palindromeLen(s, i, i+1);

            //even
            int even = palindromeLen(s, i, i);

            result += odd+even;
        }
        return result;
    }
    private int palindromeLen(String s, int first, int sec){
        System.out.println(first+":"+sec);
        int count = 0;
        while(first>=0 && sec<s.length() && s.charAt(first)==s.charAt(sec)){
            count++;
            first--;
            sec++;
        }
        // System.out.println(count);
        return count;
    }
}
