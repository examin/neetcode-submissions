class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return new LinkedList<>();
        }
        HashMap<Character, List<Character>> phone = new HashMap<>();
        List<Character> two = new LinkedList<>();
        two.add('a');
        two.add('b');
        two.add('c');

        List<Character> three = new LinkedList<>();
        three.add('d');
        three.add('e');
        three.add('f');

        List<Character> four = new LinkedList<>();
        four.add('g');
        four.add('h');
        four.add('i');

        List<Character> five = new LinkedList<>();
        five.add('j');
        five.add('k');
        five.add('l');

        List<Character> six = new LinkedList<>();
        six.add('m');
        six.add('n');
        six.add('o');

        List<Character> seven = new LinkedList<>();
        seven.add('p');
                seven.add('q');
                        seven.add('r');
                                seven.add('s');

        List<Character> eight = new LinkedList<>();
        eight.add('t');
                eight.add('u');
                        eight.add('v');
                        

        List<Character> nine = new LinkedList<>();
        nine.add('w');
        nine.add('x');
        nine.add('y');
        nine.add('z');


        phone.put('2', two);
        phone.put('3', three);
        phone.put('4', four);
        phone.put('5', five);
        phone.put('6', six);
        phone.put('7', seven);
        phone.put('8', eight);
        phone.put('9', nine);

        List<String> result = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        helper( digits,  0, result, phone, stack);

        return result;
    }
    private void helper(String digits, int index, List<String> result, HashMap<Character, List<Character>> phone, Stack<Character> stack){
        if( index >= digits.length() ){
            StringBuilder sb = new StringBuilder();
            for (char c : stack) {
                    sb.append(c);  
            }

            result.add(sb.toString());
            // result.add(stack.toString());
            return;
        }
        Character currDigit = digits.charAt(index);
        List<Character> allCharacters = phone.get(currDigit);
        // System.out.println(allCharacters);

        for(Character curr : allCharacters){
            stack.push(curr);
            helper( digits,  index+1, result, phone, stack);
            stack.pop();
        }
    }
    
}
