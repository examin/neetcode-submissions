class Solution {
    public String longestPalindrome(String s) {

        String result = "";

        for (int i = 0; i < s.length(); i++) {

            // Even length palindrome
            String evenLen = "";

            if (i != s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                evenLen = maxExpand(s, i, i + 1);
            }

            // Odd length palindrome
            String oddLen = maxExpand(s, i, i);

            if (evenLen.length() > result.length()) {
                result  = evenLen;
            }

            if (oddLen.length() > result.length()) {
                result  = oddLen;
            }
        }

        return result;
    }

    private String maxExpand(String s, int first, int sec) {

        while (inBound(s, first - 1, sec + 1)
                && s.charAt(first - 1) == s.charAt(sec + 1)) {

            first--;
            sec++;
        }
        // System.out.println(s.substring(first, sec+1));
        return s.substring(first, sec+1);
    }

    private boolean inBound(String s, int first, int sec) {
        return first >= 0 && sec < s.length();
    }
}