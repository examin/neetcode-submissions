class PrefixTree {
    HashMap<Character, PrefixTree> trie = new HashMap<>();
    Boolean end = false;
    
    public PrefixTree() {
         
    }

    public void insert(String word) {
        PrefixTree itr = this;
        for (char c : word.toCharArray()) {
            itr.trie.computeIfAbsent(c, k -> new PrefixTree());
            itr = itr.trie.get(c);
        }
        itr.end = true;
    }

    public boolean search(String word) {
        PrefixTree itr = this;
        for (char c : word.toCharArray()) {
            if(false == itr.trie.containsKey(c)){
                return false;
            }
            itr = itr.trie.get(c);
        }
        return itr.end;
    }

    public boolean startsWith(String prefix) {
        PrefixTree itr = this;
        int counter = 0;
        for (char c : prefix.toCharArray()) {
            if(false == itr.trie.containsKey(c)){
                return false;
            }
            itr = itr.trie.get(c);
        }
        return true;
    }
}
