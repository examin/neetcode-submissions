class Solution {
    HashMap<String, Boolean> map = new HashMap<>();
    public boolean checkValidString(String s) {
        return dfs(s, 0, 0);
    }
    private boolean dfs(String s, int itr, int openCount){
        if(openCount<0){
            return false;
        }
        if(itr>=s.length()){
            return openCount==0;
        }
        if(map.containsKey(itr+":"+openCount)){
            return map.get(itr+":"+openCount);
        }
        boolean result= false;
        switch(s.charAt(itr)){
            case '(':
                result = dfs(s, itr+1, openCount+1);
                break;
            case ')':
                result = dfs(s, itr+1, openCount-1);
                break;
            case '*':
                result = dfs(s, itr+1, openCount+1) || dfs(s, itr+1, openCount-1) || dfs(s, itr+1, openCount);
                break;
        }
        map.put(itr + ":" + openCount, result);
        return result;
    }
}
