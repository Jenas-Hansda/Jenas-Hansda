class WordSearchII {
    class TrieNode {
        boolean isEnd;
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.isEnd = true;
            node.word = word;
        }
        return root;
    }

    List<String> result = new ArrayList<>();
    int rows, cols;
    int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};

    public List<String> findWords(char[][] board, String[] words) {
        rows = board.length;
        cols = board[0].length;

        TrieNode root = buildTrie(words);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(board, i, j, root);
            }
        }

        return result;
    }

    void dfs(char[][] board, int i, int j, TrieNode node) {
        char ch = board[i][j];
        if (ch == '#' || node.children[ch - 'a'] == null) return;

        node = node.children[ch - 'a'];
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // to avoid duplicates
        }

        board[i][j] = '#'; // mark visited
        for (int[] d : dirs) {
            int ni = i + d[0], nj = j + d[1];
            if (ni >= 0 && ni < rows && nj >= 0 && nj < cols) {
                dfs(board, ni, nj, node);
            }
        }
        board[i][j] = ch; // unmark
    }
}
