public class ImplementTrie {
    


    class Trie {
    static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }

    private TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    private TrieNode getNode() {
        return new TrieNode();
    }

    public void insert(String word) {
        TrieNode crawler = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (crawler.children[index] == null)
                crawler.children[index] = getNode();

            crawler = crawler.children[index];
        }

        crawler.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode crawler = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (crawler.children[index] == null)
                return false;
            crawler = crawler.children[index];
        }
        return crawler != null && crawler.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode crawler = root;
        int i = 0;
        for (i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';

            if (crawler.children[index] == null)
                return false;

            crawler = crawler.children[index];
        }
        return i == prefix.length();
    }
}

}