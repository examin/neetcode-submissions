class Solution {
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length()-1;
        
        while(end>start && end>=0 && start<s.length() ){
            while( end>start &&end>=0&& start<s.length() && false == Character.isLetterOrDigit(s.charAt(start))){
                start++;
            }
            while(end>start &&end>=0&& start<s.length() && false == Character.isLetterOrDigit(s.charAt(end))){
                end--;
            }
            System.out.println(s.charAt(start)+" : "+s.charAt(end));
            if(Character.toLowerCase(s.charAt(start))!=Character.toLowerCase(s.charAt(end))){
                return false;
            }else{
                start++;
                end--;
            }
        }
        return true;
    }
}
