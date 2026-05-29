class Solution {

    class TrieNode {
        int idx;
        TrieNode[] children;

        TrieNode(int i) {
            idx = i;
            children = new TrieNode[26];
        }
    }

    private TrieNode getNode(int i) {
        return new TrieNode(i);
    }

    private void insertTrie(TrieNode root, int i, String[] wordsContainer) {
        String word = wordsContainer[i];
        int n = word.length();

        TrieNode crawl = root;

        for (int j = n - 1; j >= 0; j--) {
            int chIdx = word.charAt(j) - 'a';

            if (crawl.children[chIdx] == null) {
                crawl.children[chIdx] = getNode(i);
            }

            crawl = crawl.children[chIdx];

            // store index of shortest word
            if (wordsContainer[crawl.idx].length() > n) {
                crawl.idx = i;
            }
        }
    }

    private int search(TrieNode root, String word) {
        TrieNode crawl = root;
        int resultIdx = root.idx;

        int n = word.length();

        for (int i = n - 1; i >= 0; i--) {
            int chIdx = word.charAt(i) - 'a';

            if (crawl.children[chIdx] == null) {
                return resultIdx;
            }

            crawl = crawl.children[chIdx];
            resultIdx = crawl.idx;
        }

        return resultIdx;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        int m = wordsContainer.length;
        int n = wordsQuery.length;

        int[] result = new int[n];

        TrieNode root = getNode(0);

        for (int i = 0; i < m; i++) {

            // root stores shortest word index
            if (wordsContainer[root.idx].length() > wordsContainer[i].length()) {
                root.idx = i;
            }

            insertTrie(root, i, wordsContainer);
        }

        for (int i = 0; i < n; i++) {
            result[i] = search(root, wordsQuery[i]);
        }

        return result;
    }
}