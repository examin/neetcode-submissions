class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> store = new HashMap<>();
        for(String str : strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedChar = new String(charArray);
            store.putIfAbsent(sortedChar, new ArrayList<>());
            store.get(sortedChar).add(str);
        }
        return new LinkedList<>(store.values());
    }
}
