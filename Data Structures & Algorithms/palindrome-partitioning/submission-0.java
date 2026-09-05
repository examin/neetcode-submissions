class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<>();
        Stack<Integer> curr = new Stack<>();
        curr.push(0);

        helper(s, 0, curr, result);

        return result;
    }

    private void helper(String str, int index, Stack<Integer> stack, List<List<String>> result) {

        // FIX: should be == not >
        if (index == str.length()) {
            storeResult(str, stack, result);
            return;
        }

        // FIX: loop syntax + include end character
        for (int i = index + 1; i <= str.length(); i++) {

            // substring end is exclusive, so palindrome check uses i-1
            if (isPalindrome(str, index, i - 1)) {
                stack.push(i);

                // next index should be i
                helper(str, i, stack, result);

                stack.pop();
            }
        }
    }

    private void storeResult(String str, Stack<Integer> stack, List<List<String>> result) {
        List<String> newResult = new LinkedList<>();

        // FIX: don't destroy original stack
        for (int i = 1; i < stack.size(); i++) {
            newResult.add(str.substring(stack.get(i - 1), stack.get(i)));
        }

        result.add(newResult);
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}