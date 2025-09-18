class DesignAddandSearchWordsDataStructure {

    // Trie Node definition
    private class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new TrieNode[26]; // for 'a' to 'z'
            isEndOfWord = false;
        }
    }

    private TrieNode root;

    // Constructor
    public WordDictionary() {
        root = new TrieNode();
    }

    // Adds a word to the dictionary
    public void addWord(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.isEndOfWord = true;
    }

    // Searches a word in the dictionary with support for '.'
    public boolean search(String word) {
        return searchInNode(word, 0, root);
    }

    // Helper recursive function for search
    private boolean searchInNode(String word, int index, TrieNode node) {
        if (node == null) return false;

        for (int i = index; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (ch == '.') {
                // try all children
                for (int j = 0; j < 26; j++) {
                    if (node.children[j] != null) {
                        if (searchInNode(word, i + 1, node.children[j])) {
                            return true;
                        }
                    }
                }
                return false; // no match found
            } else {
                int pos = ch - 'a';
                if (node.children[pos] == null) {
                    return false;
                }
                node = node.children[pos];
            }
        }

        return node != null && node.isEndOfWord;
    }
}
