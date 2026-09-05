class Solution {
    public List<String> generateParenthesis(int n) {
        Stack<Character> stack = new Stack<>();
        List<String> result= new LinkedList<>();
        permutation(n*2,  stack,result);
        return result;
    }
    private void permutation(int n, Stack<Character> stack, List<String> result){
        if(n<=0){
            if(valid(stack)){
                result.add(buildString(stack));
            }
            return;
        }
        stack.push('(');
        permutation(n-1, stack, result);
        stack.pop();

        stack.push(')');
        permutation(n-1,  stack,result);
        stack.pop();
    }
    private boolean valid(Stack<Character> stack){
        List<Character> list = new LinkedList<>(stack);
        Stack<Character> validateStack = new Stack<>();
        for(Character curr: list){
            if(curr=='('){
                validateStack.push('(');
            }
            if(curr==')'){
                if(validateStack.isEmpty()){
                    return false;
                }else{
                    validateStack.pop();
                }
            }
        }
        return validateStack.isEmpty();
    }
     private String buildString(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();

        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}
