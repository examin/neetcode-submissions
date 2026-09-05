class Solution {
    HashMap<String, Boolean> map = new HashMap<>();
    public boolean checkValidString(String s) {
        Stack<Integer> openList = new Stack<>();
        Stack<Integer> starList = new Stack<>();
        for(int i =0;i<s.length();i++){
            char curr = s.charAt(i);
            switch(curr){
                case '(':
                    openList.push(i);
                    break;
                case ')':
                    if(openList.size()>0){
                        openList.pop();
                    } else if(starList.size()>0){
                        starList.pop();
                    } else {
                        return false;
                    }

                    break;
                case '*':
                    starList.push(i);
                    break;
            }
        }
        while (!openList.isEmpty() && !starList.isEmpty()) {
            if (openList.pop() > starList.pop())
                return false;
        }
        return openList.isEmpty();
    }
}
