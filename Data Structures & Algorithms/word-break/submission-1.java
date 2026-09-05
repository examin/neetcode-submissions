class Solution {
    int[] mem ;
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        mem = new int[s.length()+1];
        Arrays.fill(mem, -1);
        for (String word : wordDict) {
            trie.add(word);
        }

        return dfs(s, trie, 0);
    }

    public boolean dfs(String s, Trie trie, int index) {
        if (index == s.length()) {
            return true;
        }
        if(mem[index]!=-1){
            return mem[index]==1;
        }

        TrieNode curr = trie.head;

        for (int i = index; i < s.length(); i++) {
            int pos = s.charAt(i) - 'a';

            if (curr.nodes[pos] == null) {
                break;
            }

            curr = curr.nodes[pos];

            // We found a complete dictionary word.
            if (curr.isEnd) {
                // Start looking for the next word from Trie root.
                if (dfs(s, trie, i + 1)) {
                    mem[index] = 1;
                    return true;
                }
            }
        }
        mem[index]=0;
        return false;
    }

    class TrieNode {
        TrieNode[] nodes = new TrieNode[26];
        boolean isEnd = false;
    }

    class Trie {
        TrieNode head;

        public Trie() {
            head = new TrieNode();
        }

        public void add(String s) {
            TrieNode itr = head;

            for (char curr : s.toCharArray()) {
                if (itr.nodes[curr - 'a'] == null) {
                    itr.nodes[curr - 'a'] = new TrieNode();
                }

                itr = itr.nodes[curr - 'a'];
            }

            itr.isEnd = true;
        }
    }
}