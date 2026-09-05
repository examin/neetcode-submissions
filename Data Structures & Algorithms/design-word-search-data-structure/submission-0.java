class WordDictionary {

    TrieNode root = new TrieNode();

    public WordDictionary() {
    }

    public void addWord(String word) {
        TrieNode itr = root;

        for (char curr : word.toCharArray()) {
            int c = curr - 'a';

            if (itr.node[c] == null) {
                itr.node[c] = new TrieNode();
            }

            itr = itr.node[c];
        }

        itr.isEnd = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int index, TrieNode itr) {

        for (int i = index; i < word.length(); i++) {

            char curr = word.charAt(i);

            if (curr == '.') {

                for (int j = 0; j < 26; j++) {

                    if (itr.node[j] != null) {

                        if (search(word, i + 1, itr.node[j])) {
                            return true;
                        }
                    }
                }

                return false;
            }

            int c = curr - 'a';

            if (itr.node[c] == null) {
                return false;
            }

            itr = itr.node[c];
        }

        return itr.isEnd;
    }
}

class TrieNode {
    TrieNode[] node = new TrieNode[26];
    boolean isEnd = false;
}