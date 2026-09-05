
class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    Trie trie;

    public Solution() {
        trie = new Trie();
    }

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            trie.insert(word);
        }

        Set<String> found = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char ch = board[i][j];

                if (trie.root.values[ch - 'a'] != null) {
                    dfs(board, i, j, found, trie.root);
                }
            }
        }

        return new LinkedList<>(found);
    }

    private void dfs(char[][] board, int row, int col, Set<String> found, TrieNode node) {
        char ch = board[row][col];

        TrieNode next = node.values[ch - 'a'];

        if (next == null) {
            return;
        }

        if (next.end) {
            found.add(next.word);
        }

        // mark visited
        board[row][col] = '#';

        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (valid(board, newRow, newCol) && board[newRow][newCol] != '#') {
                dfs(board, newRow, newCol, found, next);
            }
        }

        // restore
        board[row][col] = ch;
    }

    private boolean valid(char[][] board, int row, int col) {
        return row >= 0 && col >= 0 && row < board.length && col < board[0].length;
    }
}

class TrieNode {
    TrieNode[] values;
    boolean end;
    String word;

    public TrieNode() {
        values = new TrieNode[26];
        end = false;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode itr = root;

        for (char curr : word.toCharArray()) {
            if (itr.values[curr - 'a'] == null) {
                itr.values[curr - 'a'] = new TrieNode();
            }

            itr = itr.values[curr - 'a'];
        }

        itr.end = true;
        itr.word = word;
    }
}