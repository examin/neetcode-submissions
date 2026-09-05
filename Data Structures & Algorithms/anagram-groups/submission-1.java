class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            int[] count = new int[26];
            for(char curr : s.toCharArray()){
                count[curr-'a']++;
            }
           
            map.putIfAbsent(Arrays.toString(count), new LinkedList<>());
            map.get(Arrays.toString(count)).add(s);
        }
        List<List<String>> result = new LinkedList<>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
                result.add(entry.getValue());
        }
        return result;
    }
}
